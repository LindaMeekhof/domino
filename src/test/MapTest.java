package test;

import org.junit.Test;
import puzzle.*;

public class MapTest {

    @Test
    public void containsPlacement(){
        MapResults map = new MapResults();
        map.getPlacements().add(new Placement(new Bone(0,3), new Pair(new Position(0, 3, 4), new Position(0, 4, 5)) ));
        Pair p = new Pair(new Position(0, 3, 4), new Position(6, 5, 7));
        System.out.println(p.getPosition1());

        System.out.println(map);
        boolean result = map.containsPlacement(p);
        System.out.println(result);
    }

    @Test
    public void containsPlacement1(){
        MapResults map = new MapResults();
        map.getPlacements().add(new Placement(new Bone(0,3), new Pair(new Position(0, 3, 4), new Position(0, 4, 5)) ));
        Pair p = new Pair(new Position(3, 0, 4), new Position(6, 5, 7));
        System.out.println(p.getPosition1());

        System.out.println(map);
        boolean result = map.containsPlacement(p);
        System.out.println(result);
    }

    @Test
    public void containsPlacement2(){
        MapResults map = new MapResults();
        Pair p = new Pair(new Position(3, 0, 4), new Position(6, 5, 7));
        System.out.println(p.getPosition1());

        System.out.println(map);
        boolean result = map.containsPlacement(p);
        System.out.println(result);
    }

}