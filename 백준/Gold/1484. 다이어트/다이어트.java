import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static int G;
	public static ArrayList<Integer> arr;
	public static ArrayList<Integer> answer;
 	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		answer = new ArrayList<>();
		arr.add(1);
		arr.add(4);
		int cur = 3;
		while (true) {
			if (arr.get(arr.size()-1) - arr.get(arr.size()-2) > G) {
				break;
			}
			
			arr.add(cur*cur);
			cur++;
		}
		
		for (int i = 0; i < arr.size()-1; i++) {
			int left = i+1;
			int right = arr.size()-1;
			int target = G + arr.get(i);
			
			while (left <= right) {
				int mid = (left+right) / 2;
				
				if (arr.get(mid) == target) {
					answer.add(mid+1);
					break;
				} else if (arr.get(mid) < target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		
		if (answer.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(answer);
			
			for (int i : answer) {
				System.out.println(i);
			}
		}

	}

}
