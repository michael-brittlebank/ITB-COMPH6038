package BookShopTabs;

import BookShopGui.BookShopTab;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GetBooks extends BookShopTab {

  DefaultTableModel model = new DefaultTableModel();
  JTable table = new JTable(model){
    public boolean isCellEditable(int row, int column) {
      return false;
    }
  };

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

// Create a couple of columns
    model.addColumn("Name");
    model.addColumn("Author");
    model.addColumn("Price");

// Append a row
    populateTableRows();

    JScrollPane scrollPane = new JScrollPane(table);
    table.setFillsViewportHeight(true);
    panel.add(scrollPane);

    this.add(panel, BorderLayout.CENTER);
  }

  private void populateTableRows(){
    model.getDataVector().removeAllElements();
    Random r = new Random();
    int rangeMin = 0;
    int rangeMax = 100;
    double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    model.addRow(new Object[]{"Hamlet", "Shakespeare","$"+randomValue});
    randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    model.addRow(new Object[]{"Macbeth", "Shakespeare","$"+randomValue});
    model.fireTableDataChanged();
  }
}

