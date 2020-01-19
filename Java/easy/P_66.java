package easy;

public class P_66 {

    public int[] plusOne(int[] digits) {
        int idx = digits.length - 1;
        if (digits[idx] + 1 < 10) {
            digits[idx]++;
            return digits;
        }
        while (idx >= 0 && digits[idx] + 1 >= 10) {
            digits[idx] = 0;
            idx--;
        }
        if (digits[0] == 0) {
            final int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            return res;
        }
        digits[idx]++;
        return digits;
    }
}
