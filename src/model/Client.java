package model;

import java.util.ArrayList;

public class Client extends Person {
    private String email;
    private int id;

    public Client(int id, String firstName, String lastName, int age, String email) {
        super(firstName, lastName, age);
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
