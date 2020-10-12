package leetcode.easy;

public class P_66 {

    public int[] plusOne(int[] digits) {
        int carry, idx = digits.length - 1;
        do {
            digits[idx] += 1;
            carry = digits[idx] / 10;
            digits[idx--] %= 10;
        } while (idx >= 0 && carry > 0);

        if (digits[0] == 0) {
            final int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
