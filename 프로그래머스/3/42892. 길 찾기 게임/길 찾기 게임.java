import java.util.*;

class Solution {
    int[][] nodes;
    int N;
    ArrayList<Integer> preorderList, postorderList;
    
    static class Node {
        Node left, right;
        int v, x, y;
        
        Node(int x, int y, int v) {
            this.v = v;
            this.x = x;
            this.y = y;
        }
    }
    
    void insert(Node cur, Node a) {
        while (true) {
            if (cur.x < a.x) {
                if (cur.right == null) {
                    cur.right = a;
                    return;
                }
                
                cur = cur.right;
            }
            
            if (cur.x > a.x) {
                if (cur.left == null) {
                    cur.left = a;
                    return;
                }
                
                cur = cur.left;
            }
        }
    }
    
    void preorder(Node node) {
        if (node == null) return;
        
        preorderList.add(node.v);
        preorder(node.left);
        preorder(node.right);
    }
    
    void postorder(Node node) {
        if (node == null) return;
        
        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.v);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        N = nodeinfo.length;
        nodes = new int[N][3];
        
        for (int i = 0; i < N; i++) {
            nodes[i] = new int[]{nodeinfo[i][0], nodeinfo[i][1], i+1};
        }
        
        Arrays.sort(nodes, (o1, o2)->{
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            
            return Integer.compare(o2[1], o1[1]);
        });
        
        Node root = new Node(nodes[0][0], nodes[0][1], nodes[0][2]);

        for (int i = 1; i < N; i++) {
            insert(root, new Node(nodes[i][0], nodes[i][1], nodes[i][2]));
        }
        
        preorderList = new ArrayList<>();
        postorderList = new ArrayList<>();
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][N];
        
        for (int i = 0; i < N; i++) {
            answer[0][i] = preorderList.get(i);
        }
        
        for (int i = 0; i < N; i++) {
            answer[1][i] = postorderList.get(i);
        }        
        
        return answer;
    }
}