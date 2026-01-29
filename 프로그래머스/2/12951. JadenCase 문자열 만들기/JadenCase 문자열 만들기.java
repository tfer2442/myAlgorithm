import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String[] sArr = s.split(" ", -1); // 빈 문자열도 유지

        for (int i = 0; i < sArr.length; i++) {
            String tmp = sArr[i]; // strip() 제거 (공백 보존 목적)

            if (tmp.length() > 0) {
                sb.append(Character.toUpperCase(tmp.charAt(0)));
                sb.append(tmp.substring(1).toLowerCase()); // 길이 1이면 "" 붙는 거라 OK
            }

            if (i != sArr.length - 1) sb.append(" "); // 토큰 사이 공백 1개 = 원본 공백 개수 보존됨
        }

        
        return sb.toString();
    }
}