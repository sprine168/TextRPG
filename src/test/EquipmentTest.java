/*
 * EquiptmentTest is used to test
 * the equiptment class in the game
 * */

import org.junit.Test;
import textrpg.equipment.BronzeChest;
import textrpg.equipment.Equipment;
import static org.junit.Assert.*;

public class EquipmentTest {

    Equipment dummy_equipment;

    BronzeChest dummy_bronze_chest;


    @Test
    public void testEquipment(){
        dummy_equipment = new Equipment();

        dummy_equipment.setEquipmentType(1);

        int[] stats = {1, 2, 3};
        dummy_equipment.setEquipmentStats(stats);


        assertEquals(1, dummy_equipment.getEquipmentType());

        assertArrayEquals(stats, dummy_equipment.getEquipmentStats());
    }


    @Test
    public void testBronzeChest() {
        dummy_bronze_chest = new BronzeChest();

        int[] stats = {5, 0, 2, 0, 0, 0, 0};


        assertEquals(2, dummy_bronze_chest.getEquipmentType());

        assertArrayEquals(stats, dummy_bronze_chest.getEquipmentStats());
    }

}
