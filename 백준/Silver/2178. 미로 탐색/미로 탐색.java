import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static int solution(int[][] maps) {
        int r = maps.length;
        int c = maps[0].length;
        Deque<int[]> q = new ArrayDeque<>();

        int a = 0, b = 0;
        q.add(new int[]{a, b});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            a = current[0];
            b = current[1];

            if (a + 1 != r && maps[a + 1][b] == 1 && !(a + 1 == 0 && b == 0)) {
                maps[a + 1][b] = maps[a][b] + 1;
                q.add(new int[]{a + 1, b});
            }
            if (b + 1 != c && maps[a][b + 1] == 1 && !(a == 0 && b + 1 == 0)) {
                maps[a][b + 1] = maps[a][b] + 1;
                q.add(new int[]{a, b + 1});
            }
            if (a - 1 != -1 && maps[a - 1][b] == 1 && !(a - 1 == 0 && b == 0)) {
                maps[a - 1][b] = maps[a][b] + 1;
                q.add(new int[]{a - 1, b});
            }
            if (b - 1 != -1 && maps[a][b - 1] == 1 && !(a == 0 && b - 1 == 0)) {
                maps[a][b - 1] = maps[a][b] + 1;
                q.add(new int[]{a, b - 1});
            }

            if (a == r - 1 && b == c - 1) {
                return maps[r - 1][c - 1];
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);
        int[][] maps = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str1 = br.readLine();
            for (int j = 0; j < m; j++) {
                maps[i][j] = Character.getNumericValue(str1.charAt(j));
            }
        }

        System.out.println(solution(maps));
    }
}
