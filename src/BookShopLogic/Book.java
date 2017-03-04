package BookShopLogic;

import java.text.NumberFormat;

public class Book {

  private String bookName;
  private String authorName;
  private double price;

  public Book(String bookName, String authorName, double price){
    this.bookName = bookName;
    this.authorName = authorName;
    this.price = price;
  }

  //getters
  public String getBookName(){
    return this.bookName;
  }

  public String getAuthorName(){
    return this.authorName;
  }

  public double getPrice(){
    return this.price;
  }

  public String getFormattedPrice(){
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    return "€"+currencyFormat.format(this.price);
  }

  //setters
  public void setBookName(String bookName){
    this.bookName = bookName;
  }

  public void setAuthorName(String authorName){
    this.authorName = authorName;
  }

  public void setPrice(double price){
    this.price = price;
  }

  public String toString(){
    return "The book "+this.getBookName()+" by "+this.getAuthorName()+" costs "+this.getFormattedPrice();
  }

}
