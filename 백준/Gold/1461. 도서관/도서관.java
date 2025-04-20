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
        
        Integer[] posArr = new Integer[posCount];
        for(int i = 0; i < posCount; i++) {
            posArr[i] = positive[i];
        }
        
        Integer[] negArr = new Integer[negCount];
        for(int i = 0; i < negCount; i++) {
            negArr[i] = negative[i];
        }
        
        Arrays.sort(posArr, (a, b) -> b - a);
        Arrays.sort(negArr, (a, b) -> b - a);
        
        long totalDistance = 0;
        
        for(int i = 0; i < posCount; i += M) {
            totalDistance += posArr[i] * 2;
        }
        
        for(int i = 0; i < negCount; i += M) {
            totalDistance += negArr[i] * 2;
        }
        
        totalDistance -= maxDistance;
        
        System.out.println(totalDistance);
    }
}