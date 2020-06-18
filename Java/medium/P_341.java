package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class P_341 {

    private interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    public static class NestedIterator implements Iterator<Integer> {
        Deque<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new ArrayDeque<>();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.addFirst(nestedList.get(i));
            }
            preProcess();
        }

        @Override
        public Integer next() {
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }
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
