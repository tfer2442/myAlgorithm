import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[][] lectures;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lectures = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectures[i][0] = p;
            lectures[i][1] = d;
        }
        
        Arrays.sort(lectures, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            int p = lectures[i][0];
            int d = lectures[i][1];
            
            if (pq.size() < d) {
                pq.offer(p);
            } else if (!pq.isEmpty() && pq.peek() < p) {
                pq.poll();
                pq.offer(p);
            }
        }
        
        int answer = 0;
        while (!pq.isEmpty()){
            answer += pq.poll();
        }
        
        System.out.println(answer);
    }
}
