package puzzle;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {


    private Bones bones;
    private Board board;
    private PairCollection pairs;
    private List<Combi> combies = new ArrayList<>();
    private List<MapResults> resultMaps;

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

    public List<MapResults> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<MapResults> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public Puzzle(int [][] values) {
        bones = new Bones();
        board = new Board();
        pairs = new PairCollection();
        resultMaps = new ArrayList<>();
        resultMaps.add(new MapResults());

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

    public void solve(List<Combi> sorted){

//        for (int i = 0; i < 3; i++) {
//            Combi combi = sorted.get(i);
//            List<MapResults> allMaps = resultMaps;
//            System.out.println("length of all maps  " + allMaps.size());
//
//
//
//            int totalPositionsForStone = combi.getLocations().size();
//            System.out.println("totalPositionsForStone" + totalPositionsForStone);
//            for(int j = 0; j < totalPositionsForStone; j++) {
//                Pair p = combi.getLocations().get(j);
//                solveHelp(combi.getBone(), p, allMaps);
//
//                for (int b = 0; b < allMaps.size(); b++) {
//                    System.out.println("hier geweest");
//
//                    MapResults map = allMaps.get(j);
//                    Pair p = combi.getLocations().get(j);
//                    if (!map.containsPlacement(p)) {
//                        Placement placement = new Placement(combi.getBone(), p);
//                        map.setPlacement(placement);
//
//                        System.out.println("test");
//                        for (int a = 0; a < resultMaps.size(); a++){
//                            System.out.println("starting map");
//                            System.out.println(resultMaps.get(a));
//                            System.out.println("finished map");
//                        }
//                    }
//                }
//            }
//        }
    }

    public List<MapResults> solveHelp (Bone bone, Pair pair, List<MapResults> maps) {

        for (int i = 0; i < maps.size(); i++) {
            MapResults map = maps.get(i);
            int w = 1;
            System.out.println(" printing the map" + w);
            System.out.println(map);
            System.out.println(" end");
            w++;

            if (!map.containsPlacement(pair)) {
                Placement placement = new Placement(bone, pair);
                map.setPlacement(placement);

//                System.out.println("test");
//                for (int a = 0; a < maps.size(); a++){
//                    System.out.println("starting map");
//                    System.out.println(maps.get(a));
//                    System.out.println("finished map");
//                }
            }
            return maps;
        }


        return null;
    }


}
