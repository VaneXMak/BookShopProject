package dataSource;

import model.Book;
import model.Client;
import model.Order;

import java.util.ArrayList;

public class BookDataSource implements iBookDataSource {
    private ArrayList<Book> listBooks = new ArrayList<>();
    private ArrayList<Order> listOrders = new ArrayList<>();
    private ArrayList<Client> listClients = new ArrayList<>();

    public BookDataSource() {
        initialData();
        initialOrder();
        initialClient();
    }

    public void initialData() {
        listBooks.add(new Book(1234, "Red queen", "Aveyard V.", 290, "Thriller", 100));
        listBooks.add(new Book(1345, "Seraphina", "Hartman R.", 160, "Thriller", 200));
        listBooks.add(new Book(146, "Egyptian Art", "Aldred A.", 300, "Art", 150));
        listBooks.add(new Book(1567, "The Masterworks by Bruce Brooks Pfeiffer", "Wright F.L.", 290, "Art", 150));
        listBooks.add(new Book(1678, "Islamic Arts", "Bloom J.", 110, "Art", 150));
        listBooks.add(new Book(777, "Shoe Dog", "Knight P.", 350, "Memoir", 400));
        listBooks.add(new Book(1930, "My early life", "Winston C.", 1000, "Memoir", 50));
    }

    public void initialOrder() {
        listOrders.add(new Order(1, 11111, 21112, new int[]{146, 1234, 777}));
        listOrders.add(new Order(2, 11112, 21111, new int[]{146, 1678, 1567}));
        listOrders.add(new Order(3, 11111, 21113, new int[]{1930, 146}));
        listOrders.add(new Order(4, 11113, 21114, new int[]{1234, 1345}));
        listOrders.add(new Order(5, 11113, 21115, new int[]{1567, 1345}));
    }

    public void initialClient() {
        listClients.add(new Client(11111, "Ivan", "Ivanov", 20, "ivannov@gmail.com"));
        listClients.add(new Client(11112, "Roman", "Romanov", 25, "romannov@gmail.com"));
        listClients.add(new Client(11113, "Vadym", "Vadymov", 18, "vadymmov@gmail.com"));
    }

    @Override
    public ArrayList<Book> getBooks() {
        return listBooks;
    }

    @Override
    public ArrayList<Order> getOrders() {
        return listOrders;
    }

    @Override
    public ArrayList<Client> getClients() {
        return listClients;
    }
}
