package puzzle;

import java.util.ArrayList;
import java.util.List;

public class PairCollection {

    private List<Pair> pairCollection = new ArrayList<>();

    public PairCollection(){

    }

    public List<Pair> getPairCollection() {
        return pairCollection;
    }

    public void createPairCollection (int[][] values) {
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {

                if (x < 7) {
                    Position position1 = new Position(y, x, values[y][x]);
                    Position position2 = new Position(y, x + 1, values [y][x + 1]);
                    Pair pair = new Pair(position1, position2);
                    pairCollection.add(pair);
                }

                if (y < 6) {
                    Position position1 = new Position(y, x, values[y][x]);
                    Position position2 = new Position(y + 1, x, values [y + 1][x]);
                    Pair pair = new Pair(position1, position2);
                    pairCollection.add(pair);
                }
            }
        }
    }

}
