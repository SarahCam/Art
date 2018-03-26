package models;

import enums.CategoryType;
import enums.StatusType;

import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table(name = "articles")
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
    private int readCount;

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
        this.readCount = 0;
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

    @Column(name = "head_line")
    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    @Column(name = "lede")
    public String getLede() {
        return lede;
    }

    public void setLede(String lede) {
        this.lede = lede;
    }

    @Column(name = "story")
    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "category")
    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "journalist_id", nullable = false)
    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    @Column(name = "creation_date")
    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "published_date")
    public GregorianCalendar getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(GregorianCalendar publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Column(name = "status")
    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }



    @Column(name = "read_count")
    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }
}
