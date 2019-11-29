import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import textrpg.Player;
import textrpg.items.HealthPotion;
import textrpg.items.Item;
import textrpg.shops.GeneralShop;

import java.util.Scanner;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * The shop class is going to be for testing different
 * shop menu items that the player can choose from
 * valid input will be 1, 2, or 3 everything else is bad input
 */

public class ShopTest {


    /**
     * rule helps you to create tests for classes
     * which read from System.in.
     */
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();


    /**
     * testValidShop will be tested by
     * buying items from the shop. Change the input 1 (0, 1, 0) to 0 to 1 to test values
     * and seeing if the player's inventory gets updated
     */
    @Test
    public void testShopHealthPotion() {

        // Creating mock input using System Rules library
        systemInMock.provideLines("1", "1", "3"); // (buy, sell, leave)

        // Simulating input to the console
        Scanner scanner = new Scanner(System.in);

        // Instantiating Player and GeneralShop classes
        Player player = new Player("Billy", 1);
        GeneralShop shop = new GeneralShop();
        Item potion = null;


        // Testing if shop finds valid gold
        player.setGold(100);

        // Simulating the player entering the shop
        shop.enter(player);

        // Note: This will fail if player didn't obtain the health potion
        potion = player.getInventory().get(0);

        // Outputting the memory location of the health potion
        System.out.println(player.getInventory().get(0));
        System.out.println(potion);

        // Seeing if player's inventory was updated
        assertEquals(potion, player.getInventory().get(0));
    }


    /**
     * testValidShop will be tested by
     * buying items from the shop. Change the input 1 (0, 1, 0) to 0 to 1 to test values
     * and seeing if the player's inventory gets updated
     */
    @Test
    public void testShopSlimeExtract() {

        // Creating mock input using System Rules library
        systemInMock.provideLines("1", "0", "3"); // (buy, sell, leave)

        // Simulating input to the console
        Scanner scanner = new Scanner(System.in);

        // Instantiating Player and GeneralShop classes
        Player player = new Player("Billy", 1);
        GeneralShop shop = new GeneralShop();
        Item potion = null;

        // Testing if shop finds valid gold
        player.setGold(100);

        // Simulating the player entering the shop
        shop.enter(player);

        // Note: This will fail if player didn't obtain the health potion
        potion = player.getInventory().get(0);

        // Seeing if player's inventory was updated
        assertEquals(potion, player.getInventory().get(0));
    }
}
