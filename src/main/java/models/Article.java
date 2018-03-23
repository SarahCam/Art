package models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Article {

    private int id;
    private Calendar creationDate;
    private GregorianCalendar publishedDate;
    private String headLine;
    private String lede;
    private String story;
    private String category;                                            // Convert this to an ENUM
    private String status;                                              // Convert this to an ENUM
    private Journalist journalist;
    private Editor editor;

    public Article() {
    }

    public Article(String headLine) {
        this.creationDate = GregorianCalendar.getInstance();            // Get current date from computer
        this.publishedDate = null;
        this.headLine = headLine;
        this.lede = null;
        this.story = null;
        this.status = "draft";                                          // Replace with ENUM
        this.journalist = null;
        this.editor = null;
        this.category = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
