import java.util.*;
import java.io.*;

/*
 * 다시 풀어보기!!
 * 
 * iterator와 StringBuilder에 대해서 잘 알 것.
 * stack으로도 풀 수 있음.
 * 
 * 알파벳 대문자, 소문자, 숫자, 백스페이스(-), 화살표(<, >)
 * 링크드리스트 문제
 */
public class Main {
	public static int T;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			
			// 커서 왼쪽 dq1, 커서 오른쪽 dq2
			ArrayDeque<Character> dq1 = new ArrayDeque<>();
			ArrayDeque<Character> dq2 = new ArrayDeque<>();
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if (c == '<') {
					if (!dq1.isEmpty()) {
						dq2.push(dq1.pop());						
					}
					continue;
				}
				
				if (c == '>') {
					if (!dq2.isEmpty()) {
						dq1.push(dq2.pop());
					}
					continue;
				}
				
				if (c == '-') {
					if (!dq1.isEmpty()) {
						dq1.pop();
					}
					continue;
				}
				
				dq1.push(c);
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (char c : dq1) {
				sb.append(c);
			}
			sb.reverse();
			
			for (char c : dq2) {
				sb.append(c);
			}
			
			System.out.println(sb);
		}
	}

}
