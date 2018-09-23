package puzzle;

public class Pair {

    private Position position1;
    private Position position2;

    public Position getPosition1() {
        return position1;
    }

    public Position getPosition2() {
        return position2;
    }

    public Pair(Position position1, Position position2) {
        this.position1 = position1;
        this.position2 = position2;
    }

    public String toString (){
        return "position1: " + position1 + "  position2: " + position2;
    }
}
