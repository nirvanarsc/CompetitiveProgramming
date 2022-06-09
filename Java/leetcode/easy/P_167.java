package leetcode.easy;

public class P_167 {

    public int[] twoSum(int[] numbers, int target) {
        final int[] res = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
