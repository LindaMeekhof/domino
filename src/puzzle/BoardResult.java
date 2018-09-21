package puzzle;

import java.util.ArrayList;
import java.util.List;

public class BoardResult {

    private List<Placement> placements;

    public BoardResult(){
        placements = new ArrayList<>();
    }

    public BoardResult(BoardResult b){
        this.placements = b.placements;
    }


    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }

    public void setPlacement(Placement placement){
        placements.add(placement);
    }


    public boolean containsPlacement(Pair pair) {

        boolean result = false;
        Position pos1 = pair.getPosition1();
        Position pos2 = pair.getPosition2();

        for (int i = 0; i < placements.size(); i++) {
            Position placement = placements.get(i).getPosition();
            if (placement.getxCo() == pos1.getxCo() && placement.getyCo() == pos1.getyCo() ||
                placement.getxCo() == pos2.getxCo() && placement.getyCo() == pos2.getyCo()) {
                result = true;
            }
        }
        return result;
    }




    public String toString(){
        String s = "";
        for(int i = 0; i < placements.size(); i++) {
            s = s + "bone" + placements.get(i).getBone() + "  placement " + placements.get(i).getPosition() + "\n";
        }
        return s;
    }



}
