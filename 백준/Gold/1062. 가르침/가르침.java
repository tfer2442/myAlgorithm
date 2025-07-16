import java.util.*;
import java.io.*;

/*
 * a,t,n,i,c 는 무조건 읽을 수 있어야 하므로 K에서 5는 미리 빼놓은 상태
 * a~z 까지 담을 수 있는 배열을 만들고, 가르친 소문자의 위치에 1로 변환
 * 조합 문제이다. 26개의 소문자 중에 K-5 조합을 구하면 된다.
 * 입력을 받을 때, 앞의 anta와 뒤의 tica는 제외하고 String[] 배열에 받자.
 * 만약 글자가 8글자라면 N을 하나 줄이고, answer += 1 하면 된다.
 */

public class Main {
	public static int N, K, answer;
	public static ArrayList<String> words;
	public static int[] alphabet;
	public static int maxValue;
	
	public static void combi(int depth, int idx) {
		if (depth == K) {
			int cnt = 0;
			
			for (String word : words) {
				boolean flag = false;
				for (int i = 0; i < word.length(); i++) {
					if (alphabet[word.charAt(i)-'a'] == 0) {
						flag = true;
						break;
					}
				}
				
				if (!flag) {
					cnt++;
				}
			}
			
			maxValue = Math.max(maxValue, cnt);
			return;
		}
		
		for (int i = idx; i < 26; i++) {
			if (alphabet[i] == 1) continue;
			
			alphabet[i] = 1;
			combi(depth+1, i+1);
			alphabet[i] = 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		words = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			if (tmp.length() == 8) {
				answer++;
				continue;
			}
			
			words.add(tmp.substring(4, tmp.length()-4));
		}
		
		if (K < 5) {
			System.out.println(0);
			return;
		}
		
		alphabet = new int[26];
		alphabet['a'-'a'] = 1;
		alphabet['n'-'a'] = 1;
		alphabet['t'-'a'] = 1;
		alphabet['i'-'a'] = 1;
		alphabet['c'-'a'] = 1;
		K -= 5;
		
		combi(0, 0);
		System.out.println(answer + maxValue);
	}
}
