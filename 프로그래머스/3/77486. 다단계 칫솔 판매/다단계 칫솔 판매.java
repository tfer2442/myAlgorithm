import java.util.*;

class Solution {
    HashMap<String, String> hm;
    HashMap<String, Integer> money;

    public void distribute(String name, int value) {
        while (!name.equals("-") && value > 0) {
            int give = value / 10;
            int keep = value - give;

            money.put(name, money.get(name) + keep);

            name = hm.get(name);
            value = give;
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        hm = new HashMap<>();
        money = new HashMap<>();

        hm.put("-", "-");
        money.put("-", 0);

        int N = enroll.length;
        for (int i = 0; i < N; i++) {
            hm.put(enroll[i], referral[i]);
            money.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            int value = amount[i] * 100;
            distribute(seller[i], value);
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = money.get(enroll[i]);
        }
        return answer;
    }
}
