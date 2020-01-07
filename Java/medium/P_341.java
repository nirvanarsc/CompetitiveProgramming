package medium;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class P_341 {

    public interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    public static class NestedIterator implements Iterator<Integer> {
        Deque<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new LinkedList<>();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.addFirst(nestedList.get(i));
            }
            preProcess();
        }

        @Override
        public Integer next() {
            final Integer res = stack.removeFirst().getInteger();
            preProcess();
            return res;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void preProcess() {
            while (!stack.isEmpty() && !stack.peekFirst().isInteger()) {
                final List<NestedInteger> list = stack.removeFirst().getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.addFirst(list.get(i));
                }
            }
        }
    }
}
