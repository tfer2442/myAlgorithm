import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 모든 줄어드는 수 생성
        List<Long> decreasingNumbers = new ArrayList<>();
        
        // 한 자리 숫자는 모두 줄어드는 수 (0-9)
        for(int i = 0; i <= 9; i++) {
            decreasingNumbers.add((long)i);
        }
        
        // 여러 자리 숫자에 대해 줄어드는 수 생성
        for(int i = 0; i <= 9; i++) {
            generateDecreasingNumbers(decreasingNumbers, i, i);
        }
        
        // 정렬
        Collections.sort(decreasingNumbers);
        
        // N번째 줄어드는 수 출력
        if(N <= decreasingNumbers.size()) {
            System.out.println(decreasingNumbers.get(N - 1));
        } else {
            System.out.println(-1);
        }
    }
    
    public static void generateDecreasingNumbers(List<Long> numbers, long current, int lastDigit) {
        // 현재 숫자를 리스트에 추가
        if(!numbers.contains(current)) {
            numbers.add(current);
        }
        
        // 이미 10자리를 넘으면 중단 (9876543210이 최대)
        if(current > 9876543210L / 10) {
            return;
        }
        
        // 마지막 자리수보다 작은 숫자들을 다음 자리에 추가
        for(int i = 0; i < lastDigit; i++) {
            generateDecreasingNumbers(numbers, current * 10 + i, i);
        }
    }
}