import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int N, M;
	public static int[] nums;
	public static int[] visited;
	
	public static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(nums[i]+1+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i] == 1) continue;
			nums[cnt] = i;
			visited[i] = 1;
			perm(cnt+1);
			visited[i] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		nums = new int[M];
		visited = new int[N];
		
		perm(0);
	}

}
