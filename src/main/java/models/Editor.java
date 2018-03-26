package models;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "editors")
public class Editor extends Employee {

    public Editor() {
    }


    public Editor(String firstName, String lastName) {
        super(firstName, lastName);
    }
}