package puzzle;

import java.util.ArrayList;
import java.util.List;

public class MapResults {

    private List<Placement> placements;

    public MapResults(){
        placements = new ArrayList<>();
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
        for (int i = 0; i < placements.size(); i++) {
            Pair placement = placements.get(i).getPair();
            if (    placement.getPosition1().getxCo() == pair.getPosition1().getxCo() && placement.getPosition1().getyCo() == pair.getPosition1().getyCo() ||
                    placement.getPosition1().getxCo() == pair.getPosition2().getxCo() && placement.getPosition1().getyCo() == pair.getPosition2().getyCo() ||
                    placement.getPosition2().getxCo() == pair.getPosition1().getxCo() && placement.getPosition2().getyCo() == pair.getPosition1().getyCo() ||
                    placement.getPosition2().getxCo() == pair.getPosition2().getxCo() && placement.getPosition2().getyCo() == pair.getPosition2().getyCo()) {
                result = true;
            }
        }
        return result;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < placements.size(); i++) {
            s = s + "bone" + placements.get(i).getBone() + "  placement " + placements.get(i).getPair() + "\n";
        }
        return s;
    }

}
