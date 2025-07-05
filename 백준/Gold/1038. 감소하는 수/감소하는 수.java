import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static ArrayList<Long> arr;
	
	public static void dfs(long value) {
		arr.add(value);
		
		int last = (int)(value % 10);
		
		for (int i = 0; i < last; i++) {
			dfs(value*10+i);
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		
		for (int i = 0; i <= 9; i++) {
			dfs(i);
		}
		
		Collections.sort(arr);
		
		if (arr.size() <= N) {
			System.out.println(-1);
		} else {
			System.out.println(arr.get(N));			
		}
	}
}
