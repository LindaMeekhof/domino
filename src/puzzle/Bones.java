package puzzle;


import java.util.ArrayList;
import java.util.List;

public class Bones {

    private List<Bone> bones = new ArrayList<>();

    public List<Bone> getBones() {
        return bones;
    }

    public void setBones(List<Bone> bones) {
        this.bones = bones;
    }

    public void createBones () {
        int value = 1;
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                if (x <= y) {
                    bones.add (new Bone (x, y, value));
                    value++;
                }
            }
        }
    }

}
