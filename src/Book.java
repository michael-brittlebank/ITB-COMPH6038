/*

You need to create a class Book which has variables that reflect the 3 fields in the database: bookName, authorName, and price; the class should provide a constructor that takes in 3 parameters for the 3 fields, and appropriate setters and getters for each of the fields. In addition, you should also override the toString method which has the following signature: public String toString(){};

    */

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
    return "The book "+this.bookName+" by "+this.authorName+" costs €"+this.price;
  }

}
