import java.util.*;
import java.io.*;

/*
 * 올바르지 않은 괄호는 0
 * 양 사이드에서부터 괄호의 짝을 찾아 나가면 되는 투 포인터 문제 X
 * -> 이걸로는 올바른 괄호인지 찾을 수 없음
 * 
 * 스택을 이용해서, 올바른 괄호를 찾자
 * 1. 스택에 순서대로 넣자. 
 * 2. 맨 위의 top값과 들어오는 값이 짝이 맞는지 확인
 * 3. 또는, 열린 괄호인지 확인
 * 4. 닫힌 괄호가 들어왔을 경우, 짝이 안 맞다면 return 0
 * 5. 만약 스택이 비게 된다면, 누적합을 저장하고 0으로 초기화
 */
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		if (arr.length % 2 == 1) {
			System.out.println(0);
			return;
		}
		
		ArrayDeque<Character> dq = new ArrayDeque();
		int answer = 0;
		int num = 1;
		char prev = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				num *= 2;
				dq.push(arr[i]);
			} else if (arr[i] == '[') {
				num *= 3;
				dq.push(arr[i]);
			} else if (arr[i] == ')') {
				if (dq.isEmpty() || dq.peek() != '(') {
					System.out.println(0);
					return;
				}
				
				if (prev == '(') {
					answer += num;
				}
				
				dq.pop();
				num /= 2;
			} else if (arr[i] == ']') {
				if (dq.isEmpty() || dq.peek() != '[') {
					System.out.println(0);
					return;
				}
				
				if (prev == '[') {
					answer += num;
				}
				
				dq.pop();
				num /= 3;
			}
			
			prev = arr[i];
		}
		
		if (dq.isEmpty()) {
			System.out.println(answer);
		} else {
			System.out.println(0);
		}
	}
}
