import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void connectOrder(List<Integer> singers, List<Map<Integer, Boolean>> orderGraph, int[] inDegree) {
        int totalPeople = singers.get(0);

        for (int i = 1; i < totalPeople; i++) {
            int current = singers.get(i);
            int next = singers.get(i + 1);
            if (!orderGraph.get(current).containsKey(next)) {
                orderGraph.get(current).put(next, true);
                inDegree[next] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<Map<Integer, Boolean>> orderGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            orderGraph.add(new HashMap<>());
        }

        int[] inDegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            String[] singerStr = br.readLine().split(" ");
            List<Integer> singers = new ArrayList<>();
            for (String s : singerStr) {
                singers.add(Integer.parseInt(s));
            }
            connectOrder(singers, orderGraph, inDegree);
        }

        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curSinger = q.poll();
            answer.add(curSinger);

            for (int nextSinger : orderGraph.get(curSinger).keySet()) {
                inDegree[nextSinger] -= 1;

                if (inDegree[nextSinger] == 0) {
                    q.add(nextSinger);
                }
            }
        }

        if (answer.size() != n) {
            System.out.println(0);
        } else {
            for (int singer : answer) {
                System.out.println(singer);
            }
        }
    }
}
