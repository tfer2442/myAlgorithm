import java.util.*;
import java.io.*;

public class Main {
	public static boolean[] broken;
	public static int N, K, B;
	public static int count = 0;
	public static int answer;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		broken = new boolean[N+1];
		
		for (int i = 0; i < B; i++) {
			int a = Integer.parseInt(br.readLine());
			broken[a] = true;
		}
		
		for (int i = 1; i <= K; i++) {
			if (broken[i]) {
				count++;
			}
		}
		
		answer = count;
		
		for (int i = 2; i <= N-K+1; i++) {
			if (broken[i-1]) {
				count--;
			}
			if (broken[i+K-1]) {
				count++;
			}
			answer = Math.min(answer, count);
		}
		
		System.out.println(answer);
		
	}

}
