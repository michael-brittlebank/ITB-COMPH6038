package BookShopTabs;

import BookShopGui.BookShopTab;
import BookShopLogic.BookQueries;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateBookTab extends BookShopTab {

  //local variables
  private JTextField bookNameInput;
  private JTextField bookPriceInput;

  /**
   * Constructor for the update book tab
   */
  public UpdateBookTab(){
    //create main GUI elements
    this.setLabel("Update Book");
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    JPanel subPanel = new JPanel(new FlowLayout());
    subPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
    JButton submitButton = new JButton("Update Book");
    submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    //add listener to submit button
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        updateBook();
      }
    });

    int textFieldWidth = 250;
    int textFieldHeight = 30;
    //create input fields
    bookNameInput = new JTextField();
    bookNameInput.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
    JPanel bookNamePanel = new JPanel(new BorderLayout());
    bookNamePanel.setBorder(new TitledBorder("Book Name"));
    bookNamePanel.add(bookNameInput);

    bookPriceInput = new JTextField();
    bookPriceInput.setPreferredSize(new Dimension(textFieldWidth,textFieldHeight));
    JPanel bookPricePanel = new JPanel(new BorderLayout());
    bookPricePanel.setBorder(new TitledBorder("Price"));
    bookPricePanel.add(bookPriceInput);

    //add GUI elements to containers
    subPanel.add(bookNamePanel);
    subPanel.add(bookPricePanel);
    panel.add(subPanel);
    panel.add(submitButton);

    this.add(panel, BorderLayout.CENTER);
  }

  /**
   * Submit button listener to update book price by name
   */
  private void updateBook(){
    String bookName = bookNameInput.getText();
    String stringBookPrice = bookPriceInput.getText();
    if (bookName.isEmpty() || stringBookPrice.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Please fill out all fields", "Insufficient Information", JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        double bookPrice = Double.parseDouble(stringBookPrice);
        int result = BookQueries.updateBook(bookName,bookPrice);
        if (result > 0) {
          bookNameInput.setText("");
          bookPriceInput.setText("");
          JOptionPane.showMessageDialog(null, "Book Successfully Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "A book with the name \""+bookName+"\" was not found", "Unable to Update", JOptionPane.WARNING_MESSAGE);
        }
      } catch(NumberFormatException exception){
        JOptionPane.showMessageDialog(null, "Please enter a valid number for price", "Invalid Input", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}