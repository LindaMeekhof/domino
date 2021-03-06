import org.junit.Test;
import puzzle.PairCollection;

public class PairCollectionTest {

    PairCollection pairs = new PairCollection();

    @Test
    public void createPairCollection() {
        int[][] input = new int[][]{
                {6, 6, 2, 6, 5, 2, 4, 1},
                {1, 3, 2, 0, 1, 0, 3, 4},
                {1, 3, 2, 4, 6, 6, 5, 4},
                {1, 0, 4, 3, 2, 1, 1, 2},
                {5, 1, 3, 6, 0, 4, 5, 5},
                {5, 5, 4, 0, 2, 6, 0, 3},
                {6, 0, 5, 3, 4, 2, 0, 3}
        };
        pairs.createPairCollection(input);

        int l = pairs.getPairCollection().size();
        System.out.println("lengte " + l);
    }
}