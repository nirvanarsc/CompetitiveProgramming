package leetcode.medium;

public class P_331 {

    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        for (String s : preorder.split(",")) {
            if (--slots < 0) {
                return false;
            }
            if (!"#".equals(s)) {
                slots += 2;
            }
        }
        return slots == 0;
    }
}
