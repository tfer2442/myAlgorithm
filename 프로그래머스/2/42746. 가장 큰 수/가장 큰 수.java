import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        ArrayList<Integer> nums = new ArrayList<>();
        
        for (int i = 0; i < numbers.length; i++) {
            nums.add(numbers[i]);
        }
        
        nums.sort((o1, o2)->{
            int a = Integer.parseInt(o1 + "" + o2);
            int b = Integer.parseInt(o2 + "" + o1);
            
            return Integer.compare(b, a); 
        });
        
        if (nums.get(0) == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numbers.length; i++) {
            sb.append(nums.get(i));
        }
        
        return sb.toString();
    }
}