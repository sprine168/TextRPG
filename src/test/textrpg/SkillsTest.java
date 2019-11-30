package textrpg;

import org.junit.Test;
import textrpg.Player;
import textrpg.jobs.Job;
import textrpg.skills.Skill;

import static org.junit.Assert.assertEquals;

public class SkillsTest {

    /**
     * Testing to see if the player
     * can properly have their
     * skill set.
     */
    @Test
    public void testWarriorSkill() {

        // The warrior job should have an
        Player testPlayer = new Player("Test", 1);



        System.out.println(testPlayer);

        assertEquals("Warrior", testPlayer.getJobName());
    }

    /**
     * Testing to see if the player
     * can properly have their
     * skill set. The 1 is for warrior
     */
    @Test
    public void testMageSkill() {
        Player testPlayer = new Player("Steven", 1);


        assertEquals("Warrior", testPlayer.getJobName());
    }

}