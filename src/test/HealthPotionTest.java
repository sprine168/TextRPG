/*
 * EquiptmentTest is used to test
 * the equiptment class in the game
 * */


import org.junit.Assert;
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
    public void testHealthPotion(){

        Player player = new Player("Test", 1);
        player.setCurrentHealth(0);


        HealthPotion testHealthIncrease = new HealthPotion();
        testHealthIncrease.getStatsModified()[0] = 5;


        assertEquals(player.getCurrentHealth(), 5);
    }

    /**
     *  Testing the array values in the health potion array to
     *  make sure that works ok
     */
    @Test
    public void testHealthPotionArray(){

        HealthPotion testHealth = new HealthPotion();
        testHealth.getStatsModified()[1] = 100;

    }

}








