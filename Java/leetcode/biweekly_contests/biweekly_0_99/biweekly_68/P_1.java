package leetcode.biweekly_contests.biweekly_0_99.biweekly_68;

public class P_1 {

    public int mostWordsFound(String[] sentences) {
        int res = 0;
        for (String s : sentences) {
            res = Math.max(res, s.split(" ").length);
        }
        return res;
    }
}
