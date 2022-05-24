package leetcode.weekly_contests.weekly_200_299.weekly_279;

@SuppressWarnings({ "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass", "unused" })
public class P_3 {

    class Bitset {

        int[] arr;
        boolean flipped;
        int count;
        int n;

        public Bitset(int size) {
            arr = new int[size];
            n = size;
        }

        public void fix(int idx) {
            if (flipped) {
                if (arr[idx] == 1) {
                    arr[idx] = 0;
                    count++;
                }
            } else {
                if (arr[idx] == 0) {
                    arr[idx] = 1;
                    count++;
                }
            }
        }

        public void unfix(int idx) {
            if (flipped) {
                if (arr[idx] == 0) {
                    arr[idx] = 1;
                    count--;
                }
            } else {
                if (arr[idx] == 1) {
                    arr[idx] = 0;
                    count--;
                }
            }
        }

        public void flip() {
            flipped ^= true;
            count = n - count;
        }

        public boolean all() {
            return count == n;
        }

        public boolean one() {
            return count > 0;
        }

        public int count() {
            return count;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (flipped) {
                    sb.append(arr[i] ^ 1);
                } else {
                    sb.append(arr[i]);
                }
            }
            return sb.toString();
        }
    }
}
