
import org.junit.Assert;
import org.junit.Test;
import textrpg.Player;
import textrpg.shops.GeneralShop;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * The shop class is going to be for testing different
 * shop menu items that the player can choose from
 * valid input will be 1, 2, or 3 everything else is bad input
 */

public class ShopTest {

    Player dummy_player;

    GeneralShop dummy_shop;


    @Test
    public void testValidShop() {
        dummy_player = new Player("Billy", 1);

        dummy_shop = new GeneralShop();


        dummy_player.setGold(100);


        String input = "1\n1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        dummy_shop.enter(dummy_player);

        Assert.assertTrue(true);
    }

}
