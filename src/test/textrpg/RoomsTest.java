package textrpg;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

import textrpg.rooms.Room;
import textrpg.rooms.PowerRangerRoom;
import textrpg.rooms.StartingRoom;


public class RoomsTest {

    PowerRangerRoom dummyPowerRangerRoom;

    StartingRoom dummyStartingRoom;


    @Test
    public void testPowerRangerRoom() {
        Room n = new Room();
        Room w = new Room();
        Room e = new Room();
        Room s = new Room();

        dummyPowerRangerRoom = new PowerRangerRoom(n, s, e, w);


        assertEquals("Power Ranger Room", dummyPowerRangerRoom.getRoomName());

        assertEquals("Mighty morphing power rangers! There's an old creep in the room.", dummyPowerRangerRoom.getRoomDescription());
    }


    @Test
    public void testStartingRoom() {
        Room n = new Room();
        Room w = new Room();
        Room e = new Room();
        Room s = new Room();

        dummyStartingRoom = new StartingRoom(n, s, e, w);


        assertEquals("Starting Room", dummyStartingRoom.getRoomName());

        assertEquals("You are in a room, it feels like a starting room. There's a merchant sitting in the corner of the room. There is a Health Potion sitting on a table next to you.", dummyStartingRoom.getRoomDescription());
    }
}
