package puzzle;

public class Position {

    private int yCo;
    private int xCo;
    private int value;

    public Position (int yCo, int xCo, int value){
        this.yCo = yCo;
        this.xCo = xCo;
        this.value = value;
    }

    public int getyCo() {
        return yCo;
    }

    public int getxCo() {
        return xCo;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        return "( " + yCo + " , " + xCo + " )" + " value :" + value;
    }

}
