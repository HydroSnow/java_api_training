package fr.lernejo.navy_battle.game.board.opponent;

import fr.lernejo.navy_battle.game.board.CellCoordinates;
import org.junit.Assert;
import org.junit.Test;

public class OpponentBoardTest {

    @Test
    public void test() {
        final OpponentBoard board = new OpponentBoard();
        Assert.assertEquals(board.getCell(new CellCoordinates(5, 5)), OpponentBoard.Cell.UNKNOWN);
        board.setCell(new CellCoordinates(5, 5), OpponentBoard.Cell.HIT);
        Assert.assertEquals(board.getCell(new CellCoordinates(5, 5)), OpponentBoard.Cell.HIT);
    }
}
