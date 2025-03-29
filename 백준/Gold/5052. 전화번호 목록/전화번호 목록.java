import java.util.*;
import java.io.*;

public class Main {
	public static int T;
	public static int N;
	public static boolean answer;
	
	public static class Trie {
		Node root;
		
		public Trie() {
			this.root = new Node();
		}
		
		public void insert(String str) {
			Node node = this.root;
			
			for (int i = 0; i < str.length(); i++) {
				char c= str.charAt(i);
				node.child.putIfAbsent(c, new Node());
				node = node.child.get(c);
			}
			
			if (node.endOfWord) {
				answer = false;
				node.endOfWord = true;
				return;
			}
			
			if (node.child.isEmpty()) {
				node.endOfWord = true;
				return;
			}
			
			for (int i = 0; i <= 9; i++) {
			    if (node.child.containsKey((char)(i + '0'))) {
					answer = false;
					break;
				}
			}
			
			node.endOfWord = true;
		}
	}
	
	public static class Node {
		HashMap<Character, Node> child;
		boolean endOfWord;
		
		public Node() {
			this.child = new HashMap<>();
			this.endOfWord = false;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			String[] arr = new String[N];
			answer = true;
			
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}
			
			Arrays.sort(arr, (o1, o2) -> {
				return -1 * (o1.length() - o2.length());
			});
			
			for (int i = 0; i < N; i++) {
				trie.insert(arr[i]);
			}
			
			if (answer) {
				System.out.println("YES");
				continue;
			} 
			System.out.println("NO");
		}
	}

}
