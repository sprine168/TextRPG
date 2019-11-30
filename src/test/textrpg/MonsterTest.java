package textrpg;

import org.junit.Test;
import textrpg.items.Item;
import textrpg.items.SlimeExtract;
import textrpg.monsters.Monster;
import textrpg.monsters.Slime;

import static org.junit.Assert.assertEquals;

public class MonsterTest {


    @Test
    public void testCreateSlimeMonster() {

        Slime slime = new Slime();
        System.out.println(slime.getName());

        assertEquals("Slime", slime.getName());
    }

    /**
     * Testing if loot is dropped when defeated
     * from slime
     */
    @Test
    public void testGetLoot(){

        Slime slime = new Slime();
        System.out.println(slime.getLoot().get(0).getName());
        assertEquals("Slime Extract", slime.getLoot().get(0).getName());
    }

}
