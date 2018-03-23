package models;

import java.util.HashSet;
import java.util.Set;

public class Editor extends Employee {

    private Set<Article> articles;

    public Editor() {
    }

    public Editor(String firstName, String lastName) {
        super(firstName, lastName);
        this.articles = new HashSet<>();
    }
}
