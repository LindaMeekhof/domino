import static org.junit.Assert.*;

public class BonesTest {

    Bones boneCollection = new Bones();

    @org.junit.Test
    public void createBones() {
        boneCollection.createBones();
        System.out.println(boneCollection.getBones());
    }
}