package es.upm.sos.practica2;

import es.upm.etsiinf.sos.*;
import es.upm.etsiinf.sos.AddUser;
import es.upm.etsiinf.sos.AddUserResponse;
import es.upm.etsiinf.sos.ChangePassword;
import es.upm.etsiinf.sos.ChangePasswordResponse;
import es.upm.etsiinf.sos.Login;
import es.upm.etsiinf.sos.LoginResponse;
import es.upm.etsiinf.sos.model.xsd.*;
import es.upm.sos.upmauth.stub.*;
import org.apache.axis2.context.*;
import org.apache.log4j.Logger;
import java.rmi.RemoteException;
import java.util.*;
import java.util.concurrent.*;
import es.upm.sos.upmauth.stub.UPMAuthenticationAuthorizationWSSkeletonStub.*;

public class ETSIINFLibrarySkeleton {
    private static final Logger logger = Logger.getLogger(ETSIINFLibrarySkeleton.class);
    
    private static final ConcurrentHashMap<String, Map<String, Integer>> sessionMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Book> books = new ConcurrentHashMap<>();
    private static final List<String> bookOrder = Collections.synchronizedList(new ArrayList<>());
    private static final ConcurrentHashMap<String, Integer> copiasDisponibles = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Set<String>> prestamosPorUsuario = new ConcurrentHashMap<>();
    private static UPMAuthenticationAuthorizationWSSkeletonStub upmStub;
    private User loggedUser;
    private List<User> users = new ArrayList<>();
    
    private String cleanPassword(String password) {
        if (password == null) return null;
        String cleaned = password.replaceAll("[^a-zA-Z0-9\\x20-\\x7E]", "");
        logger.debug("Cleaned password: '" + cleaned + "', length: " + cleaned.length() + ", bytes: " + Arrays.toString(cleaned.getBytes()));
        return cleaned;
    }
    
    public ETSIINFLibrarySkeleton() {
        try {
            upmStub = new UPMAuthenticationAuthorizationWSSkeletonStub(
                "http://138.100.15.190:8080/axis2/services/UPMAuthenticationAuthorizationWSSkeleton");
            
            User admin = new User();
            admin.setName("admin");
            admin.setPwd("admin");
            users.add(admin);
            
            Book book1 = new Book();
            book1.setISSN("978-0134685991");
            book1.setAuthors(new String[]{"Herbert Schildt"});
            book1.setName("Java: The Complete Reference");
            String issn1 = book1.getISSN().toUpperCase();
            books.put(issn1, book1);
            synchronized (bookOrder) {
                if (!bookOrder.contains(issn1)) {
                    bookOrder.add(issn1);
                }
            }
            copiasDisponibles.put(issn1, 1);
            
            Book book2 = new Book();
            book2.setISSN("978-0596009205");
            book2.setAuthors(new String[]{"Kathy Sierra", "Bert Bates"});
            book2.setName("Head First Java");
            String issn2 = book2.getISSN().toUpperCase();
            books.put(issn2, book2);
            synchronized (bookOrder) {
                if (!bookOrder.contains(issn2)) {
                    bookOrder.add(issn2);
                }
            }
            copiasDisponibles.put(issn2, 1);
        } catch (Exception e) {
            logger.error("Error initializing ETSIINFLibrarySkeleton", e);
        }
    }
    
    private String getSessionId() {
        try {
            MessageContext msgContext = MessageContext.getCurrentMessageContext();
            if (msgContext == null) {
                logger.warn("MessageContext is null, using fallback session ID");
                return "fallback-" + Thread.currentThread().getId();
            }
            
            ServiceContext serviceContext = msgContext.getServiceContext();
            if (serviceContext == null) {
                logger.warn("ServiceContext is null, using fallback session ID");
                return "fallback-" + Thread.currentThread().getId();
            }
            
            String sessionId = (String) serviceContext.getProperty("CUSTOM_SESSION_ID");
            if (sessionId == null) {
                sessionId = UUID.randomUUID().toString();
                serviceContext.setProperty("CUSTOM_SESSION_ID", sessionId);
                logger.debug("Generated new session ID: " + sessionId);
            } else {
                logger.debug("Retrieved existing session ID: " + sessionId);
            }
            return sessionId;
        } catch (Exception e) {
            logger.error("Error getting session ID", e);
            return "error-" + Thread.currentThread().getId();
        }
    }
    
    private String getCurrentUser(String sessionId) {
        Map<String, Integer> userSessions = sessionMap.get(sessionId);
        if (userSessions != null) {
            for (Map.Entry<String, Integer> entry : userSessions.entrySet()) {
                if (entry.getValue() > 0) {
                    logger.debug("Found active user: " + entry.getKey() + " for session ID: " + sessionId);
                    return entry.getKey();
                }
            }
        }
        logger.debug("No active user found for session ID: " + sessionId);
        return null;
    }
    
    public LoginResponse login(Login login) {
        LoginResponse response = new LoginResponse();
        Response innerResponse = new Response();
        response.set_return(innerResponse);
        
        if (login.getArgs0() == null || login.getArgs0().getName() == null || login.getArgs0().getPwd() == null) {
            logger.info("Invalid login parameters: name or password is null");
            innerResponse.setResponse(false);
            return response;
        }
        
        String name = login.getArgs0().getName();
        String password = login.getArgs0().getPwd();
        String sessionId = getSessionId();
        logger.debug("Login attempt for user " + name + " with session ID: " + sessionId + ", password: '" + password + "', length: " + password.length());
        
        String currentUser = getCurrentUser(sessionId);
        if (currentUser != null && !currentUser.equals(name)) {
            logger.info("Login attempt with different user " + name + " in session of " + currentUser);
            innerResponse.setResponse(false);
            return response;
        }
        
        Map<String, Integer> userSessions = sessionMap.computeIfAbsent(sessionId, k -> new ConcurrentHashMap<>());
        if (userSessions.containsKey(name) && userSessions.get(name) > 0) {
            logger.info("User " + name + " already logged in, allowing re-login");
            userSessions.put(name, userSessions.get(name) + 1);
            innerResponse.setResponse(true);
            loggedUser = new User();
            loggedUser.setName(name);
            loggedUser.setPwd(password);
            return response;
        }
        
        if ("admin".equals(name) && "admin".equals(password)) {
            logger.info("Admin login successful");
            userSessions.put(name, userSessions.getOrDefault(name, 0) + 1);
            innerResponse.setResponse(true);
            loggedUser = new User();
            loggedUser.setName(name);
            loggedUser.setPwd(password);
            return response;
        }
        
        try {
            LoginBackEnd loginBackEnd = new LoginBackEnd();
            loginBackEnd.setName(name);
            loginBackEnd.setPassword(password); // No cleaning
            logger.debug("Sending to UPM: username=" + name + ", password='" + password + "', length=" + password.length());
            
            UPMAuthenticationAuthorizationWSSkeletonStub.Login upmLogin = new UPMAuthenticationAuthorizationWSSkeletonStub.Login();
            upmLogin.setLogin(loginBackEnd);
            
            LoginResponseBackEnd upmResponse = upmStub.login(upmLogin).get_return();
            if (upmResponse != null && upmResponse.getResult()) {
                logger.info("User " + name + " login successful via UPM stub");
                userSessions.put(name, userSessions.getOrDefault(name, 0) + 1);
                innerResponse.setResponse(true);
                loggedUser = new User();
                loggedUser.setName(name);
                loggedUser.setPwd(password);
            } else {
                logger.info("User " + name + " login failed via UPM stub. Response: " + (upmResponse != null ? upmResponse.getResult() : "null"));
                innerResponse.setResponse(false);
            }
        } catch (RemoteException e) {
            logger.error("Error during login for user " + name + ": " + e.getMessage(), e);
            innerResponse.setResponse(false);
        }
        
        return response;
    }
    
    public LogoutResponse logout(Logout logout) {
        LogoutResponse logoutResponse = new LogoutResponse();
        Response response = new Response();
        logoutResponse.set_return(response);
        
        String sessionId = getSessionId();
        logger.debug("Logout attempt with session ID: " + sessionId);
        String username = getCurrentUser(sessionId);
        
        if (username == null) {
            logger.info("Logout attempted with no active session");
            response.setResponse(false);
            return logoutResponse;
        }
        
        Map<String, Integer> userSessions = sessionMap.get(sessionId);
        if (userSessions != null) {
            Integer count = userSessions.get(username);
            if (count != null && count > 1) {
                userSessions.put(username, count - 1);
            } else {
                userSessions.remove(username);
                if (userSessions.isEmpty()) {
                    sessionMap.remove(sessionId);
                }
            }
            logger.info("User " + username + " logged out successfully");
            response.setResponse(true);
            loggedUser = null;
        } else {
            logger.info("No sessions found for logout");
            response.setResponse(false);
        }
        
        return logoutResponse;
    }
    
    public AddUserResponse addUser(AddUser addUser) {
        AddUserResponse response = new AddUserResponse();
        es.upm.etsiinf.sos.model.xsd.AddUserResponse result = new es.upm.etsiinf.sos.model.xsd.AddUserResponse();
        response.set_return(result);
        
        String sessionId = getSessionId();
        String username = getCurrentUser(sessionId);
        if (username == null || !"admin".equals(username)) {
            logger.info("AddUser attempted by non-admin user: " + username);
            result.setResponse(false);
            result.setPwd(null);
            return response;
        }
        
        if (addUser.getArgs0() == null || addUser.getArgs0().getUsername() == null || addUser.getArgs0().getUsername().trim().isEmpty()) {
            result.setResponse(false);
            result.setPwd(null);
            return response;
        }
        
        try {
            UPMAuthenticationAuthorizationWSSkeletonStub.AddUser upmAddUser = new UPMAuthenticationAuthorizationWSSkeletonStub.AddUser();
            UserBackEnd userBackEnd = new UserBackEnd();
            userBackEnd.setName(addUser.getArgs0().getUsername());
            upmAddUser.setUser(userBackEnd);
            
            AddUserResponseBackEnd upmResult = upmStub.addUser(upmAddUser).get_return();
            if (upmResult != null) {
                result.setResponse(upmResult.getResult());
                String password = upmResult.getResult() ? upmResult.getPassword() : null;
                if (password != null) {
                    String rawPassword = password;
                    password = cleanPassword(password);
                    logger.debug("AddUser raw password for " + addUser.getArgs0().getUsername() + ": '" + rawPassword + "', length: " + rawPassword.length() + ", bytes: " + Arrays.toString(rawPassword.getBytes()));
                    logger.debug("AddUser cleaned password for " + addUser.getArgs0().getUsername() + ": '" + password + "', length: " + password.length());
                }
                result.setPwd(password);
                logger.info("AddUser " + addUser.getArgs0().getUsername() + " result: " + upmResult.getResult());
            } else {
                result.setResponse(false);
                result.setPwd(null);
            }
        } catch (RemoteException e) {
            logger.error("Error adding user " + addUser.getArgs0().getUsername() + ": " + e.getMessage(), e);
            result.setResponse(false);
            result.setPwd(null);
        }
        
        return response;
    }
    
    public DeleteUserResponse deleteUser(DeleteUser deleteUser) throws RemoteException {
        DeleteUserResponse response = new DeleteUserResponse();
        Response result = new Response();
        response.set_return(result);
        
        String sessionId = getSessionId();
        String currentUserName = getCurrentUser(sessionId);
        if (currentUserName == null || !currentUserName.equals("admin")) {
            logger.info("DeleteUser attempted by non-admin user: " + currentUserName);
            result.setResponse(false);
            return response;
        }
        
        if (deleteUser.getArgs0() == null || deleteUser.getArgs0().getUsername() == null || deleteUser.getArgs0().getUsername().trim().isEmpty()) {
            result.setResponse(false);
            return response;
        }
        String username = deleteUser.getArgs0().getUsername();
        
        if (username.equals("admin")) {
            logger.info("Attempt to delete admin user");
            result.setResponse(false);
            return response;
        }
        
        Set<String> userLoans = prestamosPorUsuario.get(username);
        if (userLoans != null && !userLoans.isEmpty()) {
            logger.info("User " + username + " has active loans");
            result.setResponse(false);
            return response;
        }
        
        RemoveUser removeUser = new RemoveUser();
        removeUser.setName(username);
        RemoveUserE removeUserE = new RemoveUserE();
        removeUserE.setRemoveUser(removeUser);
        
        try {
            RemoveUserResponse stubResult = upmStub.removeUser(removeUserE).get_return();
            if (stubResult != null && stubResult.getResult()) {
                Map<String, Integer> userSessions = sessionMap.get(sessionId);
                if (userSessions != null) {
                    userSessions.remove(username);
                }
                prestamosPorUsuario.remove(username);
                logger.info("User " + username + " deleted successfully");
                result.setResponse(true);
            } else {
                logger.info("Failed to delete user " + username + " via UPM stub");
                result.setResponse(false);
            }
        } catch (RemoteException e) {
            logger.error("Error deleting user " + username + ": " + e.getMessage(), e);
            result.setResponse(false);
        }
        
        return response;
    }
    
    public ChangePasswordResponse changePassword(ChangePassword changePassword) throws RemoteException {
        ChangePasswordResponse response = new ChangePasswordResponse();
        es.upm.etsiinf.sos.model.xsd.Response response_xsd = new es.upm.etsiinf.sos.model.xsd.Response();
        UPMAuthenticationAuthorizationWSSkeletonStub stub = new UPMAuthenticationAuthorizationWSSkeletonStub();
        UPMAuthenticationAuthorizationWSSkeletonStub.ChangePassword backend_pwd = new UPMAuthenticationAuthorizationWSSkeletonStub.ChangePassword();
        UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordResponseE backend_response = new UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordResponseE();
        UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordBackEnd backend_param = new UPMAuthenticationAuthorizationWSSkeletonStub.ChangePasswordBackEnd();

        if (loggedUser == null) {
            logger.info("ChangePassword attempted by unauthenticated user");
            response_xsd.setResponse(false);
        } else if (loggedUser.getName().equals("admin")) {
            User admin = new User();
            admin.setName("admin");
            admin.setPwd(changePassword.getArgs0().getNewpwd());
            users.set(0, admin);
            logger.info("Admin password changed successfully to '" + changePassword.getArgs0().getNewpwd() + "'");
            response_xsd.setResponse(true);
        } else {
            backend_param.setName(loggedUser.getName());
            backend_param.setOldpwd(changePassword.getArgs0().getOldpwd());
            backend_param.setNewpwd(changePassword.getArgs0().getNewpwd());
            logger.debug("ChangePassword for " + loggedUser.getName() + ": oldPwd='" + changePassword.getArgs0().getOldpwd() + "', newPwd='" + changePassword.getArgs0().getNewpwd() + "'");
            backend_pwd.setChangePassword(backend_param);
            try {
                backend_response = stub.changePassword(backend_pwd);
                boolean result = backend_response.get_return().getResult();
                logger.info("ChangePassword for user " + loggedUser.getName() + ": " + (result ? "succeeded" : "failed"));
                response_xsd.setResponse(result);
            } catch (RemoteException e) {
                logger.error("Error changing password for user " + loggedUser.getName() + ": " + e.getMessage(), e);
                response_xsd.setResponse(false);
            }
        }
        response.set_return(response_xsd);
        return response;
    }
    
    public BorrowBookResponse borrowBook(BorrowBook borrowBook) {
        BorrowBookResponse response = new BorrowBookResponse();
        Response result = new Response();
        response.set_return(result);
        
        String sessionId = getSessionId();
        String username = getCurrentUser(sessionId);
        if (username == null || "admin".equals(username)) {
            logger.info("BorrowBook attempted by invalid user: " + username);
            result.setResponse(false);
            return response;
        }
        
        String issn = borrowBook.getArgs0();
        if (issn == null || issn.trim().isEmpty() || !books.containsKey(issn)) {
            result.setResponse(false);
            return response;
        }
        
        Integer availableCopies = copiasDisponibles.get(issn);
        if (availableCopies == null || availableCopies <= 0) {
            logger.info("No copies available for ISSN: " + issn);
            result.setResponse(false);
            return response;
        }
        
        Set<String> userLoans = prestamosPorUsuario.getOrDefault(username, ConcurrentHashMap.newKeySet());
        if (userLoans.contains(issn)) {
            logger.info("User " + username + " already borrowed ISSN: " + issn);
            result.setResponse(false);
            return response;
        }
        
        synchronized (copiasDisponibles) {
            copiasDisponibles.compute(issn, (key, copies) -> copies == null ? 0 : copies - 1);
            prestamosPorUsuario.computeIfAbsent(username, k -> ConcurrentHashMap.newKeySet()).add(issn);
        }
        logger.info("User " + username + " borrowed ISSN: " + issn);
        result.setResponse(true);
        return response;
    }
    
    public ReturnBookResponse returnBook(ReturnBook returnBook) throws RemoteException {
        ReturnBookResponse response = new ReturnBookResponse();
        Response result = new Response();
        response.set_return(result);
        
        String sessionId = getSessionId();
        String username = getCurrentUser(sessionId);
        if (username == null || "admin".equals(username)) {
            logger.info("ReturnBook attempted by invalid user: " + username);
            result.setResponse(false);
            return response;
        }
        
        String issn = returnBook.getArgs0();
        if (issn == null || issn.trim().isEmpty() || !books.containsKey(issn)) {
            result.setResponse(false);
            return response;
        }
        
        Set<String> userLoans = prestamosPorUsuario.get(username);
        if (userLoans == null || !userLoans.contains(issn)) {
            logger.info("User " + username + " has not borrowed ISSN: " + issn);
            result.setResponse(false);
            return response;
        }
        
        synchronized (copiasDisponibles) {
            copiasDisponibles.compute(issn, (key, copies) -> copies == null ? 1 : copies + 1);
            userLoans.remove(issn);
            if (userLoans.isEmpty()) {
                prestamosPorUsuario.remove(username);
            }
        }
        logger.info("User " + username + " returned ISSN: " + issn);
        result.setResponse(true);
        return response;
    }
    
    public RemoveBookResponse removeBook(RemoveBook removeBook) {
        RemoveBookResponse response = new RemoveBookResponse();
        Response result = new Response();
        response.set_return(result);
        
        String sessionId = getSessionId();
        String username = getCurrentUser(sessionId);
        if (username == null || !"admin".equals(username)) {
            logger.info("RemoveBook attempted by non-admin user: " + username);
            result.setResponse(false);
            return response;
        }
        
        String issn = removeBook.getArgs0();
        if (issn == null || issn.trim().isEmpty() || !books.containsKey(issn)) {
            result.setResponse(false);
            return response;
        }
        
        for (Set<String> loans : prestamosPorUsuario.values()) {
            if (loans.contains(issn)) {
                logger.info("Cannot remove ISSN " + issn + ": book is borrowed");
                result.setResponse(false);
                return response;
            }
        }
        
        synchronized (books) {
            Integer copies = copiasDisponibles.compute(issn, (key, currentCopies) -> {
                if (currentCopies == null || currentCopies <= 0) {
                    return null;
                }
                if (currentCopies == 1) {
                    books.remove(issn);
                    synchronized (bookOrder) {
                        bookOrder.remove(issn);
                    }
                    return null;
                }
                return currentCopies - 1;
            });
            result.setResponse(copies == null && !books.containsKey(issn) || copies != null);
            if (result.getResponse()) {
                logger.info("Book ISSN " + issn + " removed successfully");
            }
        }
        
        return response;
    }
    
    public AddBookResponse addBook(AddBook addBook) {
        AddBookResponse response = new AddBookResponse();
        Response result = new Response();
        response.set_return(result);
        
        String sessionId = getSessionId();
        String username = getCurrentUser(sessionId);
        if (username == null || !"admin".equals(username)) {
            logger.info("AddBook attempted by non-admin user: " + username);
            result.setResponse(false);
            return response;
        }
        
        Book newBook = addBook.getArgs0();
        if (newBook == null || newBook.getISSN() == null || newBook.getISSN().trim().isEmpty() ||
            newBook.getName() == null || newBook.getName().trim().isEmpty() ||
            newBook.getAuthors() == null || newBook.getAuthors().length == 0) {
            logger.info("Invalid book data for ISBN: " + (newBook != null ? newBook.getISSN() : "null"));
            result.setResponse(false);
            return response;
        }
        
        synchronized (books) {
            String issn = newBook.getISSN().toUpperCase();
            if (books.containsKey(issn)) {
                copiasDisponibles.compute(issn, (key, copies) -> copies == null ? 1 : copies + 1);
                logger.info("Incremented copies for existing book ISBN: " + issn);
            } else {
                books.put(issn, newBook);
                synchronized (bookOrder) {
                    if (!bookOrder.contains(issn)) {
                        bookOrder.add(issn);
                    }
                }
                copiasDisponibles.put(issn, 1);
                logger.info("Added new book ISBN: " + issn);
            }
            result.setResponse(true);
        }
        
        return response;
    }
    
    public GetBooksFromAuthorResponse getBooksFromAuthor(GetBooksFromAuthor getBooksFromAuthor) {
        GetBooksFromAuthorResponse response = new GetBooksFromAuthorResponse();
        BookList bookList = new BookList();
        
        String sessionId = getSessionId();
        String username = getCurrentUser(sessionId);
        boolean isAuthenticated = username != null;
        bookList.setResult(isAuthenticated);
        
        if (!isAuthenticated) {
            bookList.setBookNames(new String[0]);
            bookList.setIssns(new String[0]);
            response.set_return(bookList);
            return response;
        }
        
        String authorName = getBooksFromAuthor.getArgs0() != null ? getBooksFromAuthor.getArgs0().getName() : null;
        if (authorName == null || authorName.trim().isEmpty()) {
            bookList.setBookNames(new String[0]);
            bookList.setIssns(new String[0]);
            response.set_return(bookList);
            return response;
        }
        
        List<String> matchingBookNames = new ArrayList<>();
        List<String> matchingIssns = new ArrayList<>();
        
        synchronized (bookOrder) {
            for (int i = bookOrder.size() - 1; i >= 0; i--) {
                String bookISSN = bookOrder.get(i);
                Book book = books.get(bookISSN);
                if (book != null && book.getAuthors() != null) {
                    for (String author : book.getAuthors()) {
                        if (authorName.equals(author)) {
                            matchingBookNames.add(book.getName());
                            matchingIssns.add(bookISSN);
                            break;
                        }
                    }
                }
            }
        }
        
        bookList.setBookNames(matchingBookNames.toArray(new String[0]));
        bookList.setIssns(matchingIssns.toArray(new String[0]));
        response.set_return(bookList);
        return response;
    }
    
    public ListBooksResponse listBooks(ListBooks listBooks) {
        ListBooksResponse response = new ListBooksResponse();
        BookList bookList = new BookList();
        
        String sessionId = getSessionId();
        String username = getCurrentUser(sessionId);
        boolean isAuthenticated = username != null;
        bookList.setResult(isAuthenticated);
        
        if (!isAuthenticated) {
            bookList.setBookNames(new String[0]);
            bookList.setIssns(new String[0]);
            response.set_return(bookList);
            return response;
        }
        
        synchronized (bookOrder) {
            int size = bookOrder.size();
            String[] bookNames = new String[size];
            String[] issns = new String[size];
            
            for (int i = 0; i < size; i++) {
                String bookISSN = bookOrder.get(size - 1 - i);
                Book book = books.get(bookISSN);
                if (book != null) {
                    bookNames[i] = book.getName();
                    issns[i] = bookISSN;
                } else {
                    bookNames[i] = "";
                    issns[i] = "";
                }
            }
            
            bookList.setBookNames(bookNames);
            bookList.setIssns(issns);
        }
        
        response.set_return(bookList);
        return response;
    }
    
    public GetBookResponse getBook(GetBook getBook) {
        GetBookResponse response = new GetBookResponse();
        
        String sessionId = getSessionId();
        String username = getCurrentUser(sessionId);
        if (username == null) {
            response.set_return(null);
            return response;
        }
        
        String issn = getBook.getArgs0();
        if (issn == null || issn.trim().isEmpty()) {
            response.set_return(null);
            return response;
        }
        
        response.set_return(books.get(issn));
        return response;
    }
    
    public ListBorrowedBooksResponse listBorrowedBooks(ListBorrowedBooks listBorrowedBooks) {
        ListBorrowedBooksResponse response = new ListBorrowedBooksResponse();
        BookList bookList = new BookList();
        response.set_return(bookList);
        
        String sessionId = getSessionId();
        String username = getCurrentUser(sessionId);
        if (username == null || "admin".equals(username)) {
            bookList.setResult(false);
            bookList.setBookNames(new String[0]);
            bookList.setIssns(new String[0]);
            return response;
        }
        
        Set<String> userLoans = prestamosPorUsuario.get(username);
        boolean hasLoans = userLoans != null && !userLoans.isEmpty();
        bookList.setResult(hasLoans);
        
        if (!hasLoans) {
            bookList.setBookNames(new String[0]);
            bookList.setIssns(new String[0]);
            return response;
        }
        
        List<String> borrowedBookNames = new ArrayList<>();
        List<String> borrowedIssns = new ArrayList<>();
        
        synchronized (bookOrder) {
            for (String issn : bookOrder) {
                if (userLoans.contains(issn)) {
                    Book book = books.get(issn);
                    if (book != null) {
                        borrowedIssns.add(issn);
                        borrowedBookNames.add(book.getName());
                    }
                }
            }
        }
        
        bookList.setBookNames(borrowedBookNames.toArray(new String[0]));
        bookList.setIssns(borrowedIssns.toArray(new String[0]));
        return response;
    }
}