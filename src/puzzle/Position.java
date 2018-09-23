package puzzle;

public class Position {


    private int yCo;
    private int xCo;
    private int value;

    public Position() {
    }

    public Position (int yCo, int xCo, int value){
        this.yCo = yCo;
        this.xCo = xCo;
        this.value = value;
    }

    public int getyCo() {
        return yCo;
    }

    public void setyCo(int yCo) {
        this.yCo = yCo;
    }

    public int getxCo() {
        return xCo;
    }

    public void setxCo(int xCo) {
        this.xCo = xCo;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString(){
        return "( " + yCo + " , " + xCo + " )" + " value :" + value;
    }

}
