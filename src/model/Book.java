package model;

public class Book {
    private int idBook;
    private String title;
    private String author;
    private double price;
    private String genre;
    private int amount;

    public Book(int idBook, String title, String author, double price, String genre, int amount) {
        this.idBook = idBook;
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.amount = amount;
    }

    public int getIdBook() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public int getAmount() {
        return amount;
    }
}
