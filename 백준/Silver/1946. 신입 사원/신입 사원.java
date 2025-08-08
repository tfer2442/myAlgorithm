import java.util.*;
import java.io.*;

/*
 * 이중 반복문으로 N^2으로 쉽게 풀 수 있음.
 * O(NlogN) 이내로 줄여야 함
 */
public class Main {
	public static int T, N;
	public static int[][] scores;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			scores = new int[N][2];
			
			StringTokenizer st;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i][0] = Integer.parseInt(st.nextToken());
				scores[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(scores, (o1, o2) -> {
				return o1[0] - o2[0];
			});
			
			int cnt = 1;
			int value = scores[0][1];
			
			for (int i = 1; i < N; i++) {
				if (scores[i][1] < value) {
					value = scores[i][1];
					cnt++;
				}
				
			}
			
			System.out.println(cnt);
		}
	}

}
