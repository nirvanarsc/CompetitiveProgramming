package easy;

public class P_167 {

    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        final int[] res = new int[2];
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return res;
    }
}
