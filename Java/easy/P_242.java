package easy;

public class P_242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        final int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            chars[c - 'a']--;
            if (chars[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
