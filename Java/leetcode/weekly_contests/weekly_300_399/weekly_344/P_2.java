package leetcode.weekly_contests.weekly_300_399.weekly_344;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_2 {

    class FrequencyTracker {
        int[] f;
        int[] map;

        public FrequencyTracker() {
            f = new int[(int) (1e5 + 5)];
            map = new int[(int) (1e5 + 5)];
        }

        public void add(int number) {
            f[map[number]]--;
            f[++map[number]]++;
        }

        public void deleteOne(int number) {
            if (map[number] == 0) {
                return;
            }
            f[map[number]]--;
            f[--map[number]]++;
        }

        public boolean hasFrequency(int frequency) {
            return f[frequency] > 0;
        }
    }
}
