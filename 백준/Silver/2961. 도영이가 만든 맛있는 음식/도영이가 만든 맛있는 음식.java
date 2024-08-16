import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] foods;
	public static int answer = Integer.MAX_VALUE;
	
	public static void calFood(int depth, int taste1, int taste2) {
		if (depth == N) {
			if (taste2 != 0) {
				answer = Math.min(answer, Math.abs(taste1-taste2));

			}
			return;
		}
		
		calFood(depth+1, taste1*foods[depth][0], taste2+foods[depth][1]);
		calFood(depth+1, taste1, taste2);
	}
	                                                        
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		foods = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			foods[i][0] = Integer.parseInt(st.nextToken());
			foods[i][1] = Integer.parseInt(st.nextToken());
		}
		
		calFood(0, 1, 0);
		System.out.println(answer);
		
	}

}
