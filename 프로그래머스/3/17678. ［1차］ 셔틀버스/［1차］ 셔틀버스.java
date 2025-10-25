import java.util.*;

/*
셔틀이 09:00 부터 최대 몇 시까지 올 수 있는가?
1. 각 시간대별로 타는 사람을 미리 매칭시켜두자
2. 맨 뒤에 시간부터 탈 수 있는가? 확인
2-1. 만약, 못탄다면 그 배열의 최대값보다 -1 작은 값 
2-2. 탈 수 있다면, 그 때 탈 수 있는 셔틀시간을 return

시간을 더하는 함수, 시간을 빼는 함수
timeTable 정렬,,

*/
class Solution {
    int initTime = 540;
    
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>(); 
        
        // 순서가 있는 HashMap이 필요하겠는데?
        
        int tmp = initTime;
        
        for (int i = 0; i < n; i++) {
            hm.put(tmp, new ArrayList<>());
            tmp += t;
        }
        
        int curTime = initTime;
        
        for (String time : timetable) {
            String[] h = time.split(":");
            int a = Integer.parseInt(h[0]) * 60 + Integer.parseInt(h[1]);
            
            for (int i = curTime; i < initTime  + (n*t); i += t) {
                ArrayList<Integer> l1 = hm.get(i);
                
                if (a <= i && l1.size() < m) {
                    l1.add(a);
                    curTime = i;
                    break;
                }
            }
        }
        
        ArrayList<Integer> l1 = hm.get(initTime + ((n-1)*t));
        if (l1.size() < m) {
            int answer = initTime + ((n-1)*t);
            
            int answerH = answer / 60;
            String hh = String.valueOf(answerH);
            
            if (answerH < 10) {
                hh = "0" + hh;
            }
            
            int answerM = answer % 60;
            String mm = String.valueOf(answerM);
            
            if (answerM < 10) {
                mm = "0" + mm;
            }
            return hh+":"+mm;
        }
        
        int answer = l1.get(m-1)-1;

        int answerH = answer / 60;
        String hh = String.valueOf(answerH);

        if (answerH < 10) {
            hh = "0" + hh;
        }

        int answerM = answer % 60;
        String mm = String.valueOf(answerM);

        if (answerM < 10) {
            mm = "0" + mm;
        }
        return hh+":"+mm;
    }
}