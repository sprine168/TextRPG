package textrpg;/*
 * Makes an Item object, a Health Potion object, and an Slime Extract Object.
 * Tests the functionality of their methods as is outlined in LevelTestPlan.pdf, which is located in the project folder.
 */

import org.junit.Test;
import textrpg.items.HealthPotion;
import textrpg.items.Item;
import textrpg.items.SlimeExtract;

import static org.junit.Assert.*;

// Note: Unit tests are for
public class ItemTest {

    @Test
    public void testHealthPotionItem() {

        HealthPotion potion = new HealthPotion();
        assertEquals("Health Potion", potion.getName());
    }

    @Test
    public void testSlimeExtractItem() {

        SlimeExtract slime = new SlimeExtract();
        assertEquals("Slime Extract", slime.getName());
    }

    @Test
    public void testItemUse(){
        HealthPotion potion = new HealthPotion();
        Player player = new Player("Test", 1);

        // Adding potion to player inventory, setting health to 0 and then using the potion
        player.getInventory().add(potion);
        player.setCurrentHealth(0);
        player.useItem(potion.use());

        assertEquals(50, player.getCurrentHealth());
        }

        // Note can't test slime because it can't current be used with the player

}
