import java.util.*;
import java.io.*;

/*
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
			
			LinkedList<Character> password = new LinkedList<>();
			ListIterator<Character> it = password.listIterator();
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if (c == '<') {
					if (it.hasPrevious()) {
						it.previous();
					}
					continue;
				}
				
				if (c == '>') {
					if (it.hasNext()) {
						it.next();
					}
					continue;
				}
				
				if (c == '-') {
					if (it.hasPrevious()) {
						it.previous();
						it.remove();
					}
					continue;
				}
				
				it.add(c);
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (char c : password) {
				sb.append(c);
			}
			
			System.out.println(sb);
		}
	}

}
