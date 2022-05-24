package leetcode.weekly_contests.weekly_200_299.weekly_258;

public class P_1 {

    public String reversePrefix(String word, char ch) {
        final int idx = word.indexOf(ch) + 1;
        return new StringBuilder(word.substring(0, idx)).reverse() + word.substring(idx);
    }
}
