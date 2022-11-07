import controller.OrderController;
import dataSource.BookDataSource;

public class Program {
    public static void main(String[] args) {
        Output output = new Output(new BookDataSource(), new OrderController(new BookDataSource()));
        output.printTotalPrice();
    }
}
