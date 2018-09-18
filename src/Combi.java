import java.util.ArrayList;
import java.util.List;

public class Combi {

    private Bone bone;
    private List<Pair> locations = new ArrayList<>();

    public Combi(){

    }

    public Bone getBone() {
        return bone;
    }

    public void setBone(Bone bone) {
        this.bone = bone;
    }

    public List<Pair> getLocations() {
        return locations;
    }

    public void setLocations(List<Pair> locations) {
        this.locations = locations;
    }

    public void addLocation(Pair pair) {
        locations.add(pair);
    }
}
