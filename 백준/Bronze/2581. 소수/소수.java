import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int M, N;
	public static boolean[] nums;
	
	public static void calPrime(int num) {
		for (int i = 2; i <= Math.pow(num, 0.5); i++) {
			if (num % i == 0) {
				return;
			}
		}
		
		int cnt = 2;
		while (true) {
			if (num * cnt > N) break; 
			nums[num*cnt] = true;
			cnt++;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		
		nums = new boolean[N+1];
		nums[1]= true;
		for (int i = 2; i <= N; i++) {
			if (nums[i]) continue;
			calPrime(i);
		}
		
		int total = 0;
		int minValue = 0;
		
		for (int i = M; i <= N; i++) {
			if (!nums[i]) {
				if (minValue == 0) {
					minValue = i;
				}
				total += i;
			}
		}
		
		if (total == 0) {
			System.out.println(-1);
		} else {
			System.out.println(total);
			System.out.println(minValue);
		}
	}

}
