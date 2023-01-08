package leetcode.weekly_contests.weekly_300_399.weekly_325;

public class P_1 {

    public int closetTarget(String[] words, String target, int startIndex) {
        final int n = words.length;
        int res = (int) 1e9;
        for (int j = startIndex - n + 1; j < startIndex + n; j++) {
            if (words[(j + n) % n].equals(target)) {
                res = Math.min(res, Math.abs(j - startIndex));
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
