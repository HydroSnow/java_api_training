package fr.lernejo.navy_battle.game.board;

import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

    @Test
    public void test() {
        final Board board = new Board();
        Assert.assertFalse(board.isValid());
        Assert.assertEquals(board.fire(new CellCoordinates(2, 3)), Board.Fire.MISS);
        final Boat boat1 = new Boat(2);
        board.addBoat(new CellCoordinates(6, 8), Board.Direction.VERTICAL, boat1);
        Assert.assertEquals(board.fire(new CellCoordinates(7, 8)), Board.Fire.MISS);
        Assert.assertTrue(board.isValid());
        Assert.assertEquals(board.fire(new CellCoordinates(6, 8)), Board.Fire.HIT);
        Assert.assertTrue(board.isValid());
        Assert.assertEquals(board.fire(new CellCoordinates(6, 9)), Board.Fire.SUNK);
        Assert.assertFalse(board.isValid());
    }
}
