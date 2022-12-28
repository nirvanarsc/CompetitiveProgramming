package leetcode.weekly_contests.weekly_300_399.weekly_323;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_3 {

    class Allocator {
        int[] arr;
        int n;

        public Allocator(int n) {
            arr = new int[n];
            this.n = n;
        }

        public int allocate(int size, int mID) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    int j = i;
                    while (j < n && arr[j] == arr[i]) {
                        j++;
                    }
                    final int l = j - i;
                    if (l >= size) {
                        for (int k = i; k < i + size; k++) {
                            arr[k] = mID;
                        }
                        return i;
                    }
                    i = j - 1;
                }
            }
            return -1;
        }

        public int free(int mID) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == mID) {
                    res++;
                    arr[i] = 0;
                }
            }
            return res;
        }
    }
}
