import java.util.*;

public class Main {

    public static int[][] l1;
    public static int[][] visited;
    public static int n;
    public static int hn;
    public static int[][] d = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine(); // 버퍼 클리어

        l1 = new int[n + 2][n + 2];
        visited = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            String tmp = sc.nextLine();
            for (int j = 0; j < n; j++) {
                l1[i][j + 1] = tmp.charAt(j) - '0';
            }
        }

        List<Integer> hl = new ArrayList<>();
        int cnt = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (l1[i][j] == 1 && visited[i][j] == 0) {
                    hn = 0;
                    dfs(i, j, cnt);
                    if (hn == 0) {
                        hn = 1;
                    }
                    hl.add(hn);
                    cnt++;
                }
            }
        }

        Collections.sort(hl);
        System.out.println(hl.size());
        for (int i : hl) {
            System.out.println(i);
        }

        sc.close();
    }

    static void dfs(int x, int y, int c) {
        visited[x][y] = c;
        hn++;

        for (int[] direction : d) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (l1[nx][ny] == 1 && visited[nx][ny] == 0) {
                visited[nx][ny] = c;
                dfs(nx, ny, c);
            }
        }
    }
}
