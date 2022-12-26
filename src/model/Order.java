package model;

import controller.OrderController;

import java.util.Arrays;

public class Order {
    private int idOrder;
    private int idClient;
    private int idEmployee;
    private int[] books;

    public Order(int idOrder, int idClient, int idEmployee, int[] books) {
        this.idOrder = idOrder;
        this.idClient = idClient;
        this.idEmployee = idEmployee;
        this.books = books;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public int[] getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", idClient=" + idClient +
                ", idEmployee=" + idEmployee +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
