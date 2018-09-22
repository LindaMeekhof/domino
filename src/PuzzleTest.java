import org.junit.Test;
import puzzle.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


public class PuzzleTest {

//    @Test
//    public void createSetCombinations() {
//
//        int[][] input = new int[][]{
//                {6, 6, 2, 6, 5, 2, 4, 1},
//                {1, 3, 2, 0, 1, 0, 3, 4},
//                {1, 3, 2, 4, 6, 6, 5, 4},
//                {1, 0, 4, 3, 2, 1, 1, 2},
//                {5, 1, 3, 6, 0, 4, 5, 5},
//                {5, 5, 4, 0, 2, 6, 0, 3},
//                {6, 0, 5, 3, 4, 2, 0, 3}
//        };
//
//        Puzzle puzzle = new Puzzle(input);
//        puzzle.createSetCombinations();
//        List<Combi> combies = puzzle.getCombies();
//
//        for (int i = 0; i < combies.size(); i++) {
//            System.out.println(combies.get(i));
//        }
//
//        System.out.println(combies.size());
//
//    }

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




    @Test
    public void isFree(){

        int[][] input = new int[][]{
                {6, 6, 2, 6, 5, 2, 4, 1},
                {1, 3, 2, 0, 1, 0, 3, 4},
                {1, 3, 2, 4, 6, 6, 5, 4},
                {1, 0, 4, 3, 2, 1, 1, 2},
                {5, 1, 3, 6, 0, 4, 5, 5},
                {5, 5, 4, 0, 2, 6, 0, 3},
                {6, 0, 5, 3, 4, 2, 0, 3}
        };

        Puzzle puzzle = new Puzzle(input);

        Board b1 = new Board();
        Pair pair1 = new Pair(new Position(4, 4, 3), new Position (4,5,6));

        boolean result = puzzle.isFree(b1, pair1);
        assertTrue(puzzle.isFree(b1, pair1));
    }

//    @Test
//    public void isNotFree(){
//
//        int[][] input = new int[][]{
//                {6, 6, 2, 6, 5, 2, 4, 1},
//                {1, 3, 2, 0, 1, 0, 3, 4},
//                {1, 3, 2, 4, 6, 6, 5, 4},
//                {1, 0, 4, 3, 2, 1, 1, 2},
//                {5, 1, 3, 6, 0, 4, 5, 5},
//                {5, 5, 4, 0, 2, 6, 0, 3},
//                {6, 0, 5, 3, 4, 2, 0, 3}
//        };
//
//        Puzzle puzzle = new Puzzle(input);
//
//        Board b1 = new Board();
//        Position pos = new Position(4,4,1);
//        b1.setPosition(pos);
//
//        Pair pair1 = new Pair(new Position(4, 4, 3), new Position (4,5,6));
//
//        boolean result = puzzle.isFree(b1, pair1);
//        assertFalse(puzzle.isFree(b1, pair1));
//    }
//
//    @Test
//    public void isNotFree2(){
//
//        int[][] input = new int[][]{
//                {6, 6, 2, 6, 5, 2, 4, 1},
//                {1, 3, 2, 0, 1, 0, 3, 4},
//                {1, 3, 2, 4, 6, 6, 5, 4},
//                {1, 0, 4, 3, 2, 1, 1, 2},
//                {5, 1, 3, 6, 0, 4, 5, 5},
//                {5, 5, 4, 0, 2, 6, 0, 3},
//                {6, 0, 5, 3, 4, 2, 0, 3}
//        };
//
//        Puzzle puzzle = new Puzzle(input);
//
//        Board b1 = new Board();
//        Position pos = new Position(5,6,1);
//        b1.setPosition(pos);
//
//        Pair pair1 = new Pair(new Position(4, 4, 3), new Position (5,6,6));
//
//        boolean result = puzzle.isFree(b1, pair1);
//        assertFalse(puzzle.isFree(b1, pair1));
//    }
//
//    @Test
//    public void setPosition (){
//        Board b1 = new Board();
//        Position pos = new Position(1,1,3);
//        b1.setPosition(pos);
//
//        int value = b1.getBoard()[pos.getyCo()][pos.getxCo()];
//        System.out.println(value);
//    }




}