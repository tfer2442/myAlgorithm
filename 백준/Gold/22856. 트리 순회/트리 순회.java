import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static ArrayList<int[]>[] graph;
	public static int answer;
	public static int visited;
	public static int last = 1;
	
	public static void inorder1(int node) {
		if (node == -1) return;
		
		inorder1(graph[node].get(0)[0]);
		last = node;
		inorder1(graph[node].get(0)[1]);
	}
	
	public static void inorder(int node) {
		answer++;
		visited++;
		
		if (visited==N && last==node) {
			System.out.println(answer-1);
			System.exit(0);
		}

		if (graph[node].get(0)[0] != -1) {
			inorder(graph[node].get(0)[0]);
			answer++;
			if (visited==N && last==node) {
				System.out.println(answer-1);
				System.exit(0);
			}
		}

		if (graph[node].get(0)[1] != -1) {
			inorder(graph[node].get(0)[1]);
			
			answer++;
		}		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			graph[a].add(new int[] {left, right});
		}
		
		inorder1(1);
		inorder(1);
	}

}
