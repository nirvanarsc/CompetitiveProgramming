package binarysearch.weekly_38;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass" })
public class P_4 {

    class VirtualArray {
        private final class BIT {
            private final long n;
            private final Map<Long, Integer> data;

            private BIT() {
                n = 1L << 31;
                data = new HashMap<>();
            }

            public void add(int idx, int val) {
                for (long i = idx + 1; i <= n; i += lsb(i)) {
                    data.merge(i, val, Integer::sum);
                }
            }

            public long sum(int l, int r) {
                return sum(r) - sum(l - 1);
            }

            private long sum(int idx) {
                long res = 0;
                for (long i = idx + 1; i > 0; i -= lsb(i)) {
                    res += data.getOrDefault(i, 0);
                }
                return res;
            }

            private long lsb(long i) {
                return i & -i;  // zeroes all the bits except the least significant one
            }
        }

        BIT bit;

        public VirtualArray() {
            bit = new BIT();
        }

        public void set(int start, int end) {
            bit.add(start, 1);
            bit.add(end + 1, -1);
        }

        public boolean get(int idx) {
            return bit.sum(idx) > 0;
        }
    }
}
