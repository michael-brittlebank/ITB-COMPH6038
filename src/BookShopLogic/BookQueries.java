package BookShopLogic;

import java.sql.*;
import java.util.ArrayList;

public class BookQueries {

  //local variables
  private static String url = "jdbc:mysql://localhost:3306/";
  private static String database = "bookshop";
  private static String userName = "root";
  private static String password = "mysql";

  /**
   * Get books method. Returns an ArrayList of Book objects from the database
   * @return ArrayList<Book>
   */
  public static ArrayList<Book> getBooks(){
    ArrayList<Book> bookList = new ArrayList<>();
    //implicit resource closure for the database connection
    try(Connection connection = DriverManager.getConnection(url + database, userName, password)){
      PreparedStatement getStatement = connection.prepareStatement("SELECT bookName,authorName,price FROM book ");
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

  /**
   * Update book's price by title. Returns number of affected rows in the database
   * @param bookName String
   * @param price double
   * @return int
   */
  public static int updateBook(String bookName, double price){
    //implicit resource closure for the database connection
    try(Connection connection = DriverManager.getConnection(url + database, userName, password)){
      PreparedStatement updateStatement = connection.prepareStatement("UPDATE book SET price = ? WHERE bookName = ?");
      updateStatement.setString(1, String.valueOf(price));
      updateStatement.setString(2, bookName);
      return updateStatement.executeUpdate();
    }
    catch(SQLException e){
      e.printStackTrace();
      return 0;
    }
  }

  /**
   * Inserts a new book into the database.  Enforces correct data and types through use of Book object
   * @param newBook Book
   */
  public static void insertBook(Book newBook){
    //implicit resource closure for the database connection
    try(Connection connection = DriverManager.getConnection(url + database, userName, password)){
      PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO book (bookName, authorName, price) VALUES (?, ?, ?)");
      insertStatement.setString(1, newBook.getBookName());
      insertStatement.setString(2, newBook.getAuthorName());
      insertStatement.setString(3, String.valueOf(newBook.getPrice()));
      insertStatement.executeUpdate();
    }
    catch(SQLException e){
      e.printStackTrace();
    }
  }

  /**
   * Deletes a book by title. Returns number of affected rows in the database
   * @param bookName String
   * @return int
   */
  public static int deleteBook(String bookName){
    //implicit resource closure for the database connection
    try(Connection connection = DriverManager.getConnection(url + database, userName, password)){
      PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM book WHERE bookName = ?");
      deleteStatement.setString(1, bookName);
      return deleteStatement.executeUpdate();
    }
    catch(SQLException e){
      e.printStackTrace();
      return 0;
    }
  }
}
