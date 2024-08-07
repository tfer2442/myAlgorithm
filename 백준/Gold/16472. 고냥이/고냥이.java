import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static int N;
	public static String str1;
	public static HashMap<Character, Integer> hash = new HashMap<>();;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str1 = br.readLine();

		int left = 0;
		int right = 0;
		int cnt = 0;
		int maxValue = -1;
		
		while (right < str1.length() && left <= right) {

			if (hash.get(str1.charAt(right)) != null || hash.size() < N) {
				if (hash.get(str1.charAt(right)) == null) {
					hash.put(str1.charAt(right), 1);
				} else {
					hash.put(str1.charAt(right), hash.get(str1.charAt(right))+1);
				}
				cnt++;
				right++;
			} else {
				if (hash.get(str1.charAt(left)) >= 2) {
					hash.put(str1.charAt(left), hash.get(str1.charAt(left))-1);
				} else {
					hash.remove(str1.charAt(left));
				}
				left++;
				cnt--;
			}
			maxValue = Math.max(maxValue, cnt);
		}
		
		System.out.println(maxValue);
	}
}
