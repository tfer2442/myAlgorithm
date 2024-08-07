import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, K;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		K = Integer.parseInt(tmp[1]);
		arr = new int[N];
		
		tmp = br.readLine().split(" ");
		int left = 0;
		int right = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
			right += arr[i];
		}
		
		int answer = 0;
		
		while (left <= right) {
			int mid = (left+right)/2;
			int group = 0;
			int scoreTotal = 0;
			
			for (int i = 0; i < N; i++) {
				if (scoreTotal + arr[i] < mid) {
					scoreTotal += arr[i];
				} else {
					scoreTotal = 0;
					group++;
				}
			}
			
			if (group >= K) {
				left = mid+1;
				answer = Math.max(answer, mid);
			} else if (group < K) {
				right = mid-1;
			}
		}
		
		System.out.println(answer);	
	}
}
