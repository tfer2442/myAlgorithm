import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
	public static int n;
	public static String str1;
	public static char[] arr;
	public static int[] visited;
	public static boolean flag;
	
	public static boolean checkOk(int[] nums) {
		if (nums[0] == nums[1] && nums[1] == nums[2]) {
			return true;
		} 
		
		if (nums[0] == nums[1]-1 && nums[1] == nums[2]-1) {
			return true;
		}
		return false;
	}
	
	public static void perm(int cnt) {
		if (flag) {
			return;
		}
		
		if (cnt == 6) {
			int[] nums1 = new int[] {arr[0]-'0', arr[1]-'0', arr[2]-'0'};
			int[] nums2 = new int[] {arr[3]-'0', arr[4]-'0', arr[5]-'0'};
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			
			if (checkOk(nums1) && checkOk(nums2)) {
				flag = true;
			}
		}
		
		for (int i = 0; i < 6; i++) {
			if (visited[i] == 1) continue;
			arr[cnt] = str1.charAt(i);
			visited[i] = 1;
			perm(cnt+1);
			visited[i] = 0;
		}
		
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= n; T++) {
			str1 = br.readLine();
			arr = new char[6];
			visited = new int[6];
			flag = false;
			perm(0);
			System.out.println("#" + T + " " + flag);
			
		}
	}

}
