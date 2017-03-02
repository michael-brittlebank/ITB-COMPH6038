package BookShopGui;

import javax.swing.*;
import java.awt.*;

public class BookShopTab extends JPanel {
  public BookShopTab(){
    this.setLayout(new BorderLayout());
  }

  public void setLabel(String labelText){
    JLabel label = new JLabel(labelText);
    this.add(label);
  }
}
