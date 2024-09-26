import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static HashMap<String, ArrayList<String>> graph;
	public static HashMap<String, Integer> inDegrees;
	public static HashMap<String, Integer> outDegrees;
	public static HashMap<String, ArrayList<String>> results;
	public static ArrayDeque<String> dq = new ArrayDeque<>();
	public static ArrayList<String> names = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		graph = new HashMap<>();
		inDegrees = new HashMap<>();
		outDegrees = new HashMap<>();
		results = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		for (int i = 0; i < N; i++) {
			String tmp = st.nextToken();
			
			graph.put(tmp, new ArrayList<>());
			inDegrees.put(tmp, 0);
			results.put(tmp, new ArrayList<>());
			outDegrees.put(tmp, 0);
			names.add(tmp);
		}
		
		M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			inDegrees.put(b, inDegrees.get(b)+1);
			outDegrees.put(a, outDegrees.get(a)+1);
			graph.get(a).add(b);
		}
		
		for (String key : inDegrees.keySet()) {
			if (inDegrees.get(key) == 0) {
				dq.add(key);
			}
		}
		
		while (!dq.isEmpty()) {
			String cur = dq.poll();
			
			for (String next : graph.get(cur)) {
				if (outDegrees.get(cur)-1 == outDegrees.get(next)) { 
					results.get(next).add(cur);
				}
				inDegrees.put(next, inDegrees.get(next)-1);
				if (inDegrees.get(next) == 0) {
					dq.add(next);
				}
			}
		}
		
		int cnt = 0;
		ArrayList<String> arr = new ArrayList<>();
		
		for (String key : outDegrees.keySet()) {
			if (outDegrees.get(key) == 0) {
				cnt++;
				arr.add(key);
			}
		}
		
		arr.sort((o1, o2) -> {
			return o1.compareTo(o2);
		});
		
		System.out.println(cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
		
		names.sort((o1, o2) -> {
			return o1.compareTo(o2);
		});
		
		for (int i = 0; i < N; i++) {
			String key = names.get(i);
			System.out.print(key + " ");
			System.out.print(results.get(key).size() + " ");
			
			results.get(key).sort((o1, o2) -> {
				return o1.compareTo(o2);
			});
			
			for (int j = 0; j < results.get(key).size(); j++) {
				System.out.print(results.get(key).get(j) + " ");
			}
			System.out.println();
		}
	}

}
