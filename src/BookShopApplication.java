import BookShopGui.*;
import BookShopTabs.*;

public class BookShopApplication {

  public static void main(String[] args){
    BookShopFrame frame = new BookShopFrame();
    BookShopTabbedPane tabbedPane = new BookShopTabbedPane();
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


/*
https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
http://stackoverflow.com/questions/9919230/disable-user-edit-in-jtable
 */