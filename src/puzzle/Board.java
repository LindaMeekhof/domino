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

    public Board(Board board) {
        positions = board.getPositions();
        this.board = board.getBoard();
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public void createPositions (int [][] values) {
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {
                Position newPosition = new Position(x, y, values[y][x]);
                positions.add (newPosition);
                //System.out.println(newPosition);
            }
        }
    }

    public void setPosition(Position p, int value){
        board[p.getyCo()][p.getxCo()] = value;
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

}

