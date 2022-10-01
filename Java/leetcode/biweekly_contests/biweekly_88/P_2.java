package leetcode.biweekly_contests.biweekly_88;

import java.util.TreeSet;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_2 {

    class LUPrefix {

        TreeSet<Integer> ts;

        public LUPrefix(int n) {
            ts = new TreeSet<>();
            for (int i = 1; i <= n + 1; i++) {
                ts.add(i);
            }
        }

        public void upload(int video) {
            ts.remove(video);
        }

        public int longest() {
            return ts.first() - 1;
        }
    }
}
