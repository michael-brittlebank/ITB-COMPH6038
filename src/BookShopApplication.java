/*

you need to create a class BookShopApplication which contains the GUI elements; it should make use of a JTabbedPane that has 4 panes, each pane being associated with one of the above 4 operations on the database: display all books, update the price of a book, insert a book, and delete a book. This class should handle events associated with each operation, and it should also be executable (have a main method); the application should end once you close the window. A simple possible layout and the way the user should interact with the application is shown in the following screenshots (NOTE: you are not required to deal with NumberFormatException):


the tab for displaying all books:
the tab for updating the price of a book:
the tab for inserting a book:
the tab for deleting a book:

 */


import BookShopGui.*;
import BookShopTabs.*;

public class BookShopApplication {

  public static void main(String[] args){
    BookShopFrame frame = new BookShopFrame();
    BookShopTabbedPane tabbedPane = new BookShopTabbedPane();
    GetBooks getBooks = new GetBooks();
    UpdateBook updateBook = new UpdateBook();
    InsertBook insertBook = new InsertBook();
    DeleteBook deleteBook = new DeleteBook();

    //add tabs to tabbed pane
    tabbedPane.addTab("Display All Books", getBooks);
    tabbedPane.addTab("Update Price of a Book", updateBook);
    tabbedPane.addTab("Insert a New Book", insertBook);
    tabbedPane.addTab("Delete a Book", deleteBook);

    //add tabbed pane to frame
    frame.add(tabbedPane);
    frame.setVisible(true);
  }
}
