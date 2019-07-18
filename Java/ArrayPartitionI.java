import java.util.Arrays;

public final class ArrayPartitionI {

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[] { 1, 4, 3, 2 }));
        System.out.println(arrayPairSum2(new int[] { 1, 4, 3, 2 }));
    }

    private static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    private static int arrayPairSum2(int[] nums) {
        int n = 10000;
        int sorted[] = new int[2*n + 1];
        for (int num : nums) { sorted[num + n]++; }

        int sum = 0;
        boolean add = true;
        for (int i = 0; i < sorted.length; i++) {
            while (sorted[i] > 0) {
                if (add) {
                    sum += i - n;
                }
                add ^= true;
                sorted[i]--;
            }
        }
        return sum;
    }

    private ArrayPartitionI() {}
}
