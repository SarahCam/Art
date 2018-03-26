package models;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Journalist extends Employee {

    private Set<Article> articles;

    public Journalist() {
    }

    public Journalist(String firstName, String lastName) {
        super(firstName, lastName);
        this.articles = new HashSet<>();
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

}
