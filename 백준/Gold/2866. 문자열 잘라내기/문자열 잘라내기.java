import java.io.*;
import java.util.*;

public class Main {
	public static int N, C;
	public static char[][] board;
	public static HashSet<String> hs;
	
	public static boolean binarySearch(int mid) {
		hs = new HashSet<>();
		
		for (int i = 0; i < C; i++) {
			StringBuilder sb  = new StringBuilder();
			for (int j = mid+1; j < N; j++) {
				sb.append(board[j][i]);
			}
			String s = sb.toString();
			
			if (hs.contains(s)) {
				return false;
			}
			hs.add(s);
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		C = Integer.parseInt(tmp[1]);
		board = new char[N][C];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}
				
		int left = 0;
		int right = N-1;
		int answer = -1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (binarySearch(mid)) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer+1);
	}

}
