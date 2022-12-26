package dataSource;

import model.Book;
import model.Client;
import model.Order;

import java.util.ArrayList;

public interface iBookDataSource {
    ArrayList<Book> getBooks();
    ArrayList<Order> getOrders();
    ArrayList<Client> getClients();
}
