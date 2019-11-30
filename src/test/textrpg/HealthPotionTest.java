package textrpg;/*
 * EquiptmentTest is used to test
 * the equiptment class in the game
 * */

import org.junit.Test;
import textrpg.Player;
import textrpg.items.HealthPotion;
import static org.junit.Assert.*;

public class HealthPotionTest {

    /**
    *   Testing health potion to make sure that it truly adds health to a users
    *   health
    */
    @Test
    public void testHealthPotion() {

        Player player = new Player("Test", 1);
        player.setCurrentHealth(10);

        // Health is in the first array slot
        int[] healthAdder = {50, 0, 0, 0, 0, 0, 0, 0};

        int healthBefore = player.getCurrentHealth();

        HealthPotion testHealthPotion = new HealthPotion();

        // Making the health potion health addable for 50 hit points
        testHealthPotion.setStatsModified(healthAdder);
        testHealthPotion.use();

        // Getting player to use health potion to increase health
        player.useItem(testHealthPotion.getStatsModified());

        // getting players health after health potion
        int healthAfter = player.getCurrentHealth();

        System.out.printf("Health After: %d \n Health Before: %d \n", healthAfter, healthBefore);

        boolean increased = (healthBefore < healthAfter);

        assertTrue(increased);
    }

    /**
     *  Testing the array values in the health potion array to
     *  make sure that works ok
     */
    @Test
    public void testHealthPotionArrayMaxLength(){

        // Note: Out of bounds is a length of 8
        HealthPotion testHealth = new HealthPotion();
        testHealth.getStatsModified()[7] = 5;
        assertEquals(testHealth.getStatsModified()[7], 5);

    }

    /**
     *  Testing the min length of the array
     */
    @Test
    public void testHealthPotionArrayMinLength() {

        // Note: Min length should be 0
        HealthPotion testHealth = new HealthPotion();
        testHealth.getStatsModified()[0] = 5;
        assertEquals(testHealth.getStatsModified()[0], 5);

    }

    /**
     *  Testing the second index value for the Health Potion Array
     */
    @Test
    public void testHealthPotionArrayLengthOne() {

        // Note: Min length should be 0
        HealthPotion testHealth = new HealthPotion();
        testHealth.getStatsModified()[1] = 5;
        assertEquals(testHealth.getStatsModified()[1], 5);

    }

    /**
     *  Testing the third index value for the Health Potion Array
     */
    @Test
    public void testHealthPotionArrayLengthTwo() {

        // Note: Min length should be 0
        HealthPotion testHealth = new HealthPotion();
        testHealth.getStatsModified()[2] = 5;
        assertEquals(testHealth.getStatsModified()[2], 5);

    }

    /**
     *  Testing the fourth index value for the Health Potion Array
     */
    @Test
    public void testHealthPotionArrayLengthThree() {

        // Note: Min length should be 0
        HealthPotion testHealth = new HealthPotion();
        testHealth.getStatsModified()[3] = 5;
        assertEquals(testHealth.getStatsModified()[3], 5);
    }

    /**
     *  Testing the fifth index value for the Health Potion Array
     */
    @Test
    public void testHealthPotionArrayLengthFour(){

        // Note: Min length should be 0
        HealthPotion testHealth = new HealthPotion();
        testHealth.getStatsModified()[4] = 5;
        assertEquals(testHealth.getStatsModified()[4], 5);
    }

    /**
     *  Testing the sixth index value for the Health Potion Array
     */
    @Test
    public void testHealthPotionArrayLengthSix(){

        // Note: Min length should be 0
        HealthPotion testHealth = new HealthPotion();
        testHealth.getStatsModified()[5] = 5;
        assertEquals(testHealth.getStatsModified()[5], 5);
    }

    /**
     *  Testing the seventh index value for the Health Potion Array
     */
    @Test
    public void testHealthPotionArrayLengthSeven(){

        // Note: Min length should be 0
        HealthPotion testHealth = new HealthPotion();
        testHealth.getStatsModified()[6] = 5;
        assertEquals(testHealth.getStatsModified()[6], 5);
    }

    /**
     *  Testing the eighth index value for the Health Potion Array
     */
    @Test
    public void testHealthPotionArrayLengthEight(){

        // Note: Min length should be 0
        HealthPotion testHealth = new HealthPotion();
        testHealth.getStatsModified()[7] = 5;
        assertEquals(testHealth.getStatsModified()[7], 5);
    }

}
