package BookShopGui;

import javax.swing.*;

public class BookShopFrame extends JFrame {

  /**
   * Constructor for main GUI container
   */
  public BookShopFrame(){
    super("book shop frame");
    this.setSize(1000, 750);
    this.setVisible(false);
    this.setResizable(false);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}