package BookShopGui;

import javax.swing.*;
import java.awt.*;

public class BookShopTab extends JPanel {
  public BookShopTab(){
    this.setLayout(new BorderLayout(10, 10));
  }

  public void setLabel(String labelText){
    JLabel label = new JLabel(labelText, SwingConstants.CENTER);
    this.add(label, BorderLayout.PAGE_START);
  }
}
