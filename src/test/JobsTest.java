
import org.junit.Assert;
import org.junit.Test;

import textrpg.Player;
import textrpg.jobs.*;


public class JobsTest {

    Player dummy_player;

    Job dummy_job;

    @Test
    public void testJob() {
        dummy_player = new Player("Billy", 1);

        dummy_job = new Job(dummy_player, 1);

        Assert.assertEquals("Warrior", dummy_job.getJobName());
    }
}
