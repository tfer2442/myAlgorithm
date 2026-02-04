import java.util.*;

class Solution {

    int upperBound(int left, int right, long target, int mult, int[] weights) {
        int result = left - 1; // 못 찾으면 left-1
        while (left <= right) {
            int mid = (left + right) / 2;
            long value = (long) weights[mid] * mult;

            if (value > target) {
                right = mid - 1;
            } else { // value <= target
                result = mid;
                left = mid + 1;
            }
        }
        return result;
    }

    int lowerBound(int left, int right, long target, int mult, int[] weights) {
        int result = right + 1; // 못 찾으면 right+1
        while (left <= right) {
            int mid = (left + right) / 2;
            long value = (long) weights[mid] * mult;

            if (value >= target) {
                result = mid;
                right = mid - 1;
            } else { // value < target
                left = mid + 1;
            }
        }
        return result;
    }

    public long solution(int[] weights) {
        Arrays.sort(weights);
        long answer = 0;

        // 네가 잡기로 한 비율: 1:1, 2:1, 3:2, 4:3
        int[] num = {1, 2, 3, 4}; // 분자
        int[] den = {1, 1, 2, 3}; // 분모

        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < 4; j++) {
                long target = (long) weights[i] * num[j];
                int mult = den[j];

                int b = lowerBound(i + 1, weights.length - 1, target, mult, weights); // first >=
                int a = upperBound(i + 1, weights.length - 1, target, mult, weights); // last <=

                // 진짜 "같은 값"이 존재할 때만 더하기
                if (b <= a && b <= weights.length - 1 && (long)weights[b] * mult == target) {
                    answer += (a - b + 1); // 개수
                }
            }
        }

        return answer;
    }
}
