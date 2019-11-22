import org.junit.Test;
import textrpg.Player;
import textrpg.jobs.Job;
import textrpg.skills.Skill;

import static org.junit.Assert.assertEquals;

public class SkillsTest {

    /**
     * Testing to see if a skill can be set
     * correctly
     */
    @Test
    public void testingSetSkills() {

        Skill skills = new Skill();
        skills.setSkillName("Fireball");
        assertEquals(skills.getSkillName(), "Fireball");
    }

    /**
     * Testing to see if the player
     * can properly have their
     * skill set.
     */
    @Test
    public void testSkill() {
        Player testPlayer = new Player("Steven", 1);
        Job testJobSkills = new Job();


        System.out.println(testPlayer.getJob().getJobName());

    }

}
