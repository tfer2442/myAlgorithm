import java.util.*;
import java.io.*;


/*
 * 회문: 0, 유사회문: 1, 일반: 2
 * 1 <= N <= 30, 3 <= 문자열 길이 <= 100,000, 소문자로만 구성
 * 양 쪽 끝에서 left++, right-- 하면서 같은지 비교
 * 만약 다르다면 (처음 발생), left+1 할지 right-1 할지 결정 -> 이게 핵심인데, 두 가지의 경우에서 모두 확인해보는게 맞음.
 * 이후에 또 다른 상황이 발생한다면, 일반 문자열
 */
public class Main {
	public static int N;
	public static String[] arr;
	public static int[] answer;
	
	public static boolean isCircularStr(int i, int left, int right) {
		
		while (left < right) {
			char lword = arr[i].charAt(left);
			char rword = arr[i].charAt(right);
			
			
			if (lword != rword) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		answer = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = arr[i].length()-1;
			int cnt = 0;
			
			while (left < right) {
				char lword = arr[i].charAt(left);
				char rword = arr[i].charAt(right);
				
				
				if (lword == rword) {
					left++;
					right--;
					continue;
				}
				
				if (isCircularStr(i, left+1, right) || isCircularStr(i, left, right-1)) {
					cnt = 1;
				} else {
					cnt = 2;
				}
				break;
			}
			answer[i] = cnt;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(answer[i]);
		}
	}
}
