import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[10];
		
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int answer2 = 0;
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			int total = 0;
			for (int j = 0; j <= i; j++) {
				total += arr[j];
			}
			if (Math.abs(100-total) < answer) {
				answer = Math.abs(100-total);
				answer2 = total;
			} else if (Math.abs(100-total) == answer) {
				answer2 = Math.max(answer2, total);
			}
		}
		System.out.println(answer2);
	}

}
