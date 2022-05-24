package leetcode.weekly_contests.weekly_200_299.weekly_228;

public class P_1758 {

    public int minOperations(String s) {
        int ll = 0;
        int rr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0 && s.charAt(i) != '0') {
                ll++;
            } else if (i % 2 != 0 && s.charAt(i) != '1') {
                ll++;
            }
            if (i % 2 == 0 && s.charAt(i) != '1') {
                rr++;
            } else if (i % 2 != 0 && s.charAt(i) != '0') {
                rr++;
            }
        }
        return Math.min(ll, rr);
    }
}
