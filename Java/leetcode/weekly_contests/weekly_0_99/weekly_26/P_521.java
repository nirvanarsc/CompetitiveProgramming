package leetcode.weekly_contests.weekly_0_99.weekly_26;

public class P_521 {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) { 
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
