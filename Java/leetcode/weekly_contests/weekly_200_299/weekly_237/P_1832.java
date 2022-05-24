package leetcode.weekly_contests.weekly_200_299.weekly_237;

public class P_1832 {

    public boolean checkIfPangram(String sentence) {
        final int[] f = new int[26];
        for (char c : sentence.toCharArray()) {
            f[c - 'a']++;
        }
        for (int count : f) {
            if (count == 0) {
                return false;
            }
        }
        return true;
    }
}
