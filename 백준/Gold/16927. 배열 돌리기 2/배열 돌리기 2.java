import java.util.*;
import java.io.*;

public class Main {
    public static int N, M, R;
    public static int[][] board;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int layers = Math.min(N, M) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int top = layer;
            int left = layer;
            int bottom = N - layer - 1;
            int right = M - layer - 1;
            
            int perimeter = 2 * ((bottom - top) + (right - left));
            int rotations = R % perimeter;
            if(rotations == 0) continue; 
            
            int[] tmp = new int[perimeter];
            int index = 0;

            for (int j = left; j <= right; j++) {
                tmp[index++] = board[top][j];
            }

            for (int i = top + 1; i < bottom; i++) {
                tmp[index++] = board[i][right];
            }

            for (int j = right; j >= left; j--) {
                tmp[index++] = board[bottom][j];
            }

            for (int i = bottom - 1; i > top; i--) {
                tmp[index++] = board[i][left];
            }
            
            int[] rotated = new int[perimeter];
            for (int i = 0; i < perimeter; i++) {
                rotated[i] = tmp[(i + rotations) % perimeter];
            }
            
            index = 0;
            for (int j = left; j <= right; j++) {
                board[top][j] = rotated[index++];
            }

            for (int i = top + 1; i < bottom; i++) {
                board[i][right] = rotated[index++];
            }

            for (int j = right; j >= left; j--) {
                board[bottom][j] = rotated[index++];
            }

            for (int i = bottom - 1; i > top; i--) {
                board[i][left] = rotated[index++];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
