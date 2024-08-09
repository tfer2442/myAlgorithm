import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n, k;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		k = Integer.parseInt(tmp[1]);
		arr = new int[n];
		tmp = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		int cnt = 0;
		int answer = 0;
		int left = 0;
		
		for (int right = 0; right < n; right++) {
			if (arr[right] % 2 == 1) {
				cnt++;
				
				while (k < cnt) {
					if (arr[left] % 2 == 1) {
						left++;
						cnt--;
					} else {
						left++;
					}
				}
			}
			answer = Math.max(answer, right-left-cnt+1);
		}
		System.out.println(answer);
	}

}
