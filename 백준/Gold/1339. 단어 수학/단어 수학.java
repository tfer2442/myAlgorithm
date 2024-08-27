import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static int N;
	public static HashMap<Character, Integer> hm = new HashMap<>(); 
	public static int[] arr;
	public static int[] nums;
	public static boolean[] visited;
	public static int total;
	public static ArrayList<Character> list = new ArrayList<>();
	public static String[] str;
	public static int answer = 0;
	
	public static void permu(int depth) {
		if (depth == total) {
			for (int i = 0; i < total; i++) {
				hm.put(list.get(i), nums[i]);
			}
			
			int tmpAnswer = 0;

			for (int i = 0; i < N; i++) {
				int num = 0;
				for (int j = 0; j < str[i].length(); j++) {
					num *= 10;
					num += hm.get(str[i].charAt(j));
				}
				tmpAnswer += num;
			}
			answer = Math.max(answer, tmpAnswer);
			
			return;
		}
		
		for (int i = 0; i < total; i++) {
			if (!visited[i]) {
				visited[i] = true;
				nums[depth] = arr[i];
				permu(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		total = 0;
		str = new String[N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			str[i] = tmp;
			
			for (int j = 0; j < tmp.length(); j++) {
				if (!hm.containsKey(tmp.charAt(j))) {
					total++;
					hm.put(tmp.charAt(j), 0);
					list.add(tmp.charAt(j));
				}
			}
		}
		
		arr = new int[total];
		visited = new boolean[total];
		nums = new int[total];
		int cnt = 0;
		for (int i = 9; i > 9-total; i--) {
			arr[cnt] = i;
			cnt++;
		}
		
		permu(0);
		System.out.println(answer);
	}

}
