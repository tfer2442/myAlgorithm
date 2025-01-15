import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static HashSet<String> hs = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String p = br.readLine();
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				hs.add(s.substring(i, j));
			}
		}
		
		int answer = 1;
		for (int left = 0; left < p.length(); left++) {
			StringBuilder sb = new StringBuilder();
			for (int right = left; right < p.length(); right++) {
				sb.append(p.charAt(right));
				
				if (!hs.contains(sb.toString())) {
					answer++;
					left = right-1;
					break;
				}
			}
		}
		System.out.println(answer);
	}

}
