import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int[] fruits;
	public static int[] count = new int[10]; // 1~9까지 사용, 인덱스 0은 사용 안함

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		fruits = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int answer = 0;
		int types = 0; // 현재 과일 종류 수
		
		for (int right = 0; right < N; right++) {
			// 새로운 과일 추가
			if (count[fruits[right]] == 0) {
				types++;
			}
			count[fruits[right]]++;
			
			// 과일 종류가 2개를 초과하면 left 포인터 이동
			while (types > 2) {
				count[fruits[left]]--;
				if (count[fruits[left]] == 0) {
					types--;
				}
				left++;
			}
			
			answer = Math.max(answer, right - left + 1);
		}
		
		System.out.println(answer);
	}
}