import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        HashMap<Character, Integer> alphabetCount = new HashMap<>();
        
        int left = 0;
        int answer = 0;
        
        for (int right = 0; right < str.length(); right++) {
            char rightChar = str.charAt(right);
            alphabetCount.put(rightChar, alphabetCount.getOrDefault(rightChar, 0) + 1);
            
            // 알파벳 종류가 N을 초과하면 left를 이동
            while (alphabetCount.size() > N) {
                char leftChar = str.charAt(left);
                alphabetCount.put(leftChar, alphabetCount.get(leftChar) - 1);
                if (alphabetCount.get(leftChar) == 0) {
                    alphabetCount.remove(leftChar);
                }
                left++;
            }
            
            // 현재 윈도우의 길이로 답 갱신
            answer = Math.max(answer, right - left + 1);
        }
        
        System.out.println(answer);
    }
}