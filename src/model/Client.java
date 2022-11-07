package model;

public class Client extends Person {
    private String email;

    public Client(int id, String firstName, String lastName, int age, String email) {
        super(id, firstName, lastName, age);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
