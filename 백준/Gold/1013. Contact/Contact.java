import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String pattern = "(100+1+|01)+";
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.matches(pattern)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
