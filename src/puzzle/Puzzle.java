package puzzle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Puzzle {


    private Bones bones;
    private Board board;
    private PairCollection pairs;
    private List<Combi> combies = new ArrayList<>();
    private List<BoardResult> resultMaps;

    public Puzzle(){

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
        return resultMaps;
    }

    public void setResultMaps(List<BoardResult> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public Puzzle(int [][] values) {
        bones = new Bones();
        board = new Board();
        pairs = new PairCollection();
        resultMaps = new ArrayList<>();
        resultMaps.add(new BoardResult());

        bones.createBones();
        board.createPositions(values);
        pairs.createPairCollection(values);
    }

    public void createSetCombinations (){
        for (int i = 0; i < bones.getBones().size(); i++) {
            Combi combi = new Combi(bones.getBones().get(i));

            for (int j = 0; j < pairs.getPairCollection().size(); j++) {
                if (equal (bones.getBones().get(i), pairs.getPairCollection().get(j))) {
                    combi.getLocations().add(pairs.getPairCollection().get(j));
                }
            }
            combies.add(combi);
        }
    }

    public Boolean equal (Bone bone, Pair pair) {
        int p1 = bone.getPip1();
        int p2 = bone.getPip2();
        int v1 = pair.getPosition1().getValue();
        int v2 = pair.getPosition2().getValue();

        return ((p1 == v1 && p2 == v2) || p1 == v2 && p2 == v1);
    }

    // kan mooier.
    public List<Combi> sort(List<Combi> combies){
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


//    public void solve(List<Combi> combies) {
//
//        for (int i = 0; i < 5 ; i++) {
//
//            Combi combi = combies.get(i);
//
//             for(int j = 0; j < combi.getLocations().size(); j++) {
//                 System.out.println("length resultsMap " + resultMaps.size());
//
//                List<BoardResult> results = solveHelp(combi.getBone(), combi.getLocations().get(j), resultMaps);
//
//                resultMaps.clear();
//                resultMaps.addAll(results);
//                    for (int a = 0; a < resultMaps.size(); a++) {
//                     System.out.println(resultMaps.get(a));
//                    }
//             }
//        }
//
//    }

    public void solve(List<Combi> combies) {

        for (int i = 0; i < 27 ; i++) {
            System.out.println(" ronde " + i);

            Combi combi = combies.get(i);
            int amountOfLocations = combi.getLocations().size();

            List<BoardResult> nextGenerationBoards = new ArrayList<>(); //leeg

            // alle borden die er op dat moment zijn.
            for (int index = 0; index < resultMaps.size(); index++) {

                List<BoardResult> list = copyBoard(amountOfLocations, resultMaps.get(index));

                List<BoardResult> nextGen = createNextGenerationBoards(combi.getBone(), list, combi.getLocations());

                nextGenerationBoards.addAll(nextGen);
             }

             resultMaps.clear();
             resultMaps.addAll(nextGenerationBoards);

        }
    }





    public List<BoardResult> copyBoard(int amountOfLocations, BoardResult board) {
        List<BoardResult> nb = new ArrayList();
        for (int y = 0; y < amountOfLocations; y++) {
            BoardResult newBoard = new BoardResult();
            newBoard.setPlacements(board.getPlacements());
            nb.add(newBoard);
        }
        return nb;
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

    public List<BoardResult> createNextGenerationBoards(Bone bone, List<BoardResult> list, List<Pair> locations) {
        ArrayList<BoardResult> result1 = new ArrayList<>();

          for (int i = 0; i < locations.size(); i++) {
              ArrayList<BoardResult> result = new ArrayList<>();
              List<BoardResult> l1 = list;
              List<BoardResult> l2 = list;

              Pair pair1 = locations.get(i);
              BoardResult l_1 = list.get(i);
              List<BoardResult> r1 = solveHelp(bone, locations.get(i), list.get(i));
              result.addAll(r1);

              result1.addAll(result);
           }






        return result1;
    }



}
