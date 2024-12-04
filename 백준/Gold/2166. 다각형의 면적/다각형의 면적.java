import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static ArrayList<long[]> arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken());
			long b = Integer.parseInt(st.nextToken());
			
			arr.add(new long[] {a, b});
		}
		
		long startX = arr.get(0)[0];
		long startY = arr.get(0)[1];
		long answer = 0;
		
		for (int i = 1; i < N-1; i++) {
			long firstX = arr.get(i)[0];
			long firstY = arr.get(i)[1];
			long secondX = arr.get(i+1)[0];
			long secondY = arr.get(i+1)[1];
			
			answer += startX*firstY + firstX*secondY + secondX*startY - firstX*startY - secondX*firstY - startX*secondY;
		}
		
		answer = Math.abs(answer);
		
		System.out.printf("%.1f\n", answer/2.0);
	}
}
