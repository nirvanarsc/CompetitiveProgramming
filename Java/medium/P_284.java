package medium;

import java.util.Iterator;

public class P_284 {

    public static class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> it;
        Integer next;

        public PeekingIterator(Iterator<Integer> iterator) {
            it = iterator;
            if (it.hasNext()) {
                next = it.next();
            }
        }

        public Integer peek() {
            return next;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @SuppressWarnings("ConstantConditions")
        @Override
        public Integer next() {
            final Integer res = next;
            next = it.hasNext() ? it.next() : null;
            return res;
        }
    }
}
