package leetcode.weekly_contests.weekly_0_99.weekly_20;

public class P_520 {

    public boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) ||
               word.equals(word.toLowerCase()) ||
               (Character.isUpperCase(word.charAt(0))
                && word.substring(1).equals(word.substring(1).toLowerCase()));
    }
}
