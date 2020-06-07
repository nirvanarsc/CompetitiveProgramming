package medium;

public class P_255 {

    int idx;
    int[] preorder;

    public boolean helper(int lower, int upper) {
        if (idx == preorder.length) {
            return true;
        }
        final int val = preorder[idx];
        if (val < lower || val > upper) {
            return false;
        }
        idx++;
        return helper(lower, val) || helper(val, upper);
    }

    public boolean verifyPreorder(int[] preorder) {
        this.preorder = preorder;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
