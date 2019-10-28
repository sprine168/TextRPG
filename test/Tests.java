import org.junit.Assert;
import org.junit.Test;
import textrpg.Player;
import textrpg.items.Item;
import textrpg.shops.Shop;

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


    // Testing Take Item

    @Test
    public void testStorage(){ }

    @Test
    public void testItems() {

        Item items = new Item();

        assertEquals(null, items.getName());

    }
}
