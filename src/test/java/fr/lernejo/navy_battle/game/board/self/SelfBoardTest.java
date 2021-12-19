package fr.lernejo.navy_battle.game.board.self;

import fr.lernejo.navy_battle.game.board.CellCoordinates;
import org.junit.Assert;
import org.junit.Test;

public class SelfBoardTest {

    @Test
    public void test() {
        final SelfBoard board = new SelfBoard();
        System.out.println(board);
        Assert.assertFalse(board.isValid());
        Assert.assertEquals(board.fire(new CellCoordinates(2, 3)), SelfBoard.Fire.MISS);
        final Boat boat1 = new Boat(2);
        board.addBoat(new CellCoordinates(6, 8), SelfBoard.Direction.VERTICAL, boat1);
        System.out.println(board);
        Assert.assertEquals(board.fire(new CellCoordinates(7, 8)), SelfBoard.Fire.MISS);
        Assert.assertTrue(board.isValid());
        Assert.assertEquals(board.fire(new CellCoordinates(6, 8)), SelfBoard.Fire.HIT);
        System.out.println(board);
        Assert.assertTrue(board.isValid());
        Assert.assertEquals(board.fire(new CellCoordinates(6, 9)), SelfBoard.Fire.SUNK);
        System.out.println(board);
        Assert.assertFalse(board.isValid());
    }
}
