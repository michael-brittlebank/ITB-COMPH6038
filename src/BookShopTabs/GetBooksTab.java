package BookShopTabs;

import BookShopGui.BookShopTab;
import BookShopLogic.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetBooksTab extends BookShopTab {

  //local variables
  private DefaultTableModel model = new DefaultTableModel();

  /**
   * Constructor for get books tab
   */
  public GetBooksTab(){
    //create main GUI elements
    this.setLabel("Get Books");
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    JButton refreshButton = new JButton("Refresh Data");
    //add listener to refresh button
    refreshButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    refreshButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        populateTableRows();
      }
    });

    //create table and set column headers
    JTable table = new JTable(model){
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    model.addColumn("Name");
    model.addColumn("Author");
    model.addColumn("Price");
    //populate table with data
    populateTableRows();

    //add GUI elements to containers
    JScrollPane scrollPane = new JScrollPane(table);
    table.setFillsViewportHeight(true);
    panel.add(refreshButton, SwingConstants.CENTER);
    panel.add(scrollPane);

    this.add(panel, BorderLayout.CENTER);
  }

  /**
   * Refresh button listener and general table data getter method
   */
  private void populateTableRows(){
    //clear table of existing data
    model.getDataVector().removeAllElements();
    for(Book book:BookQueries.getBooks()){
      model.addRow(new Object[]{book.getBookName(), book.getAuthorName(),book.getFormattedPrice()});
    }
    //redraw the table
    model.fireTableDataChanged();
  }
}

