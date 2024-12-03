import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static ArrayList<int[]> arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.add(new int[] {a, b});
		}
		
		arr.sort((o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1]-o2[1];
			}
			return o1[0]-o2[0];
		});
		
		long answer = 0;
		int right = arr.get(0)[1];
		answer = right-arr.get(0)[0];
		
		for (int i = 1; i < N; i++) {
			if (arr.get(i)[1] <= right) continue;
			
			if (right >= arr.get(i)[0] && arr.get(i)[1] > right) {
				answer += arr.get(i)[1] - right;
			}
			else if (arr.get(i)[1] >= right) {
				answer += arr.get(i)[1] - arr.get(i)[0];
			}
			right = arr.get(i)[1];			
		}
		
		System.out.println(answer);
	}

}
