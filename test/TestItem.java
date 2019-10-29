
import org.junit.Test;
import textrpg.items.Item;

import static org.junit.Assert.assertEquals;


public class TestItem {
    @Test
    public void testItems() {

        Item items = new Item();

        assertEquals(null, items.getName());

    }
}
