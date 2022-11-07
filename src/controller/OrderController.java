package controller;

import dataSource.BookDataSource;
import model.*;

public class OrderController {
    private BookDataSource bookDataSource;

    public OrderController(BookDataSource bookDataSource) {
        this.bookDataSource = bookDataSource;
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

    private Book getBookElement(int id) {
        //Book currentBook = null;
        for (Book book : bookDataSource.getBooks()) {
            if (book.getIdBook() == id) {
                return book;
            }
        }
        return null;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Order order: bookDataSource.getOrders()) {
            totalPrice += getPriceOrder(order);
        }
        return totalPrice;
    }

    /* 1. Evaluate the cost of orders

    */
}
