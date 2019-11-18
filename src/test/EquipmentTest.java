/*
 * EquiptmentTest is used to test
 * the equiptment class in the game
 * */


import org.junit.Assert;
import org.junit.Test;
import textrpg.equipment.Equipment;

import static org.junit.Assert.*;

public class EquipmentTest {

    Equipment dummy_equipment;


    @Test
    public void testEquipment(){
        dummy_equipment = new Equipment();

        dummy_equipment.setEquipmentType(1);

        int[] stats = {1, 2, 3};
        dummy_equipment.setEquipmentStats(stats);


        Assert.assertEquals(1, dummy_equipment.getEquipmentType());

        Assert.assertArrayEquals(stats, dummy_equipment.getEquipmentStats());
    }

}
