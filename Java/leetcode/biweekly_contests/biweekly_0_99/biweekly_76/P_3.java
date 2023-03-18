package leetcode.biweekly_contests.biweekly_0_99.biweekly_76;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_3 {

    class ATM {

        int[] vals = { 20, 50, 100, 200, 500 };
        long[] curr = { 0, 0, 0, 0, 0 };

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; i++) {
                curr[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            final int[] res = new int[5];
            for (int i = 4; i >= 0; i--) {
                final int c = (int) Math.min(curr[i], amount / vals[i]);
                res[i] = c;
                amount -= vals[i] * c;
            }
            if (amount > 0) {
                return new int[] { -1 };
            }
            for (int i = 0; i < 5; i++) {
                curr[i] -= res[i];
            }
            return res;
        }
    }
}
