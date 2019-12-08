package weekly_166;

public final class SubtractProductAndSumOfDigits {

    public static int subtractProductAndSum(int n) {
        int prod = 1, sum = 0;
        while (n != 0) {
            final int curr = n % 10;
            prod *= curr;
            sum += curr;
            n /= 10;
        }

        return prod - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(9));
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));
    }

    private SubtractProductAndSumOfDigits() {}
}
