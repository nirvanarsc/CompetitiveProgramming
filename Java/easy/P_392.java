package easy;

public class P_392 {

    public boolean isSubsequence(String s, String t) {
        int index1 = 0, index2 = 0;

        while (index1 < s.length() && index2 < t.length()) {
            if (s.charAt(index1) == t.charAt(index2)) {
                index1++;
            }
            index2++;
        }
        return index1 == s.length();
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
