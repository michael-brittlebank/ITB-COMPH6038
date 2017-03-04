package BookShopTabs;

import BookShopGui.BookShopTab;
import BookShopLogic.BookQueries;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateBookTab extends BookShopTab {

  private JTextField bookNameInput;
  private JTextField bookPriceInput;

  public UpdateBookTab(){
    this.setLabel("Update Book");
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    JButton submitButton = new JButton("Update Book");
    submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        updateBook();
      }
    });
    JPanel subPanel = new JPanel(new FlowLayout());
    subPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
    int textFieldWidth = 250;
    int textFieldHeight = 30;

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

    subPanel.add(bookNamePanel);
    subPanel.add(bookPricePanel);
    panel.add(subPanel);
    panel.add(submitButton);

    this.add(panel, BorderLayout.CENTER);
  }

  private void updateBook(){
    String bookName = bookNameInput.getText();
    String stringBookPrice = bookPriceInput.getText();
    if (bookName.isEmpty() || stringBookPrice.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Please fill out all fields", "Insufficient Information", JOptionPane.ERROR_MESSAGE);
    } else {
      try {
        double bookPrice = Double.parseDouble(stringBookPrice);
        BookQueries queries = new BookQueries();
        int result = queries.updateBook(bookName,bookPrice);
        System.out.println(result);
        queries.closeConnection();
        if (result > 0) {
          bookNameInput.setText("");
          bookPriceInput.setText("");
          JOptionPane.showMessageDialog(null, "Book Successfully Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "A book with the name \""+bookName+"\" was not found", "Unable to Delete", JOptionPane.WARNING_MESSAGE);
        }
      } catch(NumberFormatException exception){
        JOptionPane.showMessageDialog(null, "Please enter a valid number for price", "Invalid Input", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}