import org.junit.Test;
import textrpg.Player;
import textrpg.jobs.Job;
import static org.junit.Assert.assertEquals;

public class SkillsTest {

    /**
     * Testing to see if the player
     * can properly have their
     * skill set.
     */
    @Test
    public void testWarriorJob() {

        // 1 is for the job type of the new player 1 = warrior
        Player testPlayer = new Player("Steven", 1);

        String skill = new String();

        assertEquals("Warrior", testPlayer.getJobName());
    }

    /**
     * Testing to see if the player
     * can properly have their
     * skill set.
     */
    @Test
    public void testMageJob() {

        // 2 is for the mage job
        Player testPlayer = new Player("Steven", 2);
        Job testJobSkills = new Job();

        assertEquals("Mage", testPlayer.getJobName());
    }

    /**
     * Testing to see if the player
     * can properly have their
     * skill set.
     */
    @Test
    public void testThiefJob() {

        // 3 is for the thief job
        Player testPlayer = new Player("Steven", 3);
        Job testJobSkills = new Job();

        assertEquals("Thief", testPlayer.getJobName());
    }

}