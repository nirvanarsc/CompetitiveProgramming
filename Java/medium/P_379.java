package medium;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("unused")
public class P_379 {

    static class PhoneDirectory {
        private int curr;
        private final int n;
        private final Set<Integer> recycle;

        PhoneDirectory(int maxNumbers) {
            curr = 0;
            n = maxNumbers;
            recycle = new HashSet<>();
        }

        public int get() {
            if (!recycle.isEmpty()) {
                final Iterator<Integer> iterator = recycle.iterator();
                final int res = iterator.next();
                iterator.remove();
                return res;
            }
            if (curr < n) {
                return curr++;
            }
            return -1;
        }

        public boolean check(int number) {
            return legal(number) && !assigned(number);
        }

        public void release(int number) {
            if (legal(number) && assigned(number)) {
                recycle.add(number);
            }
        }

        private boolean legal(int number) {
            return number >= 0 && number < n;
        }

        private boolean assigned(int number) {
            return number < curr && !recycle.contains(number);
        }
    }
}
