import org.junit.Test;
import textrpg.Player;

import static org.junit.Assert.*;


public class Tests {

    @Test
    public void testTrue() {
        assertTrue(true);
    }

    @Test
    public void testFalse() {
        assertFalse(true);
    }

    @Test
    public void testItems() {

        Player players = new Player("steven ", 1);
        assertEquals(1, players.getName());
    }

}
