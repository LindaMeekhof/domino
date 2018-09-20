import org.junit.Test;
import puzzle.*;

import javax.xml.stream.Location;
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

        System.out.println(sorted);

        puzzle.solve(sorted);


    }

    @Test
    public void copyBoard(){
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

        //Create combi
        Bone b = new Bone(1,2,3);
        Pair pair = new Pair(new Position(0, 0, 3), new Position (0,1,6));
        Combi combi = new Combi(b);
        combi.addLocation(pair);

        //Create List of BoardResults
        BoardResult boardresult = new BoardResult();
        List<BoardResult> boards = new ArrayList<>();
        boards.add(boardresult);


        List<BoardResult> r = puzzle.copyBoard(3, boards.get(0));

        System.out.println(r.size());
    }

    @Test
    public void copyBoard2(){
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

        //Create combi
        Bone b = new Bone(1,2,3);
        Pair pair = new Pair(new Position(0, 0, 3), new Position (0,1,6));
        Combi combi = new Combi(b);
        combi.addLocation(pair);

        //Create List of BoardResults
        BoardResult boardresult = new BoardResult();
        Placement p1 = new Placement(new Bone(3,3,6), new Position(1,2,3));
        Placement p2 = new Placement(new Bone(4,6,8), new Position(2,2,3));
        boardresult.setPlacement(p1);
        boardresult.setPlacement(p2);
        List<BoardResult> boards = new ArrayList<>();
        boards.add(boardresult);


        List<BoardResult> r = puzzle.copyBoard(3, boards.get(0));

        System.out.println(r.size());
        System.out.println(r);
    }


    @Test
    public void createNextGenerationBoards(){

        //create a list of boardResults
        BoardResult boardresult = new BoardResult();
        Placement p1 = new Placement(new Bone(3,3,6), new Position(0,1,3));
        Placement p2 = new Placement(new Bone(4,6,8), new Position(0,0,4));
        boardresult.setPlacement(p1);
        boardresult.setPlacement(p2);
        List<BoardResult> boards = new ArrayList<>();
        boards.add(boardresult);

        //List of pairs
        Pair pair1 = new Pair(new Position(4, 4, 3), new Position (4,5,6));
        Pair pair2 = new Pair(new Position(0, 0, 3), new Position (0,1,6));

    }



}