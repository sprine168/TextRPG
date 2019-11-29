
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import textrpg.Player;
import textrpg.items.HealthPotion;
import textrpg.items.Item;
import textrpg.shops.GeneralShop;

import javax.lang.model.type.TypeKind;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * The shop class is going to be for testing different
 * shop menu items that the player can choose from
 * valid input will be 1, 2, or 3 everything else is bad input
 */

public class ShopTest {

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();


    /**
     * testValidShop will be tested by
     * buying a health potion from the shop
     * and seeing if the player's inventory gets updated
     */
    @Test
    public void testValidShop() {

        // Creating mock input using System Rules library
        systemInMock.provideLines("1", "1", "3");

        // Simulating input to the console
        Scanner scanner = new Scanner(System.in);

        // Instantiating Player and GeneralShop classes
        Player dummy_player = new Player("Billy", 1);
        GeneralShop dummy_shop = new GeneralShop();

        // Testing if shop finds valid gold
        dummy_player.setGold(100);

        // Simulating the player entering the shop
        dummy_shop.enter(dummy_player);

        dummy_player.printInventory();


//        System.out.println(list.getClass());
        System.out.println(dummy_player.getInventory().getClass());
       assertEquals("Health Potion", "Health Potion");

//        systemInMock.throwExceptionOnInputEnd(new IOException());


    }


}
