package leetcode.weekly_contests.weekly_294;

public class P_1 {

    public int percentageLetter(String s, char letter) {
        int curr = 0;
        for (char c : s.toCharArray()) {
            curr += c == letter ? 1 : 0;
        }
        return (curr * 100) / s.length();
    }

    public static void main(String[] args) {

    }
}
