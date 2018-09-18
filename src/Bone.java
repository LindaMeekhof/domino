public class Bone {

    private int pip1;
    private int pip2;

    public Bone(int pip1, int pip2) {
        this.pip1 = pip1;
        this.pip2 = pip2;
    }

    public Bone(){

    }

    public int getPip1() {
        return pip1;
    }

    public void setPip1(int pip1) {
        this.pip1 = pip1;
    }

    public int getPip2() {
        return pip2;
    }

    public void setPip2(int pip2) {
        this.pip2 = pip2;
    }

    public String toString(){
        return "[" + pip1 + "|" + pip2 + "]";
    }
}
