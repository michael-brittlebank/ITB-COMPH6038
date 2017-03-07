import BookShopGui.*;
import BookShopTabs.*;

public class BookShopApplication {

  /**
   * Main method for running the application
   * @param args String[]
   */
  public static void main(String[] args){
    //create main GUI elements
    BookShopFrame frame = new BookShopFrame();
    BookShopTabbedPane tabbedPane = new BookShopTabbedPane();

    //create tabs
    GetBooksTab getBooks = new GetBooksTab();
    UpdateBookTab updateBook = new UpdateBookTab();
    InsertBookTab insertBook = new InsertBookTab();
    DeleteBookTab deleteBook = new DeleteBookTab();

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