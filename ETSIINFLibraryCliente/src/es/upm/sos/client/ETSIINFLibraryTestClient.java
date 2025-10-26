
package es.upm.sos.client;

import es.upm.sos.client.ETSIINFLibraryStub.*;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import java.util.Arrays;

public class ETSIINFLibraryTestClient {
    public static void main(String[] args) throws Exception {
        ConfigurationContext configContext = ConfigurationContextFactory.createConfigurationContextFromFileSystem("repository");
        String endpoint = "http://localhost:8080/axis2/services/ETSIINFLibrary";

        ETSIINFLibraryStub stub = new ETSIINFLibraryStub(configContext, endpoint);
        ETSIINFLibraryStub stub2 = new ETSIINFLibraryStub(configContext, endpoint);
        ETSIINFLibraryStub stub3 = new ETSIINFLibraryStub(configContext, endpoint);
        ETSIINFLibraryStub stub4 = new ETSIINFLibraryStub(configContext, endpoint); // New stub for Veltor88

        stub._getServiceClient().engageModule("addressing");
        stub2._getServiceClient().engageModule("addressing");
        stub3._getServiceClient().engageModule("addressing");
        stub4._getServiceClient().engageModule("addressing");
        stub._getServiceClient().getOptions().setManageSession(true);
        stub2._getServiceClient().getOptions().setManageSession(true);
        stub3._getServiceClient().getOptions().setManageSession(true);
        stub4._getServiceClient().getOptions().setManageSession(true);

        User admin = new User();
        User xyber9K = new User();
        User quorix7Z = new User();
        User veltor88 = new User();

        admin.setName("admin");
        admin.setPwd("admin");
        xyber9K.setName("Xyber9K");
        quorix7Z.setName("Quorix7Z");
        veltor88.setName("Veltor88");

        Login login = new Login();
        login.setArgs0(admin);
        LoginResponse lr = stub.login(login);
        System.out.println("LOGIN (admin): " + lr.get_return().getResponse());

        DeleteUser du = new DeleteUser();
        Username admName = new Username();
        admName.setUsername("admin");
        du.setArgs0(admName);
        System.out.println("DeleteUser (admin deletes admin): " + stub.deleteUser(du).get_return().getResponse());

        AddUser xyberAddUser = new AddUser();
        Username xyberName = new Username();
        xyberName.setUsername("Xyber9K");
        xyberAddUser.setArgs0(xyberName);
        du.setArgs0(xyberName);
        System.out.println("DeleteUser (admin deletes Xyber9K): " + stub.deleteUser(du).get_return().getResponse());
        AddUserResponse addUserRes = stub.addUser(xyberAddUser).get_return();
        String xyberPwd = addUserRes.getPwd();
        xyber9K.setPwd(xyberPwd);
        System.out.println("AddUser (admin adds Xyber9K): " + addUserRes.getResponse() + ", password: " + xyberPwd);
        if (xyberPwd != null) {
            System.out.println("Raw Xyber9K password: '" + xyberPwd + "', length: " + xyberPwd.length());
            System.out.println("Raw Xyber9K password bytes: " + Arrays.toString(xyberPwd.getBytes()));
            StringBuilder rawChars = new StringBuilder();
            for (char c : xyberPwd.toCharArray()) {
                rawChars.append(String.format("\\u%04x", (int) c));
            }
            System.out.println("Xyber9K password raw chars: " + rawChars);
        }

        AddUser quorixAddUser = new AddUser();
        Username quorixName = new Username();
        quorixName.setUsername("Quorix7Z");
        quorixAddUser.setArgs0(quorixName);
        du.setArgs0(quorixName);
        System.out.println("DeleteUser (admin deletes Quorix7Z): " + stub.deleteUser(du).get_return().getResponse());
        addUserRes = stub.addUser(quorixAddUser).get_return();
        String quorixPwd = addUserRes.getPwd();
        quorix7Z.setPwd(quorixPwd);
        System.out.println("AddUser (admin adds Quorix7Z): " + addUserRes.getResponse() + ", password: " + quorixPwd);

        AddUser veltorAddUser = new AddUser();
        Username veltorName = new Username();
        veltorName.setUsername("Veltor88");
        veltorAddUser.setArgs0(veltorName);
        du.setArgs0(veltorName);
        System.out.println("DeleteUser (admin deletes Veltor88): " + stub.deleteUser(du).get_return().getResponse());
        addUserRes = stub.addUser(veltorAddUser).get_return();
        String veltorPwd = addUserRes.getPwd();
        veltor88.setPwd(veltorPwd);
        System.out.println("AddUser (admin adds Veltor88): " + addUserRes.getResponse() + ", password: " + veltorPwd);

        AddBook addBook = new AddBook();
        Book book1 = new Book();
        book1.setISSN("978-0134685991");
        book1.setName("Java: The Complete Reference");
        book1.setAuthors(new String[]{"Herbert Schildt"});
        addBook.setArgs0(book1);
        System.out.println("AddBook (admin adds Java book): " + stub.addBook(addBook).get_return().getResponse());

        Book book2 = new Book();
        book2.setISSN("978-0596009205");
        book2.setName("Head First Java");
        book2.setAuthors(new String[]{"Kathy Sierra", "Bert Bates"});
        addBook.setArgs0(book2);
        System.out.println("AddBook (admin adds Head First Java): " + stub.addBook(addBook).get_return().getResponse());

        login.setArgs0(xyber9K);
        lr = stub2.login(login);
        System.out.println("LOGIN (Xyber9K 1): " + lr.get_return().getResponse());
        lr = stub2.login(login);
        System.out.println("LOGIN (Xyber9K 2): " + lr.get_return().getResponse());
        lr = stub2.login(login);
        System.out.println("LOGIN (Xyber9K 3): " + lr.get_return().getResponse());

        login.setArgs0(veltor88);
        lr = stub4.login(login); // Use stub4 for Veltor88
        System.out.println("LOGIN (Veltor88): " + lr.get_return().getResponse());

        ChangePassword cp = new ChangePassword();
        PasswordPair pp = new PasswordPair();
        pp.setOldpwd(xyber9K.getPwd());
        pp.setNewpwd("Xyber9K123");
        cp.setArgs0(pp);
        System.out.println("Attempting ChangePassword for Xyber9K, oldPwd: '" + xyber9K.getPwd() + "', length: " + (xyber9K.getPwd() != null ? xyber9K.getPwd().length() : 0));
        if (xyber9K.getPwd() != null) {
            System.out.println("Raw oldPwd bytes: " + Arrays.toString(xyber9K.getPwd().getBytes()));
            StringBuilder rawChars = new StringBuilder();
            for (char c : xyber9K.getPwd().toCharArray()) {
                rawChars.append(String.format("\\u%04x", (int) c));
            }
            System.out.println("ChangePassword oldPwd raw chars: " + rawChars);
        }
        boolean changePasswordSuccess = stub2.changePassword(cp).get_return().getResponse();
        System.out.println("ChangePassword (Xyber9K): " + changePasswordSuccess);
        if (changePasswordSuccess) {
            xyber9K.setPwd("Xyber9K123");
        }

        // Test admin password change
        login.setArgs0(admin);
        stub.login(login);
        cp = new ChangePassword();
        pp = new PasswordPair();
        pp.setOldpwd("admin");
        pp.setNewpwd("admin123");
        cp.setArgs0(pp);
        System.out.println("ChangePassword (admin): " + stub.changePassword(cp).get_return().getResponse());

        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setArgs0("978-0134685991");
        System.out.println("BorrowBook (Xyber9K borrows Java book): " + stub2.borrowBook(borrowBook).get_return().getResponse());

        System.out.println("BorrowBook (Xyber9K borrows Java book again): " + stub2.borrowBook(borrowBook).get_return().getResponse());

        ListBorrowedBooks listBorrowed = new ListBorrowedBooks();
        BookList borrowedList = stub2.listBorrowedBooks(listBorrowed).get_return();
        System.out.print("ListBorrowedBooks (Xyber9K): " + borrowedList.getResult() + " | books: ");
        String[] bookNames = borrowedList.getBookNames() != null ? borrowedList.getBookNames() : new String[0];
        String[] issns = borrowedList.getIssns() != null ? borrowedList.getIssns() : new String[0];
        if (bookNames.length > 0 && issns.length > 0) {
            System.out.print(bookNames[0] + " (" + issns[0] + ")");
            for (int i = 1; i < bookNames.length && i < issns.length; i++) {
                System.out.print(", " + bookNames[i] + " (" + issns[i] + ")");
            }
        }
        System.out.println();

        ReturnBook returnBook = new ReturnBook();
        returnBook.setArgs0("978-0134685991");
        System.out.println("ReturnBook (Xyber9K returns Java book): " + stub2.returnBook(returnBook).get_return().getResponse());

        Logout logout = new Logout();
        System.out.println("LOGOUT (Xyber9K 1): " + stub2.logout(logout).get_return().getResponse());
        System.out.println("LOGOUT (Xyber9K 2): " + stub2.logout(logout).get_return().getResponse());
        System.out.println("LOGOUT (Xyber9K 3): " + stub2.logout(logout).get_return().getResponse());

        login.setArgs0(quorix7Z);
        lr = stub3.login(login);
        System.out.println("LOGIN (Quorix7Z): " + lr.get_return().getResponse());

        ListBooks listBooks = new ListBooks();
        BookList bookList = stub3.listBooks(listBooks).get_return();
        System.out.print("ListBooks (Quorix7Z): " + bookList.getResult() + " | books: ");
        bookNames = bookList.getBookNames() != null ? bookList.getBookNames() : new String[0];
        issns = bookList.getIssns() != null ? bookList.getIssns() : new String[0];
        if (bookNames.length > 0 && issns.length > 0) {
            System.out.print(bookNames[0] + " (" + issns[0] + ")");
            for (int i = 1; i < bookNames.length && i < issns.length; i++) {
                System.out.print(", " + bookNames[i] + " (" + issns[i] + ")");
            }
        }
        System.out.println();

        GetBooksFromAuthor getBooksByAuthor = new GetBooksFromAuthor();
        Author author = new Author();
        author.setName("Kathy Sierra");
        getBooksByAuthor.setArgs0(author);
        bookList = stub3.getBooksFromAuthor(getBooksByAuthor).get_return();
        System.out.print("GetBooksFromAuthor (Quorix7Z, Kathy Sierra): " + bookList.getResult() + " | books: ");
        bookNames = bookList.getBookNames() != null ? bookList.getBookNames() : new String[0];
        issns = bookList.getIssns() != null ? bookList.getIssns() : new String[0];
        if (bookNames.length > 0 && issns.length > 0) {
            System.out.print(bookNames[0] + " (" + issns[0] + ")");
            for (int i = 1; i < bookNames.length && i < issns.length; i++) {
                System.out.print(", " + bookNames[i] + " (" + issns[i] + ")");
            }
        }
        System.out.println();

        GetBook getBook = new GetBook();
        getBook.setArgs0("978-0596009205");
        Book book = stub3.getBook(getBook).get_return();
        System.out.println("GetBook (Quorix7Z, Head First Java): " + (book != null ? book.getName() : "null"));

        System.out.println("LOGOUT (Quorix7Z): " + stub3.logout(logout).get_return().getResponse());

        RemoveBook removeBook = new RemoveBook();
        removeBook.setArgs0("978-0596009205");
        System.out.println("RemoveBook (admin removes Head First Java): " + stub.removeBook(removeBook).get_return().getResponse());

        bookList = stub.listBooks(listBooks).get_return();
        System.out.print("ListBooks (admin after removal): " + bookList.getResult() + " | books: ");
        bookNames = bookList.getBookNames() != null ? bookList.getBookNames() : new String[0];
        issns = bookList.getIssns() != null ? bookList.getIssns() : new String[0];
        if (bookNames.length > 0 && issns.length > 0) {
            System.out.print(bookNames[0] + " (" + issns[0] + ")");
            for (int i = 1; i < bookNames.length && i < issns.length; i++) {
                System.out.print(", " + bookNames[i] + " (" + issns[i] + ")");
            }
        }
        System.out.println();

        System.out.println("LOGOUT (admin): " + stub.logout(logout).get_return().getResponse());

        User invalidUser = new User();
        invalidUser.setName("Zorak99X");
        invalidUser.setPwd("wrongpass789");
        login.setArgs0(invalidUser);
        lr = stub.login(login);
        System.out.println("LOGIN (Zorak99X): " + lr.get_return().getResponse());
    }
}