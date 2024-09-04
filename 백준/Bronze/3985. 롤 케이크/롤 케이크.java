import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] people = new int[N+1];
		int[] cake = new int[L+1];
		int answer = Integer.MIN_VALUE;
		int person = -1;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (b-a > answer) {
				answer = b-a;
				person = i+1;
			}
			
			for (int j = a; j <= b; j++) {
				if (cake[j] == 0) {
					cake[j] = i+1;
					people[i+1]++;
				}
			}
		}
		
		int answer2 = Integer.MIN_VALUE;
		int person2 = -1;
		for (int i = 1; i <= N; i++) {
			if (people[i] > answer2) {
				answer2 = people[i];
				person2 = i;
			}
		}
		System.out.println(person);
		System.out.println(person2);
	}

}
