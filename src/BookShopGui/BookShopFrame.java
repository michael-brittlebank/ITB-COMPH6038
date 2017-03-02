package BookShopGui;

import javax.swing.*;

public class BookShopFrame extends JFrame {
  public BookShopFrame(){
    super("book shop frame");
    this.setSize(1000, 750);
    this.setVisible(false);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}