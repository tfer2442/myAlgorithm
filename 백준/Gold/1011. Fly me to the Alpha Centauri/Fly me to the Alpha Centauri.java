import java.util.*;
import java.io.*;

public class Main {
    public static int T;
    public static int X, Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            
            int distance = Y - X;
            int sqrtDist = (int) Math.sqrt(distance);
            
            if (distance == sqrtDist * sqrtDist) {
                sb.append(2 * sqrtDist - 1 + "\n");
            }
            else if (distance <= sqrtDist * sqrtDist + sqrtDist) {
                sb.append(2 * sqrtDist + "\n");
            }
            else {
                sb.append(2 * sqrtDist + 1 + "\n");
            }
        }
        
        System.out.println(sb);
    }
}