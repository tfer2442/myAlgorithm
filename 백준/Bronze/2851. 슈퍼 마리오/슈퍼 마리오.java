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
		
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			int cur = arr[i];
			
			if (Math.abs(100-answer) >= Math.abs(100-(cur+answer))) {
				answer += cur;
			} else {
				break;
			}
		}
		System.out.println(answer);
	}

}
