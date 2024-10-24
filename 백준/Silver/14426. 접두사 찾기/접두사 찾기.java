import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static int N, M;
	public static HashSet<String>[] hs;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		hs = new HashSet[501];
		
		for (int i = 1; i <= 500; i++) {
			hs[i] = new HashSet<>();
		}

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < tmp.length(); j++) {
				sb.append(tmp.charAt(j));
				hs[sb.length()].add(sb.toString());
			}
		}
		
		int cnt = 0;
		
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if (hs[tmp.length()].contains(tmp)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
