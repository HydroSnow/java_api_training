package fr.lernejo.navy_battle.game.board;

import org.junit.Assert;
import org.junit.Test;

public class BoatTest {

    @Test
    public void test() {
        final Boat boat = new Boat(3);
        Assert.assertEquals(boat.getLength(), boat.getParts().length);
        Assert.assertTrue(boat.isValid());
        boat.getParts()[0].fire();
        boat.getParts()[2].fire();
        Assert.assertTrue(boat.isValid());
        boat.getParts()[1].fire();
        Assert.assertFalse(boat.isValid());
    }
}
