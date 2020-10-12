package leetcode.easy;

public class P_168 {

    public String convertToTitle(int n) {
        final StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) ('A' + n % 26));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
