package de.haust.web_name_info.dto;

public class Contact {


    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Contact() {
    }

    public Contact(int id) {
        this.id = id;
    }

    public Contact(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
