import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static String str;
	public static HashMap<Character, Integer> alphabetCount;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		// left, right 필요
		// 한 칸씩 보면서(알파벳 초과하는지 확인), 만약에 초과하지 않는다면 right ++
		// 만약에 초과한다면? 새로운 알파벳이 들어온 것이므로, left를 ++ 하며, 알파벳의 종류 갯수를 맞춰줘야 함
		
		alphabetCount = new HashMap<>();
		
		int left = 0;
		int right = 0;
		int len = 0;
		int answer = 0;
		
		while (left < str.length() && right < str.length()) {
			Character target = str.charAt(right);
			
			if (alphabetCount.containsKey(target)) {
				len++;
				right++;
				
				answer = Math.max(len, answer);
				alphabetCount.put(target, alphabetCount.get(target)+1);
				continue;
			}
			
			if (alphabetCount.size() < N) {
				len++;
				right++;
				
				answer = Math.max(len, answer);
				alphabetCount.put(target, 1);
				continue;
			}
			
			while (left <= right) {
				if (alphabetCount.size() < N) {
					len++;
					right++;
					alphabetCount.put(target, 1);
					break;
				}

				if (alphabetCount.get(str.charAt(left)) >= 2) {
					alphabetCount.put(str.charAt(left), alphabetCount.get(str.charAt(left))-1);  // 수정: str.charAt(left)-1을 alphabetCount.get(str.charAt(left))-1로 변경
				} else {
					alphabetCount.remove(str.charAt(left));
				}
				
				len--;
				left++;
			}
		}
		System.out.println(answer);
	}
}
