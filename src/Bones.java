import java.util.HashSet;
import java.util.Set;

public class Bones {

    private Set<Bone> bones = new HashSet<>();

    public Set<Bone> getBones() {
        return bones;
    }

    public void setBones(Set<Bone> bones) {
        this.bones = bones;
    }

    public void createBones () {
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 7; y++) {
                if (x <= y) {
                    bones.add (new Bone (x, y));
                }
            }
        }
    }

}
