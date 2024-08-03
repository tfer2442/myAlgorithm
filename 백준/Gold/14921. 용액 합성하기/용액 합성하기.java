import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	public static int[] A;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tmp[i]);
		}
		
		int left = 0;
		int right = N-1;
		int minValue = Integer.MAX_VALUE;
		
		while (left < right) {
			if (Math.abs(minValue) > Math.abs(A[left]+A[right])) {
				minValue = A[left]+A[right];
			}
			
			if (A[left]+A[right] < 0) {
				left++;
			} else if (A[left]+A[right] > 0) {
				right--;
			} else if (A[left]+A[right] == 0) {
				System.out.println(0);
				System.exit(0);
			}			
		}
		
		System.out.println(minValue);

	}
}
