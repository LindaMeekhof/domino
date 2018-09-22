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

    public void setPairCollection(List<Pair> pairCollection) {
        this.pairCollection = pairCollection;
    }

    public void createPairCollection (int[][] values) {
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {

                if (x < 7) {
                    int right = x + 1;
                    Position position1 = new Position(x, y, values[y][x]);
                    Position position2 = new Position(x + 1, y, values [y][right]);
                    Pair pair = new Pair(position1, position2);
                    pairCollection.add(pair);
                   // System.out.println(pair);
                }

                if (y < 6) {
                    Position position1 = new Position(x, y, values[y][x]);
                    Position position2 = new Position(x, y + 1, values [y + 1][x]);
                    Pair pair = new Pair(position1, position2);
                    pairCollection.add(pair);
                  //  System.out.println(pair);
                }
            }
        }
    }

}
