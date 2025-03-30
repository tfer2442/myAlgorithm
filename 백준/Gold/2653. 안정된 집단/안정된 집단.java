import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[][] nums;
	public static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// y=-x 대칭이 아닐 경우
		for (int i = 0 ; i < N-1; i++) {
			for (int j = 1; j < N; j++) {
				if (nums[i][j] != nums[j][i]) {
					System.out.println(0);
					return;
				}
			}
		}
		
		// 한 사람을 아무도 안 좋아하는 경우
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (nums[i][j] == 0) {
					cnt++;
				}
			}
			if (cnt == 1) {
				System.out.println(0);
				return;
			}
		}
		ArrayList<Integer>[] arr = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			for (int j = 0; j < N; j++) {
				if (nums[i][j] == 0 && !visited[j]) {
					arr[cnt].add(j+1);
					visited[j] = true;
					flag = true;
				}
			}
			if (flag) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			for (int j : arr[i]) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}
