package puzzle;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("test");

        int[][] input = new int[][]{
                {6, 6, 2, 6, 5, 2, 4, 1},
                {1, 3, 2, 0, 1, 0, 3, 4},
                {1, 3, 2, 4, 6, 6, 5, 4},
                {1, 0, 4, 3, 2, 1, 1, 2},
                {5, 1, 3, 6, 0, 4, 5, 5},
                {5, 5, 4, 0, 2, 6, 0, 3},
                {6, 0, 5, 3, 4, 2, 0, 3}
        };

        int x = input [2][3];
        System.out.println(x);

        int iii = 3;
        int yyy = iii + 1;
        System.out.println(yyy);

        int[][] map = new int[2][2];
        map [0][1] = 6;


        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("test2");
        list.add("test3");
        System.out.println(list);

      //  list.clear();
        System.out.println("clear" + list);

        List<String> nList = new ArrayList();
        nList.addAll(list);
        System.out.println("new list" + nList);


        int[][] n = new int[2][3];
        System.out.println("value" + n[1][1]);
    }


}
