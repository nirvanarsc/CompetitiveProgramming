package leetcode.weekly_contests.weekly_200_299.weekly_263;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_2 {

    class Bank {

        long[] arr;
        int n;

        public Bank(long[] balance) {
            arr = balance;
            n = balance.length;
        }

        public boolean transfer(int account1, int account2, long money) {
            account1--;
            account2--;
            if (!isValid(account1) || !isValid(account2)) {
                return false;
            }
            if (arr[account1] < money) {
                return false;
            }
            arr[account1] -= money;
            arr[account2] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            account--;
            if (!isValid(account)) {
                return false;
            }
            arr[account] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            account--;
            if (!isValid(account) || arr[account] < money) {
                return false;
            }
            arr[account] -= money;
            return true;
        }

        private boolean isValid(int id) {
            return 0 <= id && id <= n - 1;
        }
    }
}
