import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int i = 1; i <= T; i++) {
			String str1 = scanner.next();
			String result = new String();
			for (int j = 0; j < str1.length(); j++) {
				if (str1.charAt(j) == '1') {
					result = str1.substring(j);
					break;
				}
			}
			
			if (result.isEmpty()) {
				System.out.println("#"+ i + " " + 0);
				continue;
			}
			
			result = "a" + result;
			int cnt = 0;
			
			for (int j = 1; j < result.length(); j++) {
				if (result.charAt(j) != result.charAt(j-1)) {
					cnt++;
				}
			}
			
			System.out.println("#" + i + " " + cnt);
			
		}
    }
}