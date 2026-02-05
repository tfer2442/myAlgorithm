import java.util.*;

class Solution {
    ArrayList<Integer> pre;
    ArrayList<Integer> post;
    
    static class Node {
        int value;
        int level;
        int leftBound;
        int rightBound;
        Node left;
        Node right;
    }
    
    void preorder(Node node, int[][] nodeinfo, HashMap<String, Integer> hm) {
        pre.add(hm.get(nodeinfo[node.value][0] + "," + nodeinfo[node.value][1])+1);
        
        if (node.left != null) {
            preorder(node.left, nodeinfo, hm);
        }
        
        if (node.right != null) {
            preorder(node.right, nodeinfo, hm);
        }
    }
    
    void postorder(Node node, int[][] nodeinfo, HashMap<String, Integer> hm) {        
        if (node.left != null) {
            postorder(node.left, nodeinfo, hm);
        }
        
        if (node.right != null) {
            postorder(node.right, nodeinfo, hm);
        }
        
        post.add(hm.get(nodeinfo[node.value][0] + "," + nodeinfo[node.value][1])+1);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int N = nodeinfo.length;
        HashMap<String, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            hm.put(nodeinfo[i][0] + "," + nodeinfo[i][1], i);
        }
        
        Arrays.sort(nodeinfo, (o1, o2)-> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o2[1] - o1[1];
        });
        
        HashMap<Integer, Integer> yLevel = new HashMap<>();
        
        yLevel.put(nodeinfo[0][1], 1);
        int prevY = nodeinfo[0][1];
        int cntLevel = 2;
        
        for (int i = 1; i < N; i++) {
            if (prevY == nodeinfo[i][1]) {
                continue;
            } else {
                prevY = nodeinfo[i][1];
                yLevel.put(prevY, cntLevel++);
            }
        }
        
        Node root = new Node(); // 이렇게 New로 만들어줘야하나?
        root.value = 0; // nodeinfo에서의 idx인거지
        root.level = 1;
        root.leftBound = -1;
        root.rightBound = 100_001;
        
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.add(root);
        
        boolean[] visited = new boolean[N];
        visited[0] = true;
        
        while (!dq.isEmpty()) {
            Node node = dq.poll();
            
            for (int i = node.value; i < N; i++) {
                if (visited[i]) continue;
                if (node.level+1 != yLevel.get(nodeinfo[i][1])) break;
                if (node.leftBound < nodeinfo[i][0] && nodeinfo[node.value][0] > nodeinfo[i][0]) {
                    Node left = new Node();
                    
                    left.value = i; 
                    left.level = node.level+1;
                    left.leftBound = node.leftBound;
                    left.rightBound = nodeinfo[node.value][0];
                    
                    node.left = left;
                    visited[i] = true;
                    
                    dq.add(left);
                } else if (node.rightBound > nodeinfo[i][0] && nodeinfo[node.value][0] < nodeinfo[i][0]) {
                    Node right = new Node();
                    
                    right.value = i;
                    right.level = node.level+1;
                    right.leftBound = nodeinfo[node.value][0];
                    right.rightBound = node.rightBound;
                    
                    node.right = right;
                    visited[i] = true;
                    
                    dq.add(right);
                }
            }
        }
        
        pre = new ArrayList<>();
        post = new ArrayList<>();
        
        preorder(root, nodeinfo, hm);
        postorder(root, nodeinfo, hm);

        int[][] answer = new int[2][N];
                
        for (int i = 0; i < N; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        
        return answer;
    }
}