package BookShopTabs;

import BookShopGui.BookShopTab;
import BookShopLogic.BookQueries;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBookTab extends BookShopTab {

  private JTextField bookNameInput;

  public DeleteBookTab(){
    this.setLabel("Delete Book");
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    JButton submitButton = new JButton("Delete Book");
    submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        deleteBook();
      }
    });
    JPanel subPanel = new JPanel(new FlowLayout());
    subPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));

    bookNameInput = new JTextField();
    bookNameInput.setPreferredSize(new Dimension(250,30));
    JPanel bookNamePanel = new JPanel(new BorderLayout());
    bookNamePanel.setBorder(new TitledBorder("Book Name"));
    bookNamePanel.add(bookNameInput);

    subPanel.add(bookNamePanel);
    panel.add(subPanel);
    panel.add(submitButton);

    this.add(panel, BorderLayout.CENTER);
  }

  private void deleteBook(){
    String bookName = bookNameInput.getText();
    if (bookName.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Please enter a book name", "Insufficient Information", JOptionPane.ERROR_MESSAGE);
    } else {
      BookQueries queries = new BookQueries();
      int result = queries.deleteBook(bookName);
      queries.closeConnection();
      if (result > 0){
        bookNameInput.setText("");
        JOptionPane.showMessageDialog(null, "Book Successfully Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
      } else {
        JOptionPane.showMessageDialog(null, "A book with the name \""+bookName+"\" was not found", "Unable to Delete", JOptionPane.WARNING_MESSAGE);
      }
    }
  }
}