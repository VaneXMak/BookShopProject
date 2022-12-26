import controller.OrderController;
import dataSource.BookDataSource;
import viewer.Output;

public class Program {
    public static void main(String[] args) {
        BookDataSource bookDataSource = new BookDataSource();
        Output output = new Output(new OrderController(new BookDataSource()));
        output.printTotalPrice();
        output.printSortedPrice();
        output.printSortBooksBy();
        output.printClientInfo();
    }
}

