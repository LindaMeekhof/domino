package puzzle;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {


    private Bones bones;
    private Board board;
    private PairCollection pairs;
    private List<Combi> combies = new ArrayList<>();
    private List<Generation> generations;


    public Puzzle() {

    }



    public Puzzle(int[][] values) {
        bones = new Bones();
        board = new Board(values);
        pairs = new PairCollection();


        bones.createBones();
        board.createPositions(values);
        pairs.createPairCollection(values);

        generations = new ArrayList<>();
        Generation g = new Generation();
        g.add(new Board());
        generations.add(g);
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


    public List<Board> copyBoard(int amountOfLocations, Board board) {
        List<Board> nb = new ArrayList();
        for (int y = 0; y < amountOfLocations; y++) {
            Board newBoard = new Board(board);
            nb.add(newBoard);
        }
        return nb;
    }

    public void play(List<Combi> sortedCombies) {

        for (int i = 0; i < sortedCombies.size(); i++) {
            Combi combi = sortedCombies.get(i);
            int amountOfLocations = sortedCombies.get(i).getLocations().size();
            int amountOfBoards = combi.getLocations().size();
            System.out.println(" amount of boards" + i + amountOfBoards);
            Generation nextGeneration = new Generation();
            generations.add(nextGeneration);


            //alle borden die in die generatie er is bij langs
            for (int b = 0; b < generations.get(i).getBoards().size(); b++) {

                List<Board> copyList = copyBoard(amountOfLocations, generations.get(i).getBoards().get(b));
                System.out.println(copyList);

//                nextGeneration.getBoards().addAll(copyList);
//                System.out.println("nextgen \n" + nextGeneration);
                List<Board> next = createNextGenerationBoards(copyList, combi.getLocations(), combi.getBone());
                nextGeneration.getBoards().addAll(next);
            }

        }
    }

    public  List<Board> createNextGenerationBoards(List<Board> copyBoards, List<Pair> pairs, Bone bone) {
        List<Board> newBoards = new ArrayList<>();

        for(int i = 0; i < copyBoards.size(); i++) {
            if(isFree(copyBoards.get(i), pairs.get(i))) {
                Board b = copyBoards.get(i);
                b.setPosition(pairs.get(i).getPosition1(), bone.getValue());
                b.setPosition(pairs.get(i).getPosition2(), bone.getValue());
                newBoards.add(b);
            }
        }
        return newBoards;
    }


    public Boolean isFree(Board board, Pair pair) {
        boolean result = false;
        int[][] b = board.getBoard();
        Position pos1 = pair.getPosition1();
        Position pos2 = pair.getPosition2();
        if (b[pos1.getyCo()][pos1.getxCo()] == 0 &&
            b[pos2.getyCo()][pos2.getxCo()] == 0) {
            result = true;
        }
        return result;
    }



    /**
     * Main program
     * @param args
     */
    public static void main(String[] args) {

           int[][] input = new int[][]{
                {6, 6, 2, 6, 5, 2, 4, 1},
                {1, 3, 2, 0, 1, 0, 3, 4},
                {1, 3, 2, 4, 6, 6, 5, 4},
                {1, 0, 4, 3, 2, 1, 1, 2},
                {5, 1, 3, 6, 0, 4, 5, 5},
                {5, 5, 4, 0, 2, 6, 0, 3},
                {6, 0, 5, 3, 4, 2, 0, 3}
        };

        Puzzle puzzle = new Puzzle(input);
        puzzle.createSetCombinations();
        List<Combi> sorted = puzzle.sort(puzzle.getCombies());
        System.out.println(sorted);

        puzzle.play(sorted);

        Board b = new Board(input);
        Board c = new Board(new int[7][8]);

    }

 }



