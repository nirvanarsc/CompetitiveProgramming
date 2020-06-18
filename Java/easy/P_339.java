package easy;

import java.util.List;

public class P_339 {

    private interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        void setInteger(int value);

        void add(NestedInteger ni);

        List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        int temp = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            temp += dfs(nestedList.get(i), 1);
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
            temp += dfs(list.get(i), depth + 1);
        }
        return temp;
    }
}
