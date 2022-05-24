package leetcode.weekly_contests.weekly_200_299.weekly_282;

public class P_1 {

    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String w : words) {
            if (w.startsWith(pref)) {
                res++;
            }
        }
        return res;
    }
}
