package leetcode.weekly_contests.weekly_400_499.weekly_430;

public class P_2 {

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        final int n = word.length();
        final int length = n - numFriends + 1;
        String res = "";
        for (int i = 0; i < n; i++) {
            final String temp;
            if (i + length <= n) {
                temp = word.substring(i, i + length);
            } else {
                temp = word.substring(i);
            }
            if (temp.compareTo(res) > 0) {
                res = temp;
            }
        }
        return res;
    }
}
