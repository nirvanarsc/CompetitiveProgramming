package weekly_contests.weekly_188;

public class P_1442 {

    public int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == 0) {
                    ans += j - i;
                }
            }
        }
        return ans;
    }

    public int countTripletsBF(int[] arr) {
        final int[] map = new int[arr.length];
        map[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            map[i] = map[i - 1] ^ arr[i];
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    final int a = i == 0 ? j == i + 1 ? arr[i] : map[j - 1] : map[j - 1] ^ map[i - 1];
                    final int b = map[k] ^ map[j - 1];
                    if (a == b) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
