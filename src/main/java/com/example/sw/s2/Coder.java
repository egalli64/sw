package com.example.sw.s2;

import java.time.LocalDate;

/**
 * A JavaBean
 */
public class Coder {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate hired;
    private double salary;

    public Coder() {
    }

    public Coder(int id, String firstName, String lastName, LocalDate hired, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hired = hired;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getHired() {
        return hired;
    }

    public void setHired(LocalDate hired) {
        this.hired = hired;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Coder [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", hired=" + hired
                + ", salary=" + salary + "]";
    }
}
