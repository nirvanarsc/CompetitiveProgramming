package medium;

import java.util.List;

public class P_364 {

    private interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        void setInteger(int value);

        void add(NestedInteger ni);

        List<NestedInteger> getList();
    }

    int maxDepth;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            getDepth(n, 1);
        }
        int temp = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            temp += dfs(nestedList.get(i), maxDepth);
        }
        return temp;
    }

    private static int dfs(NestedInteger curr, int depth) {
        if (curr.isInteger()) {
            return curr.getInteger() * depth;
        }
        int temp = 0;
        final List<NestedInteger> list = curr.getList();
        for (int i = 0; i < list.size(); i++) {
            temp += dfs(list.get(i), depth - 1);
        }
        return temp;
    }

    private void getDepth(NestedInteger nestedList, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (nestedList.isInteger()) {
            return;
        }
        for (NestedInteger n : nestedList.getList()) {
            getDepth(n, depth + 1);
        }
    }
}
