package leetcode.weekly_contests.weekly_243;

public class P_1 {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return f(firstWord) + f(secondWord) == f(targetWord);
    }

    private static int f(String w) {
        int res = 0;
        for (char c : w.toCharArray()) {
            res = (res * 10) + (c - 'a');
        }
        return res;
    }
}
