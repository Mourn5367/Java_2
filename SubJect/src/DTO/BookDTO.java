package DTO;

public class BookDTO
{
    long ISBN;
    String bookName;
    String author;
    String publisher;
    int price;
    public final String[] bookAttribute =
            {"ISBN","도서명","저자","출판사","가격"};

    public String getAttribute(int index)
    {
        return bookAttribute[index];
    }

    public long getISBN() {return ISBN;}

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }

    public BookDTO(long ISBN, String bookName, String author, String publisher, int price)
    {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

}
