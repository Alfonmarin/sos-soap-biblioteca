
/**
 * ETSIINFLibraryCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package es.upm.sos.client;

    /**
     *  ETSIINFLibraryCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ETSIINFLibraryCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ETSIINFLibraryCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ETSIINFLibraryCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for logout method
            * override this method for handling normal response from logout operation
            */
           public void receiveResultlogout(
                    es.upm.sos.client.ETSIINFLibraryStub.LogoutResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from logout operation
           */
            public void receiveErrorlogout(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for returnBook method
            * override this method for handling normal response from returnBook operation
            */
           public void receiveResultreturnBook(
                    es.upm.sos.client.ETSIINFLibraryStub.ReturnBookResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from returnBook operation
           */
            public void receiveErrorreturnBook(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for borrowBook method
            * override this method for handling normal response from borrowBook operation
            */
           public void receiveResultborrowBook(
                    es.upm.sos.client.ETSIINFLibraryStub.BorrowBookResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from borrowBook operation
           */
            public void receiveErrorborrowBook(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeBook method
            * override this method for handling normal response from removeBook operation
            */
           public void receiveResultremoveBook(
                    es.upm.sos.client.ETSIINFLibraryStub.RemoveBookResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeBook operation
           */
            public void receiveErrorremoveBook(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteUser method
            * override this method for handling normal response from deleteUser operation
            */
           public void receiveResultdeleteUser(
                    es.upm.sos.client.ETSIINFLibraryStub.DeleteUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteUser operation
           */
            public void receiveErrordeleteUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addUser method
            * override this method for handling normal response from addUser operation
            */
           public void receiveResultaddUser(
                    es.upm.sos.client.ETSIINFLibraryStub.AddUserResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addUser operation
           */
            public void receiveErroraddUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBook method
            * override this method for handling normal response from getBook operation
            */
           public void receiveResultgetBook(
                    es.upm.sos.client.ETSIINFLibraryStub.GetBookResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBook operation
           */
            public void receiveErrorgetBook(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listBooks method
            * override this method for handling normal response from listBooks operation
            */
           public void receiveResultlistBooks(
                    es.upm.sos.client.ETSIINFLibraryStub.ListBooksResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listBooks operation
           */
            public void receiveErrorlistBooks(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changePassword method
            * override this method for handling normal response from changePassword operation
            */
           public void receiveResultchangePassword(
                    es.upm.sos.client.ETSIINFLibraryStub.ChangePasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changePassword operation
           */
            public void receiveErrorchangePassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for login method
            * override this method for handling normal response from login operation
            */
           public void receiveResultlogin(
                    es.upm.sos.client.ETSIINFLibraryStub.LoginResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from login operation
           */
            public void receiveErrorlogin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addBook method
            * override this method for handling normal response from addBook operation
            */
           public void receiveResultaddBook(
                    es.upm.sos.client.ETSIINFLibraryStub.AddBookResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addBook operation
           */
            public void receiveErroraddBook(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBooksFromAuthor method
            * override this method for handling normal response from getBooksFromAuthor operation
            */
           public void receiveResultgetBooksFromAuthor(
                    es.upm.sos.client.ETSIINFLibraryStub.GetBooksFromAuthorResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBooksFromAuthor operation
           */
            public void receiveErrorgetBooksFromAuthor(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listBorrowedBooks method
            * override this method for handling normal response from listBorrowedBooks operation
            */
           public void receiveResultlistBorrowedBooks(
                    es.upm.sos.client.ETSIINFLibraryStub.ListBorrowedBooksResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listBorrowedBooks operation
           */
            public void receiveErrorlistBorrowedBooks(java.lang.Exception e) {
            }
                


    }
    