import models.Article;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class TestArticle {

    private Article article;

    @Before
    public void setUp() throws Exception {
        article = new Article("Dinosaur Rampage");
    }

    @Test
    public void canGetHeadline() {
        assertEquals("Dinosaur Rampage", article.getHeadLine());
    }

    @Test
    public void canGetCreationDate() {
        assertEquals(Calendar.getInstance(), article.getCreationDate());
    }

    @Test
    public void canGetPublishedDate() {
        GregorianCalendar testDate = new GregorianCalendar(18, 12, 9);
        article.setPublishedDate(testDate);
        assertEquals(testDate, article.getPublishedDate());
    }
}
