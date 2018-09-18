import org.junit.Test;

import static org.junit.Assert.*;

public class PuzzleTest {

    @Test
    public void createSetofCombinations() {
    }

    @Test
    public void equal(){
        Puzzle puzzle = new Puzzle();
        Bone bone = new Bone(3, 6);
        Pair pair = new Pair(new Position(0, 0, 3), new Position (0,1,6));

        assertTrue(puzzle.equal(bone, pair));

        Pair pair2 = new Pair(new Position(0, 0, 6), new Position (0,1,3));
        assertTrue(puzzle.equal(bone, pair2));

        Pair pair3 = new Pair(new Position(0, 0, 3), new Position (0,1,3));
        assertFalse(puzzle.equal(bone, pair3));
    }


}