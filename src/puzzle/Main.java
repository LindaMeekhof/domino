package puzzle;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] input1 = new int[][]{
                {6, 6, 2, 6, 5, 2, 4, 1},
                {1, 3, 2, 0, 1, 0, 3, 4},
                {1, 3, 2, 4, 6, 6, 5, 4},
                {1, 0, 4, 3, 2, 1, 1, 2},
                {5, 1, 3, 6, 0, 4, 5, 5},
                {5, 5, 4, 0, 2, 6, 0, 3},
                {6, 0, 5, 3, 4, 2, 0, 3}
        };

        int[][] input2 = new int[][]{
                {5, 4, 3, 6, 5, 3, 4, 6},
                {0, 6, 0, 1, 2, 3, 1, 1},
                {3, 2, 6, 5, 0, 4, 2, 0},
                {5, 3, 6, 2, 3, 2, 0, 6},
                {4, 0, 4, 1, 0, 0, 4, 1},
                {5, 2, 2, 4, 4, 1, 6, 5},
                {5, 5, 3, 6, 1, 2, 3, 1}
        };

        int[][] input3 = new int[][]{
                {4, 2, 5, 2, 6, 3, 5, 4},
                {5, 0, 4, 3, 1, 4, 1, 1},
                {1, 2, 3, 0, 2, 2, 2, 2},
                {1, 4, 0, 1, 3, 5, 6, 5},
                {4, 0, 6, 0, 3, 6, 6, 5},
                {4, 0, 1, 6, 4, 0, 3, 0},
                {6, 5, 3, 6, 2, 1, 5, 3}
        };

        solve(input1);
        solve(input2);
        solve(input3);
    }

    public static void solve(int[][] input){
        Puzzle puzzle = new Puzzle(input);
        puzzle.createSetCombinations();
        List<Combi> sorted = puzzle.sort(puzzle.getCombies());

        puzzle.play(sorted);

        List<Board> b = puzzle.getGenerations().get(28).getBoards();

        System.out.println("Input: ");
        Board b3 = new Board(input);
        System.out.println(b3);

        System.out.println("Maps resulting from layout input");
        for (int i = 0; i < b.size(); i++) {
            System.out.println(b.get(i));
        }
    }


}
