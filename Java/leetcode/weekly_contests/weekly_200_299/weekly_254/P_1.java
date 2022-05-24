package leetcode.weekly_contests.weekly_200_299.weekly_254;

public class P_1 {

    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String p : patterns) {
            if (word.contains(p)) {
                res++;
            }
        }
        return res;
    }
}
