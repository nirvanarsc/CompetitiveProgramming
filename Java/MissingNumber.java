import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xor = 0, i;
        for (i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }

        return xor ^ i;
    }

    public int missingNumber2(int[] nums) {
        final int sum1 = Arrays.stream(nums).boxed().mapToInt(x -> x).sum();
        final int sum2 = IntStream.range(0, nums.length + 1).sum();

        return sum2 - sum1;
    }
}
