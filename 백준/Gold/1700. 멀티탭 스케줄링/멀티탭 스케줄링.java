import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static int N, K;
	public static HashSet<Integer> plug = new HashSet<>();
	public static int[] nums;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int answer = 0;
		nums = new int[K];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < K; i++) {
			if (plug.contains(nums[i])) continue;
			if (plug.size() < N) {
				plug.add(nums[i]);
				continue;
			}
			
			HashSet<Integer> check = new HashSet<>();
			boolean flag = false;
			for (int j = i+1; j < K; j++) {
				if (plug.size()-check.size() == 1) {
					HashSet<Integer> tmp = new HashSet<>(plug);
					tmp.removeAll(check);
					for (int a : tmp) {
						plug.remove(a);
						plug.add(nums[i]);
						answer++;
						flag = true;
						break;
					}
					break;
				}
				if (plug.contains(nums[j])) {
					check.add(nums[j]);
				}
			}
			
			if (flag) continue;
			
			HashSet<Integer> tmp = new HashSet<>(plug);
			tmp.removeAll(check);
			
			for (int a : tmp) {
				plug.remove(a);
				plug.add(nums[i]);
				answer++;
				break;
			}
		}
		System.out.println(answer);
	}
}
