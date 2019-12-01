package textrpg;


import org.junit.Test;
import textrpg.weapons.IronSword;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


public class WeaponsTest {

    IronSword dummyIronSword;


    @Test
    public void testIronSword() {
        dummyIronSword = new IronSword();


        assertEquals(9001, dummyIronSword.getWeaponDmg());



        int[] stats = {5, 0, 3, 0, 0, 0, 0};

        assertArrayEquals(stats, dummyIronSword.getEquipmentStats());
    }
}
