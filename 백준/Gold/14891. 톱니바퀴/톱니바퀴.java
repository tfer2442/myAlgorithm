import java.util.*;
import java.io.*;

/*
 * 단순 구현 문제
 * 명령어의 갯수가 주어지고, 톱니바퀴와 방향을 선택하여 rotate 하는 문제
 * 1 -> 시계 방향, -1 -> 반시계 방향
 * 
 * 비트 연산으로 할 수 있을 것 같긴한데, 배열로 해보자
 * 톱니 1는 톱니 2에 영향
 * 톱니 2는 톱니 1, 2에 영향
 * 톱니 3은 톱니 2, 4에 영향
 * 톱니 4는 톱니 3에 영향
 * 
 * dfs를 이용해서, 왼쪽 톱니 오른쪽 톱니를 재귀적으로 볼 수 있을듯
 * visited 이용해서 돌린 톱니는 놔둬야겠네
 * 돌릴 방향을 배열에 넣어놓고, 이후에 처리
 */
public class Main {
	public static int[] commands;
	public static boolean[] visited;
	public static ArrayList<Character>[] gears;
	public static int N;
	
	public static void rotateGear(int idx, int d) {
		if (idx == -1 || idx == 4) return;
		
		visited[idx] = true;
		commands[idx] = d;
		
		if (idx < 3) {
			if (!visited[idx+1] && gears[idx].get(2) != gears[idx+1].get(6)) {
				rotateGear(idx+1, d*(-1));				
			}
		}
		
		if (idx > 0) {
			if (!visited[idx-1] && gears[idx].get(6) != gears[idx-1].get(2)) {
				rotateGear(idx-1, d*(-1));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		gears = new ArrayList[4];
		
		for (int i = 0; i < 4; i++) {
			gears[i] = new ArrayList<>();
			
			String tmp = br.readLine();
			
			for (int j = 0; j < 8; j++) {
				gears[i].add(tmp.charAt(j));
			}
		}
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			
			visited = new boolean[4];
			commands = new int[4];
			
			rotateGear(num, d);
			
			for (int j = 0; j < 4; j++) {
				Collections.rotate(gears[j], commands[j]);
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < 4; i++) {
			if (gears[i].get(0) == '1') {
				answer += Math.pow(2, i);
			}
		}
		
		System.out.println(answer);
	}
}
