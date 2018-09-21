package puzzle;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {


    private Bones bones;
    private Board board;
    private PairCollection pairs;
    private List<Combi> combies = new ArrayList<>();
    private List<BoardResult> rMap;
    private ArrayList<Result> results;

    public Puzzle() {

    }

    public Bones getBones() {
        return bones;
    }

    public void setBones(Bones bones) {
        this.bones = bones;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public PairCollection getPairs() {
        return pairs;
    }

    public void setPairs(PairCollection pairs) {
        this.pairs = pairs;
    }

    public List<Combi> getCombies() {
        return combies;
    }

    public void setCombies(List<Combi> combies) {
        this.combies = combies;
    }

    public List<BoardResult> getResultMaps() {
        return rMap;
    }

    public void setResultMaps(List<BoardResult> resultMaps) {
        this.rMap = resultMaps;
    }

    public Puzzle(int[][] values) {
        bones = new Bones();
        board = new Board();
        pairs = new PairCollection();
        rMap = new ArrayList<>();
        rMap.add(new BoardResult());

        bones.createBones();
        board.createPositions(values);
        pairs.createPairCollection(values);

        results = new ArrayList<>();

        for (int i = 0; i < 28; i++) {
            results.add(new Result());
        }

        results.get(0).addEmptyBoard(new BoardResult());

    }

    public void createSetCombinations() {
        for (int i = 0; i < bones.getBones().size(); i++) {
            Combi combi = new Combi(bones.getBones().get(i));

            for (int j = 0; j < pairs.getPairCollection().size(); j++) {
                if (equal(bones.getBones().get(i), pairs.getPairCollection().get(j))) {
                    combi.getLocations().add(pairs.getPairCollection().get(j));
                }
            }
            combies.add(combi);
        }
    }

    public Boolean equal(Bone bone, Pair pair) {
        int p1 = bone.getPip1();
        int p2 = bone.getPip2();
        int v1 = pair.getPosition1().getValue();
        int v2 = pair.getPosition2().getValue();

        return ((p1 == v1 && p2 == v2) || p1 == v2 && p2 == v1);
    }

    // kan mooier.
    public List<Combi> sort(List<Combi> combies) {
        List sortedCombies = new ArrayList();
        int lStones = 28;
        for (int j = 0; j < lStones; j++) {
            for (int i = 0; i < combies.size(); i++) {
                if (combies.get(i).getLocations().size() == j) {
                    sortedCombies.add(combies.get(i));
                }
            }
        }
        return sortedCombies;
    }

    private List<BoardResult> solveHelp(Bone bone, Pair pair, BoardResult board) {
        List<BoardResult> b = new ArrayList<>();
        if (!board.containsPlacement(pair)) {
            Placement placement1 = new Placement(bone, pair.getPosition1());
            Placement placement2 = new Placement(bone, pair.getPosition2());
            board.setPlacement(placement1);
            board.setPlacement(placement2);
            System.out.println("true");
            b.add(board);
        } else {
            System.out.println("removed board");
        }

        return b;
    }

    public List<BoardResult> copyBoard(int amountOfLocations, BoardResult board) {
        List<BoardResult> nb = new ArrayList();
        for (int y = 0; y < amountOfLocations; y++) {
            BoardResult newBoard = new BoardResult(board);
            nb.add(newBoard);
        }
        return nb;
    }


    // solve methode
    public void solve(List<Combi> combies) {

        for (int i = 0; i < combies.size(); i++) {
            Combi combi = combies.get(i);
            int amountOfLocations = combies.get(i).getLocations().size();



            List<BoardResult> nextGenerationBoards = new ArrayList<>();
            for (int index = 0; index < results.get(i).getBoards().size(); index++) {


                List<BoardResult> copyList = copyBoard(amountOfLocations, results.get(i).getBoards().get(index));
                for (int j = 0; j < copyList.size(); j++) {

                    List<BoardResult> nextBoard = solveHelp(combi.getBone(), combi.getLocations().get(j), results.get(i).getBoards().get(j));
                    nextGenerationBoards.addAll(nextBoard);
                }
            }

            Result next = results.get(1);
            next.addBoardResult(nextGenerationBoards);

        }
    }




    private List<BoardResult> createNextGenerationBoards(Bone bone, List<BoardResult> list, List<Pair> locations) {
        ArrayList<BoardResult> result = new ArrayList<>();

        for (int i = 0; i < locations.size(); i++) {
            Pair pair1 = locations.get(i);
            BoardResult l1 = list.get(i);
            List<BoardResult> board = solveHelp(bone, locations.get(i), list.get(i));
            result.addAll(board);
        }
        return result;
    }
 }



