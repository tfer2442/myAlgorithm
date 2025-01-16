import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        
        Integer[] positive = new Integer[N]; 
        Integer[] negative = new Integer[N];
        int posCount = 0;
        int negCount = 0;
        
        st = new StringTokenizer(br.readLine());
        int maxDistance = 0;
        
        for(int i = 0; i < N; i++) {
            int location = Integer.parseInt(st.nextToken());
            if(location > 0) {
                positive[posCount++] = location;
            } else {
                negative[negCount++] = -location; 
            }
            if(Math.abs(location) > maxDistance) {
                maxDistance = Math.abs(location);
            }
        }
        
        positive = Arrays.copyOf(positive, posCount);
        negative = Arrays.copyOf(negative, negCount);
        
        Arrays.sort(positive, (a, b) -> b - a);
        Arrays.sort(negative, (a, b) -> b - a);
        
        long totalDistance = 0;
        
        for(int i = 0; i < posCount; i += M) {
            totalDistance += positive[i] * 2;
        }
        
        for(int i = 0; i < negCount; i += M) {
            totalDistance += negative[i] * 2;
        }
        
        totalDistance -= maxDistance;
        
        System.out.println(totalDistance);
    }
}
