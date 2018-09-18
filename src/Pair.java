public class Pair {

    private static Position position1;
    private static Position position2;

    public Pair() {

    }

    public Pair(Position position1, Position position2) {
        this.position1 = position1;
        this.position2 = position2;
    }

    public String toString (){
        return "position1: " + position1 + "  position2: " + position2;
    }
}
