package puzzle;

import java.util.HashSet;
import java.util.Set;


public class Board {

    private Set<Position> positions = new HashSet<>();

    public Board () {

    }

    public Board (int [][] inputBoard ) {

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

