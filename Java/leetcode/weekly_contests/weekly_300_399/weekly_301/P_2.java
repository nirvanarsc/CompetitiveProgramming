package leetcode.weekly_contests.weekly_300_399.weekly_301;

import java.util.Arrays;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_2 {

    class SmallestInfiniteSet {

        boolean[] set;
        int smallest;

        public SmallestInfiniteSet() {
            set = new boolean[1005];
            Arrays.fill(set, true);
            smallest = 1;
        }

        public int popSmallest() {
            final int res = smallest;
            set[smallest++] = false;
            while (!set[smallest]) {
                smallest++;
            }
            return res;
        }

        public void addBack(int num) {
            set[num] = true;
            if (num < smallest) {
                smallest = num;
            }
        }
    }
}
