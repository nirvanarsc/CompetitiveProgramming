package leetcode.weekly_contests.weekly_216;

public class P_1 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        final StringBuilder str1 = new StringBuilder();
        final StringBuilder str2 = new StringBuilder();
        for (String w1 : word1) {
            str1.append(w1);
        }
        for (String w2 : word2) {
            str2.append(w2);
        }
        return str1.toString().equals(str2.toString());
    }
}
