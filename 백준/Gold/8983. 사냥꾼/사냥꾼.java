import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static int M, N, L;
	public static int[] positions;
	public static ArrayList<Data> animals;
	
	public static class Data{
		int x;
		int y;
		
		Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		L = Integer.parseInt(tmp[2]);
		
		positions = new int[N];
		tmp = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			positions[i] = Integer.parseInt(tmp[i]);
		}
		Arrays.sort(positions);
		
		animals = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			tmp = br.readLine().split(" ");
			animals.add(new Data(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
		}

		long answer = 0;
		for (int i = 0; i < M; i++) {
			if (animals.get(i).y > L) {
				continue;
			}
			
			int left = 0;
			int right = N-1;
			int leftRange = animals.get(i).x-(L-animals.get(i).y);
			int rightRange = animals.get(i).x+(L-animals.get(i).y);
			
			while (left <= right) {
				int mid = (left+right)/2;

				if (leftRange <= positions[mid] && positions[mid] <= rightRange) {
					answer += 1;
					break;
				} else if (positions[mid] < leftRange) {
					left = mid + 1;
				} else if (rightRange < positions[mid]) {
					right = mid - 1;
				}
			}
		}
		System.out.println(answer);
	}
}
