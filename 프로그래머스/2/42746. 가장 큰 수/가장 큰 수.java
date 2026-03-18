import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            
            return Integer.compare(b, a);
        });
        
        if (Integer.parseInt(arr[0]) == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            if (Integer.parseInt(arr[i]) == 0) {
                sb.append("0");
            } else {
                sb.append(arr[i]);
            }
        }
        
        return sb.toString();
    }
}