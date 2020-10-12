package leetcode.medium;

public class P_43 {

    public String multiply(String num1, String num2) {
        final int m = num1.length();
        final int n = num2.length();
        final int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                final int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                final int p1 = i + j;
                final int p2 = i + j + 1;
                final int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        final StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
