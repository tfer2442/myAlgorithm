import java.util.*;
import java.io.*;

/*
 * 정렬 후 조합하면 되는 문제 
 */
public class Main {
	public static int N, M;
	public static int[] nums;
	public static int[] combi;
	public static LinkedHashSet<String> hs;
		
	public static void combination(int idx, int depth) {
		if (depth >= M) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < M; i++) {
				sb.append(combi[i]).append(" ");
			}
			
			hs.add(sb.toString());
			return;
		}
		
		for (int i = idx; i < N; i++) {
			combi[depth] = nums[i];
			combination(i+1, depth+1);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		combi = new int[M];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		hs = new LinkedHashSet<>();
		combination(0, 0);
		
		for (String tmp : hs) {
			System.out.println(tmp);
		}
	}

}
