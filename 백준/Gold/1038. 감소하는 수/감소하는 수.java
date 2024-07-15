import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int n;
	static ArrayList<Long> arr = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (long i = 0; i <= 9; i++) {
			arr.add(i);
		}
		
		for (int i = 2; i <= 10; i++) {
			int len = arr.size();
			
			for (int j = 1; j <= 9; j++) {
				for (int k = 0; k < len; k++) {
					String a = Long.toString(arr.get(k));
					
					if (a.length() == i) {
						break;
					}
					
					if (a.length() != i-1) {
						continue;
					}
					
					String b = Integer.toString(j);
					
					long aFirstNum = Long.parseLong(a.substring(0, 1));
					long bFirstNum = Long.parseLong(b.substring(0, 1));
					
					
					if (aFirstNum >= bFirstNum) {
						break;
					}
					arr.add(Long.parseLong(b.concat(a)));
					
				}
			}

		}
		
		if (arr.size() <= n) {
			System.out.println(-1);
		} else {
			System.out.println(arr.get(n));
		}
	}

}