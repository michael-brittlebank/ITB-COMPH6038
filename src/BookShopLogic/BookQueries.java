package BookShopLogic;/*

You need to create a class BookShopLogic.BookQueries that establishes connection to the bookshop database, and uses 4 prepared statements:
one for selecting all books from the book table (your query should not include bookId);
one for updating the price of a book given its name;
one for inserting a book;
and one for deleting a book given its name.
The statements should be initialised using appropriate sql queries. For each of the 4 operations, you should have appropriate methods that return appropriate values, using appropriate execute methods;

 */

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
//      updateStatement = connection.prepareStatement("UPDATE contact SET email = ? WHERE (firstName = ? AND lastName = ?)");
//      insertStatement = connection.prepareStatement("INSERT INTO contact (firstName, lastName, email, phoneNo)" + "VALUES (?, ?, ?, ?)");
//      deleteStatement = connection.prepareStatement("DELETE FROM contact WHERE (email = ?)");
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

  public void updateBook(String bookName){

  }

  public void insertBook(Book newBook){

  }

  public void deleteBook(String bookName){

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
