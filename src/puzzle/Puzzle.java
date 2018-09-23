package puzzle;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {


    private Bones bones;
    private Board board;
    private PairCollection pairs;
    private List<Combi> combies = new ArrayList<>();
    private List<Generation> generations;

    public Puzzle(int[][] values) {
        bones = new Bones();
        board = new Board(values);
        pairs = new PairCollection();

        bones.createBones();
        board.createPositions(values);
        pairs.createPairCollection(values);

        generations = new ArrayList<>();
        Generation g = new Generation();
        g.addBoard(new Board());
        generations.add(g);
    }

    public List<Combi> getCombies() {
        return combies;
    }

    public List<Generation> getGenerations() {
        return generations;
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

            Generation nextGeneration = new Generation();
            generations.add(nextGeneration);

            List<Board> next = new ArrayList<>();
            for (int b = 0; b < generations.get(i).getBoards().size(); b++) {
                List<Board> copyList = copyBoard(amountOfLocations, generations.get(i).getBoards().get(b));
                List<Board> n = createNextGenerationBoards(copyList, combi.getLocations(), combi.getBone());
                next.addAll(n);
            }
            nextGeneration.addList(next);
        }
    }

    public  List<Board> createNextGenerationBoards(List<Board> copyBoards, List<Pair> pairs, Bone bone) {
        List<Board> newBoards = new ArrayList<>();

        for(int i = 0; i < copyBoards.size(); i++) {
            if(isFree(copyBoards.get(i), pairs.get(i))) {
                copyBoards.get(i).setBoard(copyBoards.get(i).getBoard());
                copyBoards.get(i).setPosition(pairs.get(i).getPosition1(), bone.getValue());
                copyBoards.get(i).setPosition(pairs.get(i).getPosition2(), bone.getValue());
                newBoards.add(copyBoards.get(i));
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

 }



