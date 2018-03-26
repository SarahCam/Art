package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hr_managers")
public class HRManager extends Employee {

    public HRManager() {
    }

    public HRManager(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
