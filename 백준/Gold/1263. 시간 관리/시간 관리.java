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
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr.add(new int[] {start, end});
		}
		
		arr.sort((o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0]-o2[0];
			}
			return o1[1]-o2[1];
		});
		
		int tmp = arr.get(N-1)[1];
		
		for (int i = N-1; i >= 0; i--) {
			int time = arr.get(i)[0];
			int end = arr.get(i)[1];
	
			if (Math.min(end, tmp) - time < 0) {
				System.out.println(-1);
				return;
			}
			
			tmp = Math.min(end, tmp)-time;
		}
		System.out.println(tmp);
	}

}
