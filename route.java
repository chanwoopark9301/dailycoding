package tree;

public class route {
    public static void main(String[] args) {
        boolean result = getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2
        );
        System.out.println(result); // true
// 정점 0에서 2로 가는 길이 존재하는지 확인합니다.
// 0 --> 1 로 가는 간선이 존재하고, 1 --> 2 로 가는 간선이 존재하기 때문에 true를 반환합니다.

        boolean result2 = getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        },
                1,
                4
        );
        System.out.println(result2); // false

// 정점 1에서 4로 가는 길이 존재하는지 확인합니다.
// 1 --> 3,
// 3 --> 1 (정점 1을 다녀왔으니 다시 돌아가지 않습니다),
// 3 --> 2,
// 2 --> 1 (정점 1을 다녀왔으니 다시 돌아가지 않습니다)
// ...으로, 4에 도달할 수 없습니다.
    }

    public static boolean getDirections(int[][] matrix, int from, int to) {
        // TODO:주어진 인접행렬에서 한 정점으로부터 다른 정점으로 이어지는 길이 존재하는지 반환해야 합니다.

        if (matrix[from][to] == 1) {
            return true;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[from][i] == 1) {
                matrix[from][i] = 0;

                if (getDirections(matrix, i, to)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
queue를 활용한 풀이 방법
public static boolean getDirections(int[][] matrix, int from, int to) {
    boolean[] visited = new boolean[matrix.length];
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(from);
    visited[from] = true;

    while (!queue.isEmpty()) {
        int current = queue.poll();
        if (current == to) {
            return true;
        }
        for (int i = 0; i < matrix[current].length; i++) {
            if (matrix[current][i] == 1 && !visited[i]) {
                queue.offer(i);
                visited[i] = true;
            }
        }
    }
    return false;
}
 */
