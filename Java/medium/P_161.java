package medium;

public class P_161 {

    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            return checkReplace(s, t);
        }
        if (s.length() - 1 == t.length()) {
            return checkDelete(t, s);
        }
        if (s.length() + 1 == t.length()) {
            return checkDelete(s, t);
        }
        return false;
    }

    private static boolean checkReplace(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (t.charAt(i) != s.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    private static boolean checkDelete(String s1, String s2) {
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (i != j) {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }
}
