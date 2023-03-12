package leetcode.weekly_contests.weekly_300_399.weekly_336;

public class P_1 {

    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        final String vowels = "aeiou";
        for (int i = left; i <= right; i++) {
            if (vowels.indexOf(words[i].charAt(0)) != -1 &&
                vowels.indexOf(words[i].charAt(words[i].length() - 1)) != -1) {
                res++;
            }
        }
        return res;
    }
}
