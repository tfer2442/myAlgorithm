import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static int R, C; 
    public static char[][] maze; 
    public static int[][] fireTime; 
    public static int[][] jihunTime; 
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1}; 
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        maze = new char[R][C];
        fireTime = new int[R][C];
        jihunTime = new int[R][C];
        
        ArrayDeque<int[]> fireDeque = new ArrayDeque<>();
        ArrayDeque<int[]> jihunDeque = new ArrayDeque<>();
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                fireTime[i][j] = -1;
                jihunTime[i][j] = -1;
            }
        }
        
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = line.charAt(j);
                
                if (maze[i][j] == 'J') {
                    jihunDeque.offer(new int[] {i, j});
                    jihunTime[i][j] = 0;
                    
                    if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
                        System.out.println(1);
                        return;
                    }
                } else if (maze[i][j] == 'F') {
                    fireDeque.offer(new int[] {i, j});
                    fireTime[i][j] = 0;
                }
            }
        }
        
        while (!fireDeque.isEmpty()) {
            int[] current = fireDeque.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                
                if (fireTime[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
                
                fireTime[nx][ny] = fireTime[x][y] + 1;
                fireDeque.offer(new int[] {nx, ny});
            }
        }
        
        while (!jihunDeque.isEmpty()) {
            int[] current = jihunDeque.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                
                if (jihunTime[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
                
                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= jihunTime[x][y] + 1) continue;
                
                jihunTime[nx][ny] = jihunTime[x][y] + 1;
                
                if (nx == 0 || nx == R - 1 || ny == 0 || ny == C - 1) {
                    System.out.println(jihunTime[nx][ny] + 1);
                    return;
                }
                
                jihunDeque.offer(new int[] {nx, ny});
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}