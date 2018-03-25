import models.Article;
import models.Editor;
import models.Journalist;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;


public class TestJournalist {

    private Journalist journalist;
    private Article article;

    @Before
    public void setUp() throws Exception {
        journalist = new Journalist("Suzy", "Smith");
    }

    @Test
    public void canGetFirstName() {
        assertEquals("Suzy", journalist.getFirstName());
    }

    @Test
    public void canGetLastName() {
        assertEquals("Smith", journalist.getLastName());
    }

}
