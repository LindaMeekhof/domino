import org.junit.jupiter.api.Test;
import puzzle.Bones;

public class BonesTest {

    Bones boneCollection = new Bones();

    @Test
    public void createBones() {
        boneCollection.createBones();
        System.out.println(boneCollection.getBones());
    }
}