package textrpg;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import textrpg.Player;
import textrpg.items.Item;
import textrpg.shops.GeneralShop;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * The shop class is going to be for testing different
 * shop menu items that the player can choose from
 * valid input will be 1, 2, or 3 everything else is bad input
 * When mocking input the first 1 is to buy 2 is to sell and 3 is to leave
 * if going into buy, will need to select 1 for each purchase to buy new items
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
     * buying items from the shop
     * and seeing if the player's inventory gets updated
     */
    @Test
    public void testShopHealthPotion() {

        // Creating mock input using System Rules library
        systemInMock.provideLines("1", "1", "3");

        Player player = new Player("Test", 1);
        GeneralShop shop = new GeneralShop();
        Item potion = null;

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
     * testShopSlimeExtract will be tested by
     * buying items from the shop
     * and seeing if the player's inventory gets updated
     */
    @Test
    public void testShopSlimeExtract() {

        // Creating mock input using System Rules library
        systemInMock.provideLines("1", "0", "3");

        Player player = new Player("Test", 1);
        GeneralShop shop = new GeneralShop();
        Item potion = null;

        player.setGold(100);

        // Simulating the player entering the shop
        shop.enter(player);

        // Note: This will fail if player didn't obtain the health potion
        potion = player.getInventory().get(0);

        // Seeing if player's inventory was updated
        assertEquals(potion, player.getInventory().get(0));
    }

    /**
     * testGoldSpentOnSlimeExtractInShop will be tested by
     * seeing if the player's gold is updated
     */
    @Test
    public void testGoldSpentOnSlimeExtractInShop() {

        // Creating mock input using System Rules library
        systemInMock.provideLines("1", "0", "3");

        Player player = new Player("Test", 1);
        GeneralShop shop = new GeneralShop();

        // Testing if shop finds valid gold
        player.setGold(100);

        // Simulating the player entering the shop
        shop.enter(player);

        // Getting player's current purse
        System.out.println(player.getGold());

        assertEquals(97, player.getGold());
    }

    /**
     * testGoldSpentOnHealthPotionInShop will be tested by
     * seeing if the player's gold is updated
     */
    @Test
    public void testGoldSpentOnHealthPotionInShop() {

        // Creating mock input using System Rules library
        // Going into buy twice and selected the health potion each time
        systemInMock.provideLines("1", "1", "1", "1", "3");

        Player player = new Player("Test", 1);
        GeneralShop shop = new GeneralShop();

        // Testing if shop finds valid gold
        player.setGold(100);

        // Simulating the player entering the shop
        shop.enter(player);

        // Getting player's current purse
        System.out.println(player.getGold());

        assertEquals(90, player.getGold());
    }

    /**
     * allGoldSpentTest will be tested by
     * seeing if the player's gold is updated
     */
    @Test
    public void allGoldSpentTest() {

        CharacterIterator it = new StringCharacterIterator("i");

        // Creating mock input using System Rules library
        // Spending all of the money in the shop
        systemInMock.provideLines(
                "1", "1",
                "1", "1",
                "1", "1",
                "1", "1",
                "1", "1",
                "1", "1",
                "1", "1",
                 "3");

        Player player = new Player("Test", 1);
        GeneralShop shop = new GeneralShop();

        // Testing if shop finds valid gold -- going over 5 gold
        player.setGold(30);

        // Simulating the player entering the shop
        shop.enter(player);

        // Getting player's current purse
        System.out.println(player.getGold());

        assertEquals(0, player.getGold());
    }

}
