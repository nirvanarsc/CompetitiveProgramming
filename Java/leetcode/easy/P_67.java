package leetcode.easy;

public class P_67 {

    public String addBinary(String a, String b) {
        final StringBuilder sb = new StringBuilder();
        final char[] l = a.toCharArray();
        final char[] r = b.toCharArray();
        int i = l.length - 1;
        int j = r.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int curr = carry;
            if (i >= 0) { curr += l[i--] - '0'; }
            if (j >= 0) { curr += r[j--] - '0'; }
            sb.append(curr % 2);
            carry = curr / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
