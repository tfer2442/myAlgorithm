import java.util.*;

class Solution {
    int N, M, answer;
    Node[] trees;
    
    static class Node {
        Node left;
        Node right;
        int idx;
        int value;
        
        Node() {
        }
        
        Node(Node left, Node right, int idx, int value) {
            this.left = left;
            this.right = right;
            this.idx = idx;
            this.value = value;
        }
    }
    
    public void dfs(int cur, int wolf, int sheep, ArrayList<Integer> curList) {
        if (wolf >= sheep) {
            return;
        }
        
        answer = Math.max(answer, sheep);
        
        ArrayList<Integer> nextList = new ArrayList<>(curList);
        
        if (trees[cur].left != null) {
            nextList.add(trees[cur].left.idx);
        }
        
        if (trees[cur].right != null) {
            nextList.add(trees[cur].right.idx);
        }
        
        nextList.remove(Integer.valueOf(cur));
        
        for (int i = 0; i < nextList.size(); i++) {
            int idx = nextList.get(i);
            
            if (trees[idx].value == 1) {
                dfs(idx, wolf+1, sheep, nextList);
            } else {
                dfs(idx, wolf, sheep+1, nextList);
            }
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        N = info.length;
        M = edges.length;
        
        trees = new Node[N];
        
        for (int i = 0; i < N; i++) {
            trees[i] = new Node();
            trees[i].value = info[i];
            trees[i].idx = i;
        }
        
        for (int i = 0; i < M; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            
            if (trees[parent].left == null) {
                trees[parent].left = trees[child];
            } else {
                trees[parent].right = trees[child];
            }
        }
        
        ArrayList<Integer> nextList = new ArrayList<>();
        nextList.add(0);
        
        dfs(0, 0, 1, nextList);
        
        return answer;
    }
}