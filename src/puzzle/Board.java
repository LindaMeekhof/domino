package puzzle;

import java.util.ArrayList;
import java.util.List;


public class Board {

    private List<Position> positions = new ArrayList<>();
    private int[][] board;

    public Board () {
        this.board = new int[7][8];
    }

    public Board (int [][] inputBoard ) {
        board = new int[7][8];
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {
                board[y][x] = inputBoard[y][x];
            }
        }
    }

    public Board(Board b) {
        positions = b.getPositions();
        board = new int[7][8];
        int[][] input = b.getBoard();
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {
                board[y][x] = input[y][x];
            }
        }
    }

    public List<Position> getPositions() {
        return positions;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }


    public void createPositions (int [][] values) {
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {
                Position newPosition = new Position(y, x, values[y][x]);
                positions.add (newPosition);
            }
        }
    }

    public void setPosition(Position p, int value){
        board[p.getxCo()][p.getyCo()] = value;
    }


    public String toString() {
        String result = "\n";
        for (int y = 0; y < 7; y++) {

            for (int x = 0; x < 8; x++) {
                result = "  " + result + board[y][x] +  "  ";
            }
            result = result + "\n";
        }
        return result;
    }

    public String toString(int [][] values) {
        String result = "\n";
        for (int y = 0; y < 7; y++) {

            for (int x = 0; x < 8; x++) {
                result = "  " + result + values[y][x] +  "  ";
            }
            result = result + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        //Testing deepcopy board
        int[][] input = new int[][]{
                {6, 6, 2, 6, 5, 2, 4, 1},
                {1, 3, 2, 0, 1, 0, 3, 4},
                {1, 3, 2, 4, 6, 6, 5, 4},
                {1, 0, 4, 3, 2, 1, 1, 2},
                {5, 1, 3, 6, 0, 4, 5, 5},
                {5, 5, 4, 0, 2, 6, 0, 3},
                {6, 0, 5, 3, 4, 2, 0, 3}
        };

        Board b = new Board(input);
        b.createPositions(input);
        System.out.println(b);


        Board c = new Board();
        System.out.println(c);

        Board d = new Board(c);
        System.out.println(d);
    }

}

