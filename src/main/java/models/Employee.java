package models;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private GregorianCalendar hireDate;
    private GregorianCalendar quitDate;

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public GregorianCalendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(GregorianCalendar hireDate) {
        this.hireDate = hireDate;
    }

    public GregorianCalendar getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(GregorianCalendar quitDate) {
        this.quitDate = quitDate;
    }
}
