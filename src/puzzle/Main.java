package puzzle;



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



        int[][] map = new int[2][6];
        map [0][1] = 6;
        map [1][5] = 5;
        map [1][4] = 3;


        int[][] n = new int[2][3];
        System.out.println("value" + n[1][1]);



    }


}
