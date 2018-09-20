package puzzle;

public class Placement {

    private Bone bone;
    private Position position;

    public Placement(Bone bone, Position position) {
        this.bone = bone;
        this.position = position;
    }

    public Placement() {

    }



    public Bone getBone() {
        return bone;
    }

    public void setBone(Bone bone) {
        this.bone = bone;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String toSting(){
        return "bone: " + bone + "  " + position;
    }
}
