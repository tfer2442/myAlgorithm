import java.util.*;
import java.io.*;

public class Main {
    public static int w, h;
    public static char[][] grid;
    public static List<int[]> dirtyList = new ArrayList<>();
    public static int[] start = new int[2];
    public static int numDirty;
    public static final int INF = Integer.MAX_VALUE;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String[] whInput = br.readLine().split(" ");
            w = Integer.parseInt(whInput[0]);
            h = Integer.parseInt(whInput[1]);
            if(w == 0 && h == 0) break;
            grid = new char[h][w];
            dirtyList.clear();
            for(int i=0;i<h;i++){
                String line = br.readLine();
                for(int j=0; j<w; j++){
                    grid[i][j] = line.charAt(j);
                    if(grid[i][j] == 'o'){
                        start[0] = i;
                        start[1] = j;
                    }
                    else if(grid[i][j] == '*'){
                        dirtyList.add(new int[]{i, j});
                    }
                }
            }
            numDirty = dirtyList.size();
            if(numDirty == 0){
                sb.append("0\n");
                continue;
            }
            int totalPoints = numDirty + 1;
            int[][] distances = new int[totalPoints][totalPoints];
            boolean possible = true;
            for(int i=0;i<totalPoints;i++){
                int x, y;
                if(i == 0){
                    x = start[0];
                    y = start[1];
                }
                else{
                    x = dirtyList.get(i-1)[0];
                    y = dirtyList.get(i-1)[1];
                }
                int[][] dist = bfs(x, y);
                for(int j=0;j<totalPoints;j++){
                    if(j == 0){
                        distances[i][j] = dist[start[0]][start[1]];
                    }
                    else{
                        int tx = dirtyList.get(j-1)[0];
                        int ty = dirtyList.get(j-1)[1];
                        distances[i][j] = dist[tx][ty];
                    }
                }
            }
            for(int i=1;i<totalPoints;i++){
                if(distances[0][i] == -1){
                    possible = false;
                    break;
                }
            }
            if(!possible){
                sb.append("-1\n");
                continue;
            }
            List<Integer> perm = new ArrayList<>();
            for(int i=1;i<totalPoints;i++) perm.add(i);
            List<List<Integer>> allPermutations = new ArrayList<>();
            generatePermutations(perm, 0, allPermutations);
            int min = INF;
            for(List<Integer> order : allPermutations){
                int currentDist = 0;
                boolean valid = true;
                int prev = 0;
                for(int idx : order){
                    if(distances[prev][idx] == -1){
                        valid = false;
                        break;
                    }
                    currentDist += distances[prev][idx];
                    prev = idx;
                }
                if(valid){
                    min = Math.min(min, currentDist);
                }
            }
            sb.append(min == INF ? "-1\n" : min + "\n");
        }
        System.out.print(sb.toString());
    }

    public static int[][] bfs(int startX, int startY){
        int[][] dist = new int[h][w];
        for(int[] row : dist) Arrays.fill(row, -1);
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startX, startY});
        dist[startX][startY] = 0;
        while(!q.isEmpty()){
            int[] current = q.remove();
            int x = current[0];
            int y = current[1];
            for(int dir=0; dir<4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx >=0 && nx < h && ny >=0 && ny < w && grid[nx][ny] != 'x' && dist[nx][ny] == -1){
                    dist[nx][ny] = dist[x][y] +1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return dist;
    }

    public static void generatePermutations(List<Integer> arr, int index, List<List<Integer>> result){
        if(index == arr.size()){
            result.add(new ArrayList<>(arr));
            return;
        }
        for(int i=index; i<arr.size(); i++){
            Collections.swap(arr, i, index);
            generatePermutations(arr, index+1, result);
            Collections.swap(arr, i, index);
        }
    }
}
