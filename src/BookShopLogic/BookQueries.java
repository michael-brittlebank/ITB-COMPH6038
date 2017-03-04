package BookShopLogic;

import java.sql.*;
import java.util.ArrayList;

public class BookQueries {

  private Connection connection;
  private PreparedStatement updateStatement;
  private PreparedStatement insertStatement;
  private PreparedStatement deleteStatement;
  private PreparedStatement getStatement;

  public BookQueries() {
    String url = "jdbc:mysql://localhost:3306/";
    String database = "bookshop";
    String userName = "root";
    String password = "mysql";

    try{
      connection = DriverManager.getConnection(url + database, userName, password);
      updateStatement = connection.prepareStatement("UPDATE book SET price = ? WHERE bookName = ?");
      insertStatement = connection.prepareStatement("INSERT INTO book (bookName, authorName, price) VALUES (?, ?, ?)");
      deleteStatement = connection.prepareStatement("DELETE FROM book WHERE bookName = ?");
      getStatement = connection.prepareStatement("SELECT bookName,authorName,price FROM book ");
    }
    catch(SQLException e){
      e.printStackTrace();
    }
  }

  public ArrayList<Book> getBooks(){
    ArrayList<Book> bookList = new ArrayList<>();
    try {
      ResultSet resultSet = getStatement.executeQuery();
      while(resultSet.next()){
        String bookName = resultSet.getString("bookName");
        String authorName = resultSet.getString("authorName");
        String price = resultSet.getString("price");
        Book newBook = new Book(bookName, authorName, Double.parseDouble(price));
        bookList.add(newBook);
      }
    } catch(SQLException e){
      e.printStackTrace();
    }
    return bookList;
  }

  public int updateBook(String bookName, double price){
    try{
      updateStatement.setString(1, String.valueOf(price));
      updateStatement.setString(2, bookName);
      return updateStatement.executeUpdate();
    }
    catch(SQLException e){
      e.printStackTrace();
      return 0;
    }
  }

  public void insertBook(Book newBook){
    try{
      insertStatement.setString(1, newBook.getBookName());
      insertStatement.setString(2, newBook.getAuthorName());
      insertStatement.setString(3, String.valueOf(newBook.getPrice()));
      insertStatement.executeUpdate();
    }
    catch(SQLException e){
      e.printStackTrace();
    }
  }

  public int deleteBook(String bookName){
    try{
      deleteStatement.setString(1, bookName);
      return deleteStatement.executeUpdate();
    }
    catch(SQLException e){
      e.printStackTrace();
      return 0;
    }
  }

  public void closeConnection(){
    try {
      connection.close();
    }
    catch(SQLException e){
      e.printStackTrace();
    }
  }
}
