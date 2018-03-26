package models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private Calendar hireDate;
    private GregorianCalendar quitDate;

    public Employee() {
    }


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = GregorianCalendar.getInstance();
        this.quitDate = null;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "hire_date")
    public Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(Calendar hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "quit_date")
    public GregorianCalendar getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(GregorianCalendar quitDate) {
        this.quitDate = quitDate;
    }

}
