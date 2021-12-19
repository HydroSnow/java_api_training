package fr.lernejo.navy_battle.game.strategy;

import fr.lernejo.navy_battle.game.board.self.Boat;
import fr.lernejo.navy_battle.game.board.self.SelfBoard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayerTest {

    @Test
    public void test() {
        final Player player = new ComputerPlayer();
        final List<Boat> boats = new ArrayList<>();
        boats.add(new Boat(2));
        boats.add(new Boat(5));
        final SelfBoard board = new SelfBoard();
        player.placeBoats(boats, board);
    }
}
