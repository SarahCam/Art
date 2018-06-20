import models.Article;
import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class TestArticle {

    private Article article;
    private Journalist journalist;

    @Before
    public void setUp() throws Exception {
        journalist = new Journalist("Suzy", "Smith");
        article = new Article("Dinosaur Rampage", journalist);
    }

    @Test
    public void canGetTitle() {
        assertEquals("Dinosaur Rampage", article.getTitle());
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
