package leetcode.medium;

public class P_331 {

    public boolean isValidSerializationIter(String preorder) {
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

    static String[] tree;
    static int idx;

    public boolean isValidSerialization(String preorder) {
        tree = preorder.split(",");
        idx = 0;
        return dfs() && idx == tree.length;
    }

    private static boolean dfs() {
        if (idx == tree.length) {
            return false;
        }
        if (!"#".equals(tree[idx++])) {
            return dfs() && dfs();
        }
        return true;
    }
}
