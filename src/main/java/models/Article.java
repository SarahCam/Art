package models;

import enums.CategoryType;
import enums.StatusType;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Article {

    private int id;
    private String headLine;
    private String lede;
    private String story;
    private String image;
    private CategoryType category;
    private Journalist journalist;
    private Calendar creationDate;
    private GregorianCalendar publishedDate;
    private StatusType status;

    public Article() {
    }

    public Article(String headLine, Journalist journalist) {
        this.headLine = headLine;
        this.lede = null;
        this.story = null;
        this.image = null;
        this.category = null;
        this.journalist = journalist;                           // Default to currently logged in Journalist
        this.creationDate = GregorianCalendar.getInstance();    // Get current date from computer
        this.publishedDate = null;
        this.status = StatusType.DRAFT;                         // Default to DRAFT
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getLede() {
        return lede;
    }

    public void setLede(String lede) {
        this.lede = lede;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public GregorianCalendar getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(GregorianCalendar publishedDate) {
        this.publishedDate = publishedDate;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
