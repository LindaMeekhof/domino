package test;

import org.junit.Test;
import puzzle.*;

import static org.junit.Assert.*;

public class BoardResultTest {

    @Test
    public void containsPlacement() {
        BoardResult boardResult = new BoardResult();
        Placement p1 = new Placement(new Bone(0,1), new Position());
        Placement p2 = new Placement(new Bone(1,2), new Position());
        boardResult.setPlacement(p1);
        boardResult.setPlacement(p2);

        Pair pair = new Pair(new Position(0, 1, 3), new Position (0,0,6));

        assertTrue(boardResult.containsPlacement(pair));
    }

    @Test
    public void containsPlacement_notAFreeSpace() {
        BoardResult boardResult = new BoardResult();
        Placement p1 = new Placement(new Bone(0,1), new Position());
        Placement p2 = new Placement(new Bone(1,2), new Position());
        boardResult.setPlacement(p1);
        boardResult.setPlacement(p2);

        Pair pair = new Pair(new Position(6, 6, 3), new Position (6,5,6));

        assertFalse(boardResult.containsPlacement(pair));
    }

    @Test
    public void containsPlacement_emptyPlacementsList() {
        BoardResult boardResult = new BoardResult();

        Pair pair = new Pair(new Position(6, 6, 3), new Position (6,5,6));

        assertFalse(boardResult.containsPlacement(pair));
    }

}