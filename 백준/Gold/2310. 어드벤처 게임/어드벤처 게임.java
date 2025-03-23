import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static ArrayList<Integer>[] graph;
    // roomType: 0 = 빈 방(E), 1 = 레프리콘(L), 2 = 트롤(T)
    public static int[] roomType;
    // roomAmt: 레프리콘이면 채워주는 금액, 트롤이면 통행료 (빈 방은 0)
    public static int[] roomAmt;
    // money[i]는 i번 방에 도달했을 때 모을 수 있는 최대 금액
    public static int[] money;
    public static boolean flag;
    
    // DFS로 상태 전파: 만약 더 높은 금액으로 도달할 수 있다면 해당 방을 다시 방문함
    public static void dfs(int room) {
        if (room == N) {
            flag = true;
            return;
        }
        for (int next : graph[room]) {
            int curMoney = money[room];
            int newMoney = curMoney;
            // 방 next에 들어갈 때 처리: 방의 종류에 따라 금액 갱신
            if (roomType[next] == 1) {  // 레프리콘: 모험가의 금액이 적으면 금액을 채워줌
                newMoney = Math.max(curMoney, roomAmt[next]);
            } else if (roomType[next] == 2) {  // 트롤: 통행료를 지불해야 함
                if (curMoney < roomAmt[next]) continue; // 금액이 부족하면 갈 수 없음
                newMoney = curMoney - roomAmt[next];
            }
            // 빈 방(E)인 경우엔 금액 변화 없음
            
            // 이미 더 많은 금액으로 방문한 적이 있다면 재방문할 필요 없음
            if (newMoney > money[next]) {
                money[next] = newMoney;
                dfs(next);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            roomType = new int[N + 1];
            roomAmt = new int[N + 1];
            money = new int[N + 1];
            flag = false;
            Arrays.fill(money, -1);
            
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char type = st.nextToken().charAt(0);
                int amt = Integer.parseInt(st.nextToken());
                if (type == 'E') {
                    roomType[i] = 0;
                    roomAmt[i] = 0;
                } else if (type == 'L') {
                    roomType[i] = 1;
                    roomAmt[i] = amt;
                } else if (type == 'T') {
                    roomType[i] = 2;
                    roomAmt[i] = amt;
                }
                // 자기 자신으로 가는 문은 무시
                while (true) {
                    int next = Integer.parseInt(st.nextToken());
                    if (next == 0) break;
                    if (next == i) continue;
                    graph[i].add(next);
                }
            }
            
            // 시작 금액은 0에서 출발하며, 방의 성격에 따라 초기 금액을 결정
            int startMoney = 0;
            if (roomType[1] == 1) {  // 레프리콘
                startMoney = roomAmt[1];
            } else if (roomType[1] == 2) {  // 트롤이면 통행료 지불 필요
                if (0 < roomAmt[1]) {  // 출발 시 금액이 부족하여 시작 불가능
                    System.out.println("No");
                    continue;
                }
            }
            money[1] = startMoney;
            dfs(1);
            System.out.println(flag ? "Yes" : "No");
        }
    }
}
