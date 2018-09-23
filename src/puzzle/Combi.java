package puzzle;

import java.util.ArrayList;
import java.util.List;

public class Combi{

    private Bone bone;
    private List<Pair> locations = new ArrayList<>();

    public Combi(Bone bone) {
        this.bone = bone;
    }

    public Bone getBone() {
        return bone;
    }

    public List<Pair> getLocations() {
        return locations;
    }

    public String toString(){
        String result = bone.toString();

        for (int i = 0; i < locations.size(); i++) {
            result = result + "  " + locations.get(i).toString();
        }

        return result;
    }


}
