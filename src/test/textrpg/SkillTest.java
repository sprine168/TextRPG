package textrpg;
import org.junit.Test;
import textrpg.monsters.Monster;
import textrpg.monsters.Slime;
import static org.junit.Assert.assertEquals;

public class SkillTest {

    /**
     * Testing the battle system to see if the
     * skill attack is correct for the job
     */
    @Test
    public void testWarriorSkill() {

        Player player = new Player("Test", 1);
        
        // Note: the [0] is what the system is asking for input at that menu
        assertEquals("Heroic Strike", player.getJob().getSkills()[0].getSkillName());
    }

    @Test
    public void testMageSkill() {

        Player player = new Player("Test", 2);
        assertEquals("Fireball", player.getJob().getSkills()[1].getSkillName());
    }

    @Test
    public void testThiefSkill() {

        Player player = new Player("Test", 3);
        assertEquals("Backstab", player.getJob().getSkills()[1].getSkillName());
    }

}
