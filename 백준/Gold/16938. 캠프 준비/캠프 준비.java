import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int N, L, R, X;
	public static int[] problems;
	public static int answer = 0;

	public static void combi(int cur, int cnt, int max, int min, int sum) {
		if (cur == N) {
			if (cnt >= 2 && max-min >= X && sum >= L && sum <= R) {
				answer++;
			}
			return;
		}
		
		combi(cur+1, cnt+1, Math.max(max, problems[cur]), Math.min(min, problems[cur]), sum+problems[cur]);
		combi(cur+1, cnt, max, min, sum);
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		L = Integer.parseInt(tmp[1]);
		R = Integer.parseInt(tmp[2]);
		X = Integer.parseInt(tmp[3]);
		
		problems = new int[N];
		tmp = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			problems[i] = Integer.parseInt(tmp[i]);
		}
		
		combi(0, 0, 0, Integer.MAX_VALUE, 0);
		System.out.println(answer);
	}

}
