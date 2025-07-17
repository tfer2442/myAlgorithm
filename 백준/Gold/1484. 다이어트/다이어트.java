import java.util.*;
import java.io.*;

/*
 * 현재 가능한 몸무게를 오름차순으로 출력하는 문제
 * 가능한 몸무게 없으면 -1, 자연수로 떨어지지 않으면 제외
 * G = (현재몸무게)^2 - (기억하고있던 몸무게)^2
 * G는 자연수, 몸무게도 자연수
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 투 포인터 알고리즘
        // past: 기억하고 있던 몸무게, current: 현재 몸무게
        int past = 1;
        int current = 2;
        
        // current^2 - past^2 <= G를 만족하는 동안 반복
        while (true) {
            long diff = (long)current * current - (long)past * past;
            
            // 차이가 G보다 크고, past를 더 이상 증가시켜도 답이 없을 때 종료
            if (diff > G && past == current - 1) {
                break;
            }
            
            if (diff == G) {
                answer.add(current);
                past++;
                current++;
            } else if (diff > G) {
                past++;
            } else {
                current++;
            }
        }
        
        // 결과 출력
        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (int num : answer) {
                System.out.println(num);
            }
        }
    }
}