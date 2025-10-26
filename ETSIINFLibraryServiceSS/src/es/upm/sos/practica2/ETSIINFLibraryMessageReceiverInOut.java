
/**
 * ETSIINFLibraryMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package es.upm.sos.practica2;

        /**
        *  ETSIINFLibraryMessageReceiverInOut message receiver
        */

        public class ETSIINFLibraryMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        ETSIINFLibrarySkeleton skel = (ETSIINFLibrarySkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("borrowBook".equals(methodName)){
                
                es.upm.etsiinf.sos.BorrowBookResponse borrowBookResponse53 = null;
	                        es.upm.etsiinf.sos.BorrowBook wrappedParam =
                                                             (es.upm.etsiinf.sos.BorrowBook)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.BorrowBook.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               borrowBookResponse53 =
                                                   
                                                   
                                                         skel.borrowBook(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), borrowBookResponse53, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "borrowBook"));
                                    } else 

            if("returnBook".equals(methodName)){
                
                es.upm.etsiinf.sos.ReturnBookResponse returnBookResponse55 = null;
	                        es.upm.etsiinf.sos.ReturnBook wrappedParam =
                                                             (es.upm.etsiinf.sos.ReturnBook)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.ReturnBook.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               returnBookResponse55 =
                                                   
                                                   
                                                         skel.returnBook(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), returnBookResponse55, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "returnBook"));
                                    } else 

            if("logout".equals(methodName)){
                
                es.upm.etsiinf.sos.LogoutResponse logoutResponse57 = null;
	                        es.upm.etsiinf.sos.Logout wrappedParam =
                                                             (es.upm.etsiinf.sos.Logout)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.Logout.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               logoutResponse57 =
                                                   
                                                   
                                                         skel.logout(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), logoutResponse57, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "logout"));
                                    } else 

            if("removeBook".equals(methodName)){
                
                es.upm.etsiinf.sos.RemoveBookResponse removeBookResponse59 = null;
	                        es.upm.etsiinf.sos.RemoveBook wrappedParam =
                                                             (es.upm.etsiinf.sos.RemoveBook)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.RemoveBook.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               removeBookResponse59 =
                                                   
                                                   
                                                         skel.removeBook(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), removeBookResponse59, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "removeBook"));
                                    } else 

            if("deleteUser".equals(methodName)){
                
                es.upm.etsiinf.sos.DeleteUserResponse deleteUserResponse61 = null;
	                        es.upm.etsiinf.sos.DeleteUser wrappedParam =
                                                             (es.upm.etsiinf.sos.DeleteUser)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.DeleteUser.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               deleteUserResponse61 =
                                                   
                                                   
                                                         skel.deleteUser(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), deleteUserResponse61, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "deleteUser"));
                                    } else 

            if("addUser".equals(methodName)){
                
                es.upm.etsiinf.sos.AddUserResponse addUserResponse63 = null;
	                        es.upm.etsiinf.sos.AddUser wrappedParam =
                                                             (es.upm.etsiinf.sos.AddUser)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.AddUser.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addUserResponse63 =
                                                   
                                                   
                                                         skel.addUser(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addUserResponse63, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "addUser"));
                                    } else 

            if("getBook".equals(methodName)){
                
                es.upm.etsiinf.sos.GetBookResponse getBookResponse65 = null;
	                        es.upm.etsiinf.sos.GetBook wrappedParam =
                                                             (es.upm.etsiinf.sos.GetBook)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.GetBook.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getBookResponse65 =
                                                   
                                                   
                                                         skel.getBook(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getBookResponse65, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "getBook"));
                                    } else 

            if("listBooks".equals(methodName)){
                
                es.upm.etsiinf.sos.ListBooksResponse listBooksResponse67 = null;
	                        es.upm.etsiinf.sos.ListBooks wrappedParam =
                                                             (es.upm.etsiinf.sos.ListBooks)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.ListBooks.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               listBooksResponse67 =
                                                   
                                                   
                                                         skel.listBooks(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), listBooksResponse67, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "listBooks"));
                                    } else 

            if("changePassword".equals(methodName)){
                
                es.upm.etsiinf.sos.ChangePasswordResponse changePasswordResponse69 = null;
	                        es.upm.etsiinf.sos.ChangePassword wrappedParam =
                                                             (es.upm.etsiinf.sos.ChangePassword)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.ChangePassword.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               changePasswordResponse69 =
                                                   
                                                   
                                                         skel.changePassword(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), changePasswordResponse69, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "changePassword"));
                                    } else 

            if("login".equals(methodName)){
                
                es.upm.etsiinf.sos.LoginResponse loginResponse71 = null;
	                        es.upm.etsiinf.sos.Login wrappedParam =
                                                             (es.upm.etsiinf.sos.Login)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.Login.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               loginResponse71 =
                                                   
                                                   
                                                         skel.login(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), loginResponse71, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "login"));
                                    } else 

            if("addBook".equals(methodName)){
                
                es.upm.etsiinf.sos.AddBookResponse addBookResponse73 = null;
	                        es.upm.etsiinf.sos.AddBook wrappedParam =
                                                             (es.upm.etsiinf.sos.AddBook)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.AddBook.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               addBookResponse73 =
                                                   
                                                   
                                                         skel.addBook(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), addBookResponse73, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "addBook"));
                                    } else 

            if("getBooksFromAuthor".equals(methodName)){
                
                es.upm.etsiinf.sos.GetBooksFromAuthorResponse getBooksFromAuthorResponse75 = null;
	                        es.upm.etsiinf.sos.GetBooksFromAuthor wrappedParam =
                                                             (es.upm.etsiinf.sos.GetBooksFromAuthor)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.GetBooksFromAuthor.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getBooksFromAuthorResponse75 =
                                                   
                                                   
                                                         skel.getBooksFromAuthor(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getBooksFromAuthorResponse75, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "getBooksFromAuthor"));
                                    } else 

            if("listBorrowedBooks".equals(methodName)){
                
                es.upm.etsiinf.sos.ListBorrowedBooksResponse listBorrowedBooksResponse77 = null;
	                        es.upm.etsiinf.sos.ListBorrowedBooks wrappedParam =
                                                             (es.upm.etsiinf.sos.ListBorrowedBooks)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    es.upm.etsiinf.sos.ListBorrowedBooks.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               listBorrowedBooksResponse77 =
                                                   
                                                   
                                                         skel.listBorrowedBooks(wrappedParam)
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), listBorrowedBooksResponse77, false, new javax.xml.namespace.QName("http://sos.etsiinf.upm.es",
                                                    "listBorrowedBooks"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.BorrowBook param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.BorrowBook.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.BorrowBookResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.BorrowBookResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.ReturnBook param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.ReturnBook.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.ReturnBookResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.ReturnBookResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.Logout param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.Logout.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.LogoutResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.LogoutResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.RemoveBook param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.RemoveBook.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.RemoveBookResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.RemoveBookResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.DeleteUser param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.DeleteUser.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.DeleteUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.DeleteUserResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.AddUser param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.AddUser.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.AddUserResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.AddUserResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.GetBook param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.GetBook.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.GetBookResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.GetBookResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.ListBooks param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.ListBooks.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.ListBooksResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.ListBooksResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.ChangePassword param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.ChangePassword.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.ChangePasswordResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.ChangePasswordResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.Login param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.Login.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.LoginResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.LoginResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.AddBook param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.AddBook.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.AddBookResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.AddBookResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.GetBooksFromAuthor param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.GetBooksFromAuthor.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.GetBooksFromAuthorResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.GetBooksFromAuthorResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.ListBorrowedBooks param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.ListBorrowedBooks.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(es.upm.etsiinf.sos.ListBorrowedBooksResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(es.upm.etsiinf.sos.ListBorrowedBooksResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.BorrowBookResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.BorrowBookResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.BorrowBookResponse wrapborrowBook(){
                                es.upm.etsiinf.sos.BorrowBookResponse wrappedElement = new es.upm.etsiinf.sos.BorrowBookResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.ReturnBookResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.ReturnBookResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.ReturnBookResponse wrapreturnBook(){
                                es.upm.etsiinf.sos.ReturnBookResponse wrappedElement = new es.upm.etsiinf.sos.ReturnBookResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.LogoutResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.LogoutResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.LogoutResponse wraplogout(){
                                es.upm.etsiinf.sos.LogoutResponse wrappedElement = new es.upm.etsiinf.sos.LogoutResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.RemoveBookResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.RemoveBookResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.RemoveBookResponse wrapremoveBook(){
                                es.upm.etsiinf.sos.RemoveBookResponse wrappedElement = new es.upm.etsiinf.sos.RemoveBookResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.DeleteUserResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.DeleteUserResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.DeleteUserResponse wrapdeleteUser(){
                                es.upm.etsiinf.sos.DeleteUserResponse wrappedElement = new es.upm.etsiinf.sos.DeleteUserResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.AddUserResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.AddUserResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.AddUserResponse wrapaddUser(){
                                es.upm.etsiinf.sos.AddUserResponse wrappedElement = new es.upm.etsiinf.sos.AddUserResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.GetBookResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.GetBookResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.GetBookResponse wrapgetBook(){
                                es.upm.etsiinf.sos.GetBookResponse wrappedElement = new es.upm.etsiinf.sos.GetBookResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.ListBooksResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.ListBooksResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.ListBooksResponse wraplistBooks(){
                                es.upm.etsiinf.sos.ListBooksResponse wrappedElement = new es.upm.etsiinf.sos.ListBooksResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.ChangePasswordResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.ChangePasswordResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.ChangePasswordResponse wrapchangePassword(){
                                es.upm.etsiinf.sos.ChangePasswordResponse wrappedElement = new es.upm.etsiinf.sos.ChangePasswordResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.LoginResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.LoginResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.LoginResponse wraplogin(){
                                es.upm.etsiinf.sos.LoginResponse wrappedElement = new es.upm.etsiinf.sos.LoginResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.AddBookResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.AddBookResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.AddBookResponse wrapaddBook(){
                                es.upm.etsiinf.sos.AddBookResponse wrappedElement = new es.upm.etsiinf.sos.AddBookResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.ListBorrowedBooksResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.ListBorrowedBooksResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.ListBorrowedBooksResponse wraplistBorrowedBooks(){
                                es.upm.etsiinf.sos.ListBorrowedBooksResponse wrappedElement = new es.upm.etsiinf.sos.ListBorrowedBooksResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, es.upm.etsiinf.sos.GetBooksFromAuthorResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(es.upm.etsiinf.sos.GetBooksFromAuthorResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private es.upm.etsiinf.sos.GetBooksFromAuthorResponse wrapgetBooksFromAuthor(){
                                es.upm.etsiinf.sos.GetBooksFromAuthorResponse wrappedElement = new es.upm.etsiinf.sos.GetBooksFromAuthorResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (es.upm.etsiinf.sos.BorrowBook.class.equals(type)){
                
                           return es.upm.etsiinf.sos.BorrowBook.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.BorrowBookResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.BorrowBookResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.ReturnBook.class.equals(type)){
                
                           return es.upm.etsiinf.sos.ReturnBook.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.ReturnBookResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.ReturnBookResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.Logout.class.equals(type)){
                
                           return es.upm.etsiinf.sos.Logout.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.LogoutResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.LogoutResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.RemoveBook.class.equals(type)){
                
                           return es.upm.etsiinf.sos.RemoveBook.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.RemoveBookResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.RemoveBookResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.DeleteUser.class.equals(type)){
                
                           return es.upm.etsiinf.sos.DeleteUser.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.DeleteUserResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.DeleteUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.AddUser.class.equals(type)){
                
                           return es.upm.etsiinf.sos.AddUser.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.AddUserResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.AddUserResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.GetBook.class.equals(type)){
                
                           return es.upm.etsiinf.sos.GetBook.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.GetBookResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.GetBookResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.ListBooks.class.equals(type)){
                
                           return es.upm.etsiinf.sos.ListBooks.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.ListBooksResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.ListBooksResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.ChangePassword.class.equals(type)){
                
                           return es.upm.etsiinf.sos.ChangePassword.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.ChangePasswordResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.ChangePasswordResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.Login.class.equals(type)){
                
                           return es.upm.etsiinf.sos.Login.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.LoginResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.LoginResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.AddBook.class.equals(type)){
                
                           return es.upm.etsiinf.sos.AddBook.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.AddBookResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.AddBookResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.GetBooksFromAuthor.class.equals(type)){
                
                           return es.upm.etsiinf.sos.GetBooksFromAuthor.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.GetBooksFromAuthorResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.GetBooksFromAuthorResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.ListBorrowedBooks.class.equals(type)){
                
                           return es.upm.etsiinf.sos.ListBorrowedBooks.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (es.upm.etsiinf.sos.ListBorrowedBooksResponse.class.equals(type)){
                
                           return es.upm.etsiinf.sos.ListBorrowedBooksResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    