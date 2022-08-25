package leetcode.easy;

public class P_383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        final int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (map[c - 'a']-- == 0) {
                return false;
            }
        }
        return true;
    }
}
