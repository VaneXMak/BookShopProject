package viewer;

import controller.OrderController;
import dataSource.BookDataSource;
import model.Book;

import java.io.IOException;

public class Output {
    private final OrderController orderController;
    private final BookDataSource bookDataSource = new BookDataSource();

    public Output(OrderController bookController) {
        this.orderController = bookController;
    }

    public void printTotalPrice() {
            String message = String.format("Total price of all orders: %.2f", orderController.calculateTotalPrice());
            System.out.println(message);
    }

    public void printSortBooksBy()  {
        try {
            for (Book book : orderController.sortBooksByGenre(bookDataSource.getBooks())) {
                System.out.println(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printClientInfo()  {
        try {
            orderController.printClientPrice();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printSortedPrice() {
        orderController.printOrderPrice();
    }
}
