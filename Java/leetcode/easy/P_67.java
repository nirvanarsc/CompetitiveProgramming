package leetcode.easy;

public class P_67 {

    public String addBinary(String a, String b) {
        final StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int curr = carry;
            if (i >= 0) { curr += a.charAt(i--) - '0'; }
            if (j >= 0) { curr += b.charAt(j--) - '0'; }
            sb.append(curr % 2);
            carry = curr / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
