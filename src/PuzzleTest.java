import org.junit.Test;
import puzzle.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PuzzleTest {

    @Test
    public void createSetCombinations() {

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
        puzzle.createSetCombinations();
        List<Combi> combies = puzzle.getCombies();

        for (int i = 0; i < combies.size(); i++) {
            System.out.println(combies.get(i));
        }

        System.out.println(combies.size());

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

    @Test
    public void sort(){
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
        puzzle.createSetCombinations();
        List<Combi> sorted = puzzle.sort(puzzle.getCombies());

        for (int i = 0; i < sorted.size(); i++) {
            System.out.println(sorted.get(i));
        }

        System.out.println(sorted.size());
    }

    @Test
    public void solve(){
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
//        List<Combi> sorted = puzzle.sort(puzzle.getCombies());
//
//       // System.out.println("result");
//        puzzle.solve(sorted);

       // System.out.println(puzzle.getResultMaps().size());

//        for (int i = 0; i < puzzle.getResultMaps().size(); i++) {
//            System.out.println(puzzle.getResultMaps().get(i));
//        }
    }

    @Test
    public void solveHelper(){
        Puzzle puzzle = new Puzzle();
        MapResults m1 = new MapResults();
        Pair pair = new Pair(new Position(0, 0, 6), new Position (0,1,3));
        m1.setPlacement(new Placement(new Bone(1, 2), pair));
        MapResults m2 = new MapResults();
        List<MapResults> map = new ArrayList<>();
        map.add(m1);
        map.add(m2);

        puzzle.solveHelp(new Bone(1,5), new Pair(new Position(4, 4, 6), new Position (3,4,3)), map);
    }

    @Test
    public void solveHelper2_stoneCanNotBePlaced(){
        Puzzle puzzle = new Puzzle();
        MapResults m1 = new MapResults();
        Pair pair = new Pair(new Position(0, 0, 6), new Position (0,1,3));
        m1.setPlacement(new Placement(new Bone(1, 2), pair));
        MapResults m2 = new MapResults();
        List<MapResults> map = new ArrayList<>();
        map.add(m1);
        map.add(m2);

        puzzle.solveHelp(new Bone(1,5), new Pair(new Position(0, 6, 6), new Position (3,4,3)), map);
    }


}