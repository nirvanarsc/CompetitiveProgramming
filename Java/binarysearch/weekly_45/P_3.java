package binarysearch.weekly_45;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_3 {

    class PlaylistQueue {
        private final class BIT {
            private final int n;
            private final int[] data;

            private BIT(int n) {
                this.n = n;
                data = new int[n + 1];
            }

            public void add(int idx, long val) {
                for (int i = idx + 1; i <= n; i += lsb(i)) {
                    data[i] += val;
                }
            }

            public long sum(int l, int r) {
                return sum(r) - sum(l - 1);
            }

            private long sum(int idx) {
                long res = 0;
                for (int i = idx + 1; i > 0; i -= lsb(i)) {
                    res += data[i];
                }
                return res;
            }

            private int lsb(int i) {
                return i & -i;  // zeroes all the bits except the least significant one
            }

            public int query(int k) {
                int lo = 0;
                int hi = n;
                while (lo < hi) {
                    final int mid = lo + hi >>> 1;
                    if (k > sum(mid)) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                return lo;
            }
        }

        int n;
        BIT bit;
        String[] arr;
        int last;

        PlaylistQueue(String[] songs) {
            n = songs.length + (int) 1e5;
            bit = new BIT(n);
            arr = new String[n];
            for (int i = 0; i < songs.length; i++) {
                arr[i] = songs[i];
                bit.add(i, 1);
            }
            last = songs.length;
        }

        public String play(int i) {
            final int idx = bit.query(i + 1);
            final String res = arr[idx];
            bit.add(idx, -1);
            bit.add(last, 1);
            arr[last++] = res;
            return res;
        }
    }
}
