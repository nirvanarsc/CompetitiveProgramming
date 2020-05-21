package weekly_contests.weekly_3;

public class P_392 {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && t.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }

    public boolean isSubsequenceIndexOf(String s, String t) {
        int stay = 0, move = 0;
        while (stay < s.length()) {
            final int index = t.indexOf(s.charAt(stay), move);
            if (index == -1) {
                return false;
            }
            stay++;
            move = index + 1;
        }

        return true;
    }
}
