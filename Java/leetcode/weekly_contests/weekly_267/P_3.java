package leetcode.weekly_contests.weekly_267;

public class P_3 {

    public String decodeCiphertext(String encodedText, int rows) {
        //noinspection UnnecessaryLocalVariable
        final int n = rows;
        final int m = encodedText.length() / n;
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int r = 0, c = i; r < n && c < m; r++, c++) {
                sb.append(encodedText.charAt(r * m + c));
            }
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
