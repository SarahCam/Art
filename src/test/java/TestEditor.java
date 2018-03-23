import models.Editor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEditor {

    private Editor editor;

    @Before
    public void setUp() throws Exception {
        editor = new Editor("Jeff", "Bridges");
    }

    @Test
    public void canGetFirstName() {
        assertEquals("Jeff", editor.getFirstName());
    }

    @Test
    public void canGetLastName() {
        assertEquals("Bridges", editor.getLastName());
    }

}
