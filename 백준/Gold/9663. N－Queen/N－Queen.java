import java.util.*;
import java.io.*;


public class Main {
	public static int N, answer;
	public static int[] board;
	
	public static boolean isPlaceable(int depth, int num) {
		for (int i = 0; i < depth; i++) {
			if (Math.abs(i-depth) == Math.abs(board[i]-num)) {
				return false;
			}
			
			if (board[i] == num) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void nQueen(int depth) {
		if (depth == N) {
			answer++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (isPlaceable(depth, i)) {
				board[depth] = i;
				nQueen(depth+1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N];
		
		nQueen(0);
		
		System.out.println(answer);
	}
}
