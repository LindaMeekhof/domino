package puzzle;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<BoardResult> boards;

    public Result(Result result){
        this.boards = result.getBoards();
    }

    public Result(){
        boards = new ArrayList<>();
    }

    public Result(BoardResult b){
        this.boards = new ArrayList<>();
        boards.add(b);

    }

    public List<BoardResult> getBoards() {
        return boards;
    }

    public void setBoards(List<BoardResult> boards) {
        this.boards = boards;
    }

    public void addBoardResult(List<BoardResult> b){
        boards.addAll(b);
    }

    public void addEmptyBoard(BoardResult r) {
        boards.add(new BoardResult());
    }
}
