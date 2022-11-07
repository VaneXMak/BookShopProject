import controller.OrderController;
import dataSource.BookDataSource;

public class Output {
    private BookDataSource bookDataSource;
    private OrderController bookController;

    public Output(BookDataSource bookDataSource, OrderController bookController) {
        this.bookDataSource = bookDataSource;
        this.bookController = bookController;
    }

    public void printTotalPrice() {
        String message = String.format("Total price of all orders: %.2f", bookController.calculateTotalPrice());
        System.out.println(message);
    }
}
