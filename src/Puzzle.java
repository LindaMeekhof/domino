import java.util.Set;

public class Puzzle {


    private Bones bones;
    private Board board;
    private PairCollection pairs;

    public Puzzle(){

    }

    public Puzzle(int [][] values) {
        bones = new Bones();
        board = new Board();
        pairs = new PairCollection();

        bones.createBones();
        board.createPositions(values);
        pairs.createPairCollection(values);
    }

    public Set<Combi> createSetofCombinations (){

        for (int i = 0; i < bones.getBones().size(); i++) {

            for (int j = 0; j < pairs.getPairCollection().size(); j++) {
                System.out.println(j);
            }
        }
        return null;
    }

    public Boolean equal (Bone bone, Pair pair) {
        int p1 = bone.getPip1();
        int p2 = bone.getPip2();
        int v1 = pair.getPosition1().getValue();
        int v2 = pair.getPosition2().getValue();

        return ((p1 == v1 && p2 == v2) || p1 == v2 && p2 == v1);
    }
}
