package puzzle;

public class Bone {

    private int pip1;
    private int pip2;
    private int value;


    public Bone(int pip1, int pip2) {
        this.pip1 = pip1;
        this.pip2 = pip2;
    }

    public Bone(int pip1, int pip2, int value) {
        this.pip1 = pip1;
        this.pip2 = pip2;
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    public int getPip1() {
        return pip1;
    }

    public int getPip2() {
        return pip2;
    }

    public String toString(){
        return "[" + pip1 + "|" + pip2 + "] value : " + value;
    }
}
