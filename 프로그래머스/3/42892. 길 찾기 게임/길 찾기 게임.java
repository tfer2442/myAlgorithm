import java.util.*;

class Solution {
    ArrayList<Integer> preorderResult, postorderResult;
    
    static class Node {
        int x, y, idx;
        Node left, right;
        
        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    void preorder(Node node) {
        if (node == null) return;
        preorderResult.add(node.idx);
        preorder(node.left);
        preorder(node.right);
    }
    
    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        postorderResult.add(node.idx);
    }
    
    void insert(Node root, Node child) {
        Node cur = root;
        
        while (true) {
            if (cur.x > child.x) {
                if (cur.left == null) {
                    cur.left = child;
                    return;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = child;
                    return;
                }
                cur = cur.right;
            }
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        
        ArrayList<Node> tree = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            Node node = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
            tree.add(node);
        }
        
        tree.sort((o1, o2) -> {
            if (o2.y == o1.y) {
                return o1.x - o2.x;
            }
            
            return o2.y - o1.y; 
        });
        
        Node root = tree.get(0);
        
        for (int i = 1; i < tree.size(); i++) {
            insert(root, tree.get(i));
        }
        
        preorderResult = new ArrayList<>();
        postorderResult = new ArrayList<>();
        
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][tree.size()];
        
        for (int i = 0; i < tree.size(); i++) {
            answer[0][i] = preorderResult.get(i);
            answer[1][i] = postorderResult.get(i);
        }

        return answer;
    }
}