import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static ArrayList<Integer>[] higher;
    public static ArrayList<Integer>[] lower;
    public static int[] higherCount; // 메모이제이션
    public static int[] lowerCount;  // 메모이제이션

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        higher = new ArrayList[N+1];
        lower = new ArrayList[N+1];
        higherCount = new int[N+1];
        lowerCount = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            higher[i] = new ArrayList<>();
            lower[i] = new ArrayList<>();
            higherCount[i] = -1; // 아직 계산 안함
            lowerCount[i] = -1;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            higher[b].add(a); // b보다 무거운 것: a
            lower[a].add(b);  // a보다 가벼운 것: b
        }
        
        int answer = 0;
        int mid = (N + 1) / 2;
        
        for (int i = 1; i <= N; i++) {
            int h = getHigherCount(i);
            int l = getLowerCount(i);
            
            if (h >= mid || l >= mid) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
    
    public static int getHigherCount(int ball) {
        if (higherCount[ball] != -1) return higherCount[ball];
        
        boolean[] visited = new boolean[N+1];
        return higherCount[ball] = dfs(ball, higher, visited);
    }
    
    public static int getLowerCount(int ball) {
        if (lowerCount[ball] != -1) return lowerCount[ball];
        
        boolean[] visited = new boolean[N+1];
        return lowerCount[ball] = dfs(ball, lower, visited);
    }
    
    public static int dfs(int ball, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[ball] = true;
        int count = 0;
        
        for (int next : graph[ball]) {
            if (!visited[next]) {
                count += 1 + dfs(next, graph, visited);
            }
        }
        
        return count;
    }
}