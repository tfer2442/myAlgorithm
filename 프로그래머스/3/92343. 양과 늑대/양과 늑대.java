import java.util.*;

class Solution {
    int[] info;
    List<Integer>[] tree;
    int answer = 0;
    
    public void dfs(int wolf, int sheep, List<Integer> nextNodes) {
        for (int i = 0; i < nextNodes.size(); i++) {
            int current = nextNodes.get(i);
            
            int nextSheep = sheep;
            int nextWolf = wolf;
            
            if (info[current] == 0) nextSheep++;
            else nextWolf++;
            
            if (nextWolf >= nextSheep) continue;
            
            answer = Math.max(answer, nextSheep);
            
            List<Integer> newNext = new ArrayList<>(nextNodes);
            
            newNext.remove(i);
            newNext.addAll(tree[current]);
            
            dfs(nextWolf, nextSheep, newNext);
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        
        tree = new ArrayList[info.length];
        
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            
            tree[a].add(b);
        }
        
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        
        dfs(0, 0, nextNodes);
            
        return answer;
    }
}