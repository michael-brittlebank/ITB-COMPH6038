package BookShopTabs;

import BookShopGui.BookShopTab;
import BookShopLogic.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetBooks extends BookShopTab {

  private DefaultTableModel model = new DefaultTableModel();

  public GetBooks(){
    this.setLabel("Get Books");

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

//refresh button
    JButton refreshButton = new JButton("Refresh Data");
    refreshButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    refreshButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        populateTableRows();
      }
    });
    panel.add(refreshButton, SwingConstants.CENTER);

    JTable table = new JTable(model){
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

//create column headers
    model.addColumn("Name");
    model.addColumn("Author");
    model.addColumn("Price");

//get initial table data
    populateTableRows();

    JScrollPane scrollPane = new JScrollPane(table);
    table.setFillsViewportHeight(true);
    panel.add(scrollPane);

    this.add(panel, BorderLayout.CENTER);
  }

  private void populateTableRows(){
    model.getDataVector().removeAllElements();
    BookQueries queries = new BookQueries();
    for(Book book:queries.getBooks()){
      model.addRow(new Object[]{book.getBookName(), book.getAuthorName(),"€"+book.getPrice()});
    }
    queries.closeConnection();
    model.fireTableDataChanged();
  }
}

