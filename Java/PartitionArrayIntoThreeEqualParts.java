public final class PartitionArrayIntoThreeEqualParts {

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[] { 1, -1, 1, -1, 1, -1, 1, -1 }));
    }

    public static boolean canThreePartsEqualSum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        final int target = sum / 3;
        int counter = 0;
        int currSum = 0;
        for (int j : a) {
            if (currSum == target && counter < 2) {
                currSum = 0;
                counter++;
            }
            currSum += j;
        }

        return counter == 2;
    }

    private PartitionArrayIntoThreeEqualParts() {}
}
