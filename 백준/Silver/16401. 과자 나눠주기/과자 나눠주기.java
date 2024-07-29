import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int M, N;
	static int[] arr;
	static int left = 1;
	static int right = 1;
	static int mid;
	
	static boolean isDivideSnack(int mid) {
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			cnt += arr[i]/mid;
			if (cnt >= M) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		M = Integer.parseInt(tmp[0]);	
		N = Integer.parseInt(tmp[1]);
		arr = new int[N];
		
		tmp = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			right = Math.max(right, arr[i]);
			sum += arr[i];
		}
		
		if (sum < M) {
			System.out.println(0);
			System.exit(0);
		}
		
		int answer = 0;
		while (left <= right) {
			mid = (left+right)/2;
			
			if (isDivideSnack(mid)) {
				answer = Math.max(answer, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}

}
