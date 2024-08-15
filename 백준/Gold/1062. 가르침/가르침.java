import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static int N, K;
	public static String[] arr;
	public static Character[] dict = {'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z'};   
	public static HashSet<Character> hs = new HashSet<>();
	public static int answer = 0;
	
	public static void combi(int cnt, int depth) {
		if (cnt == K-5) {
			int tmp = 0;
			
			for (int i = 0; i < N; i++) {
				boolean flag = false;

				for (int j = 0; j < arr[i].length(); j++) {
					if (!hs.contains(arr[i].charAt(j))) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					tmp++;
				}
			}
			answer = Math.max(answer, tmp);
			return;
		}
		
		for (int i = depth; i < 21; i++) {
			hs.add(dict[i]);
			combi(cnt+1, i+1);
			hs.remove(dict[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		K = Integer.parseInt(tmp[1]);
		
		arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		if (K < 5) {
			System.out.println("0");
			return;
		}
		
		hs.add('a');
		hs.add('n');
		hs.add('t');
		hs.add('i');
		hs.add('c');
		combi(0, 0);
		System.out.println(answer);
	}

}
