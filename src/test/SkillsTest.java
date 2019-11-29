import org.junit.Test;
import textrpg.Player;
import textrpg.jobs.Job;
import textrpg.skills.Skill;

import static org.junit.Assert.assertEquals;

public class SkillsTest {

    /**
     * Testing to see if the player
     * can properly have their
     * skill set. The 1 is for warrior
     */
    @Test
    public void testWarriorJob() {

        // 1 is for the job type of the new player 1 = warrior
        Player testPlayer = new Player("Steven", 1);

        String skill = new String();


        System.out.println(testPlayer);

        assertEquals("Warrior", testPlayer.getJobName());

    }

    /**
     * Testing to see if the player
     * can properly have their
     * skill set. The 1 is for warrior
     */
    @Test
    public void testSkill() {
        Player testPlayer = new Player("Steven", 1);
        Job testJobSkills = new Job();

        assertEquals("Warrior", testPlayer.getJobName());
    }

}