import java.util.*;
import java.io.*;

public class Solution {
	public static int T, N;
	public static int[][] board;
	public static int[][] stairs;
	public static ArrayList<int[]> people;
	public static int[] nums;
	public static int total, answer;
	
	public static void dfs(int depth) {
		if (depth >= total) {
			answer = Math.min(answer, calculate());
			return;
		}
		
		nums[depth] = 0;
		dfs(depth+1);
		nums[depth] = 1;
		dfs(depth+1);
	}
	
	public static int calculate() {
		// nums에 선택한 계단들이 놓아져있음
		// people에는 사람들의 r, c 좌표가 있음
		// staris[0] : 0번 계단, staris[1] : 1번 계단 
		
		// people이 계단 위에 도착하는 시간
		PriorityQueue<Integer>[] waiting = new PriorityQueue[2];
		PriorityQueue<Integer>[] running = new PriorityQueue[2];
		
		for (int i = 0; i < 2; i++) {
			waiting[i] = new PriorityQueue<>((o1, o2)->{
				return o1-o2;
			});
			running[i] = new PriorityQueue<>((o1, o2)->{
				return o1-o2;
			});
		}
		
		for (int i = 0; i < total; i++) {
			// i : 현재 people
			// nums[i] : 고른 계단
			
			waiting[nums[i]].add(Math.abs(people.get(i)[0] - stairs[nums[i]][0]) + Math.abs(people.get(i)[1] - stairs[nums[i]][1]));
		}
		

		int time = 0;
		int remain = total;
		
		while (remain > 0) {
			time++;
			
			for (int s = 0; s < 2; s++) {
				while (!running[s].isEmpty()) {
					if (running[s].peek() <= time) {
						running[s].poll();
						remain--;
					} else {
						break;
					}
				}
				
				while (!waiting[s].isEmpty()) {
					if (running[s].size() < 3 && waiting[s].peek() < time) {
						waiting[s].poll();
						running[s].add(time+stairs[s][2]);
					} else {
						break;
					}
				}
			}
						
		}
		
		
		return time;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
//			board = new int[N][N];
			stairs = new int[2][3];
			people = new ArrayList<>();
			int stairCnt = 0;
			total = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < N; j++) {
					int value = Integer.parseInt(st.nextToken());
					
					if (value == 1) {
						people.add(new int[] {i, j});
						total++;
					} else if (value >= 2){
						stairs[stairCnt][0] = i;
						stairs[stairCnt][1] = j;
						stairs[stairCnt][2] = value;
						stairCnt++;
					}
				}
			}
			nums = new int[total];
			
			answer = Integer.MAX_VALUE;
			dfs(0);
			
			System.out.println("#" + t + " " + answer);
		}		
	}
}
