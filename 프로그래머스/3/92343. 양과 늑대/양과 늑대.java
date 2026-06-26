import java.util.*;

class Solution {
    int N;
    Node[] graph;
    int answer = 0;
    
    static class Node {
        int idx;
        int value;
        Node left;
        Node right;
        
        Node(int idx, int value, Node left, Node right) {
            this.idx = idx;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    
    public void dfs(int cur, int sheep, int wolf, ArrayList<Integer> next) {
        answer = Math.max(answer, sheep);
        
        if (sheep <= wolf) {
            return;
        }
        
        next.remove(Integer.valueOf(cur));
        
        if (graph[cur].left != null) {
            next.add(graph[cur].left.idx);
        }
        
        if (graph[cur].right != null) {
            next.add(graph[cur].right.idx);
        }
        
        
        for (int i = 0; i < next.size(); i++) {
            int nextIdx = next.get(i);
            ArrayList<Integer> tmp = new ArrayList<>(next);
            
            if (graph[nextIdx].value == 0) {
                dfs(nextIdx, sheep+1, wolf, tmp);
            } else {
                dfs(nextIdx, sheep, wolf+1, tmp);
            }
            
        }        
    }
    
    public int solution(int[] info, int[][] edges) {
        N = info.length;
        
        graph = new Node[N];
        
        for (int i = 0; i < N; i++) {
            graph[i] = new Node(i, info[i], null, null);
        }
        
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            
            if (graph[parent].left == null) {                
                graph[parent].left = graph[child];
            } else if (graph[parent].right == null) {
                graph[parent].right = graph[child];
            }
        }
        
        ArrayList<Integer> next = new ArrayList<>();
        next.add(0);
        
        dfs(0, 1, 0, next);
        
        return answer;
    }
}