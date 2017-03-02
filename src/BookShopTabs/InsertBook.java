package BookShopTabs;

import BookShopGui.BookShopTab;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InsertBook extends BookShopTab {
  public InsertBook(){
    this.setLabel("Insert Book");
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    JButton submitButton = new JButton("Add New Book");
    submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    JPanel subPanel = new JPanel(new FlowLayout());
    subPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
    int textFieldWidth = 250;
    int textFieldHeight = 30;

    JTextField bookNameInput = new JTextField();
    bookNameInput.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
    JPanel bookNamePanel = new JPanel(new BorderLayout());
    bookNamePanel.setBorder(new TitledBorder("Book Name"));
    bookNamePanel.add(bookNameInput);

    JTextField bookAuthorInput = new JTextField();
    bookAuthorInput.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
    JPanel bookAuthorPanel = new JPanel(new BorderLayout());
    bookAuthorPanel.setBorder(new TitledBorder("Author Name"));
    bookAuthorPanel.add(bookAuthorInput);

    JTextField bookPriceInput = new JTextField();
    bookPriceInput.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
    JPanel bookPricePanel = new JPanel(new BorderLayout());
    bookPricePanel.setBorder(new TitledBorder("Price"));
    bookPricePanel.add(bookPriceInput);

    subPanel.add(bookNamePanel);
    subPanel.add(bookAuthorPanel);
    subPanel.add(bookPricePanel);
    panel.add(subPanel);
    panel.add(submitButton);

    this.add(panel, BorderLayout.CENTER);

  }
}