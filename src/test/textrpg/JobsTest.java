package textrpg;

import org.junit.Assert;
import org.junit.Test;
import textrpg.Player;
import textrpg.jobs.*;

import static org.junit.Assert.assertEquals;


public class JobsTest {

    Player dummy_player;

    Job dummy_job;

    @Test
    public void testJob() {
        dummy_player = new Player("Billy", 1);

        dummy_job = new Job(dummy_player, 1);

        assertEquals("Warrior", dummy_player.getJobName());
    }

    @Test
    public void testMageJob() {

        // The job is being passed through the second parameter of new Player
        Player testPlayer = new Player("Test", 2);
        assertEquals("Mage", testPlayer.getJobName());
    }

    @Test
    public void testThiefJob() {

        // The job is being passed through the second parameter of new Player
        Player testPlayer = new Player("Test", 3);
        assertEquals("Thief", testPlayer.getJobName());
    }

}