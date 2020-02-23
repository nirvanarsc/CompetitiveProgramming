package biweekly_20;

public class P_1358 {

    public int numberOfSubstrings(String s) {
        final int[] count = { 0, 0, 0 };
        int i = 0, res = 0;
        for (int j = 0; j < s.length(); ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                --count[s.charAt(i++) - 'a'];
            }
            res += i;
        }
        return res;
    }

    public int numberOfSubstrings992(String s) {
        final int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - 'a';
        }
        return atMost(arr, 3) - atMost(arr, 2);
    }

    public int atMost(int[] nums, int k) {
        int res = 0, i = 0;
        final int n = nums.length;
        final int[] freq = new int[n + 1];
        for (int j = 0; j < n; j++) {
            k -= freq[nums[j]]++ == 0 ? 1 : 0;
            while (k < 0) {
                k += freq[nums[i++]]-- == 1 ? 1 : 0;
            }
            res += j - i + 1;
        }
        return res;
    }
}
