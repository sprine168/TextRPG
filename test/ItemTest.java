
/*
 * Makes an Item object, a Health Potion object, and an Slime Extract Object.
 * Tests the functionality of their methods as is outlined in LevelTestPlan.pdf, which is located in the project folder.
 */


import org.junit.Test;
import textrpg.items.Item;

import static org.junit.Assert.assertEquals;


public class ItemTest {
    @Test
    public void testItems() {

        Item items = new Item();

        assertEquals(null, items.getName());

    }
}
