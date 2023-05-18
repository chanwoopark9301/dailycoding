package tree;

import java.util.Arrays;

public class matrix1 {
    public static void main(String[] args) {
        int[][] output1 = createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });

        System.out.println(Arrays.deepToString(output1));
        int[][] output2 = createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });

        System.out.println(Arrays.deepToString(output2));
    }


    public static int[][] createMatrix(int[][] edges) {
        // TODO:방향이 있는 간선과 방향이 없는 간선들의
        //  목록들을 받아 2차원 배열의 인접행렬을 반환하는
        //  함수를 작성하세요.

        int size = 0;
        for (int i = 0; i < edges.length; i++) {
            size = Math.max(size, edges[i][0]);
            size = Math.max(size, edges[i][1]);
            size = Math.max(size, edges[i][2]);
        }
        int[][] result = new int[size + 1][size + 1];

        for (int j = 0; j < edges.length; j++) {
            int from = edges[j][0];
            int to = edges[j][1];
            result[from][to] = 1;
            if (edges[j][2] != 0) {
                result[to][from] = 1;
            }
        }
        return result;
    }

}
