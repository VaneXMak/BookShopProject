package controller;

import dataSource.BookDataSource;
import model.Book;
import model.Client;
import model.Order;
import model.Genre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Predicate;

public class OrderController {
    private BookDataSource bookDataSource;

    public OrderController(BookDataSource bookDataSource) {
        this.bookDataSource = bookDataSource;
    }

    private Book getBookElement(int id) {
        for (Book book : bookDataSource.getBooks()) {
            if (book.getIdBook() == id) {
                return book;
            }
        }
        return null;
    }

    private double getPriceOrder(Order order) {
        double price = 0;
        for (int id : order.getBooks()) {
            Book book = getBookElement(id);
            if (book != null) {
                price += book.getPrice();
            }
        }
        return price;
    }

    public double getClientPriceOrder(Client client) {
        double price = 0;
        for (Order order : bookDataSource.getOrders()) {
            int id = order.getIdClient();
            if (id == client.getId()) {
                price += getPriceOrder(order);
            }
        }
        return price;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Order order : bookDataSource.getOrders()) {
            totalPrice += getPriceOrder(order);
        }
        return totalPrice;
    }

    public ArrayList<Book> sortBooksByPrice(ArrayList<Book> books) {
        books.sort((book1, book2) -> (int) (book1.getPrice() - book2.getPrice()));
        return books;
    }

    public ArrayList<Book> sortBooksByAmount(ArrayList<Book> books) {
        books.sort((book1, book2) -> (book1.getAmount() - book2.getAmount()));
        return books;
    }

    public ArrayList<Order> sortOrdersByPrice(ArrayList<Order> orders) {
        orders.sort((order1, order2) -> (int) (getPriceOrder(order1) - getPriceOrder(order2)));
        return orders;
    }

    public ArrayList<Book> sortBooksByGenre(ArrayList<Book> books) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a genre(Thriller, Art, Memoir): ");
        String genre = br.readLine();
        Predicate<Book> gr = null;
        for (Genre g : Genre.values()) {
            if (genre.equals(g.getGenre())) {
                gr = book -> book.getGenre().equals(genre);
                break;
            }
        }
        ArrayList<Book> sortedByGenres = new ArrayList<>();
        for (Book book : books) {
            if (gr != null && gr.test(book)) {
                sortedByGenres.add(book);
            }
        }
        return sortedByGenres;
    }

    public void printClientBooks(Client client) {
        for (Order order : bookDataSource.getOrders()) {
            int id = order.getIdClient();
            if (id == client.getId()) {
                for (int bookId : order.getBooks()) {
                    Book book = getBookElement(bookId);
                    if (book != null) {
                        System.out.println(book);
                    }
                }
            }
        }
    }

    public void printClientPrice() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a client's email: ");
        String email = br.readLine();
        for (Client client : bookDataSource.getClients()) {
            if (client.getEmail().equals(email)) {
                String message = String.format("Total price of all orders for such client: %.2f",
                        getClientPriceOrder(client));
                System.out.println(message);
                printClientBooks(client);
            }
        }
    }

    public void printOrderPrice() {
        for (Order order : sortOrdersByPrice(bookDataSource.getOrders())) {
            System.out.print(order);
            System.out.print(" Price: " + getPriceOrder(order) + "\n");
        }
     }
}
