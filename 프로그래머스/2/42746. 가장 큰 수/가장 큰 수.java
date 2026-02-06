import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        Integer[] nums = new Integer[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        
        Arrays.sort(nums, (o1, o2)->{
            String a = String.valueOf(o1);
            String b = String.valueOf(o2);
            
            return Integer.parseInt(b+a) - Integer.parseInt(a+b);
        });
        
        if (nums[0] == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        
        return sb.toString();
    }
}