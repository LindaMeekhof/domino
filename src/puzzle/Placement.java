package puzzle;

public class Placement {

    private Bone bone;
    private Pair pair;

    public Placement(Bone bone, Pair pair){
        this.bone = bone;
        this.pair = pair;
    }

    public Placement() {

    }

    public Bone getBone() {
        return bone;
    }

    public void setBone(Bone bone) {
        this.bone = bone;
    }

    public Pair getPair() {
        return pair;
    }

    public void setPair(Pair pair) {
        this.pair = pair;
    }

    public String toSting(){
        return "bone: " + bone + "  " + pair;
    }
}
