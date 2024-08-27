import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드의 개수
        int m = sc.nextInt(); // 간선의 개수
        int v = sc.nextInt(); // 시작 노드

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[n + 1];
        visited[v] = true;
        System.out.print(v + " ");
        dfs(v);
        System.out.println();

        visited = new boolean[n + 1];
        Queue<Integer> bfsl = new LinkedList<>();
        bfsl.add(v);
        visited[v] = true;

        while (!bfsl.isEmpty()) {
            int tmp = bfsl.poll();
            System.out.print(tmp + " ");

            for (int i : graph[tmp]) {
                if (!visited[i]) {
                    visited[i] = true;
                    bfsl.add(i);
                }
            }
        }

        sc.close();
    }

    static void dfs(int v) {
        for (int tmp : graph[v]) {
            if (!visited[tmp]) {
                visited[tmp] = true;
                System.out.print(tmp + " ");
                dfs(tmp);
            }
        }
    }
}
