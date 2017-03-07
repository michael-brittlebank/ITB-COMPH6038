package BookShopGui;

import javax.swing.*;
import java.awt.*;

public class BookShopTab extends JPanel {

  /**
   * Constructor for individual tab pane.  Extended in subclasses and so has protected access against explicit instantiation
   */
  protected BookShopTab(){
    //add whitespace space around tab content
    this.setLayout(new BorderLayout(10, 10));
  }

  /**
   * General setter method for declaring the tab pane's title label
   * @param labelText String
   */
  protected void setLabel(String labelText){
    //create new label and assign it to the header position within the BorderLayout
    JLabel label = new JLabel(labelText, SwingConstants.CENTER);
    this.add(label, BorderLayout.PAGE_START);
  }
}
