import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int n;
	public static int[] arr;
	public static int[] count = new int[10];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		int total = 0;
		int left = 0;
		int answer = 0;
		
		for (int right = 0; right < n; right++) {
			
			if (count[arr[right]] > 0) {
				count[arr[right]]++;
			} else {
				count[arr[right]]++;
				total++;
				while (total > 2) {
					if (count[arr[left]] == 1) {
						count[arr[left]]--;
						left++;
						total--;
					} else {
						count[arr[left]]--;
						left++;
					}
				}
				
			}
			answer = Math.max(answer, right-left+1);
		}
		System.out.println(answer);
	}

}
