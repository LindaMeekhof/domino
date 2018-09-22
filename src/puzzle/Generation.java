package puzzle;

import java.util.ArrayList;
import java.util.List;

public class Generation {

    private List<Board> boards;


    public Generation(){
        boards = new ArrayList<>();
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public void addBoard(Board board){
        boards.add(board);
    }

    public void addList (List<Board> b) {
        boards.addAll(b);
    }
}
