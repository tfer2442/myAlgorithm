import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int len = 3;
		int prev = 0;
		int k = 0;
		
		while (len < N) {
			k++;
			prev = len;
			len = 2*prev + (3+k);
		}
		
		while (true) {
			if (prev + 1 == N) {
				System.out.println("m");
				break;
			} else if (prev+2 <= N && N <= prev+(k+3)) {
				System.out.println("o");
				break;
			} else {
				N = N-(prev+k+3);
				len = 3;
				prev = 0;
				k = 0;
				
				while (len < N) {
					k++;
					prev = len;
					len = 2*prev + (3+k);
				}
			}
		}
	}

}
