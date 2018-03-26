package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "journalists")
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
