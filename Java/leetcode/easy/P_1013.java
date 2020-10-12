package leetcode.easy;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }
        final int target = sum / 3;
        int counter = 0;
        sum = 0;
        for (int num : A) {
            sum += num;
            if (sum == target) {
                sum = 0;
                counter++;
            }
        }
        return counter >= 3;
    }
}
