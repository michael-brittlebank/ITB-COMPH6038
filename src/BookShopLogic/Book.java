package BookShopLogic;

import java.text.DecimalFormat;

public class Book {

  //local variables
  private String bookName;
  private String authorName;
  private double price;

  /**
   * Constructor for book object
   * @param bookName String
   * @param authorName String
   * @param price double
   */
  public Book(String bookName, String authorName, double price){
    this.bookName = bookName;
    this.authorName = authorName;
    this.price = price;
  }

  /**
   * Customized toString method
   * @return String
   */
  public String toString(){
    return String.format("The book %s by %s costs %s.", this.getBookName(), this.getAuthorName(), this.getFormattedPrice());
  }

  //getters

  /**
   * Getter for book's title
   * @return String
   */
  public String getBookName(){
    return this.bookName;
  }

  /**
   * Getter for book's author
   * @return String
   */
  public String getAuthorName(){
    return this.authorName;
  }

  /**
   * Getter for book's price
   * @return double
   */
  public double getPrice(){
    return this.price;
  }

  /**
   * Specialized getter for formatted book price in Euros
   * @return String
   */
  public String getFormattedPrice(){
    DecimalFormat currencyFormat = new DecimalFormat("###,###,###.00");
    return "€"+currencyFormat.format(this.price);
  }

  //setters

  /**
   * Setter for book's title
   * @param bookName String
   */
  public void setBookName(String bookName){
    this.bookName = bookName;
  }

  /**
   * Setter for book's author
   * @param authorName String
   */
  public void setAuthorName(String authorName){
    this.authorName = authorName;
  }

  /**
   * Setter for book's price
   * @param price double
   */
  public void setPrice(double price){
    this.price = price;
  }

}
