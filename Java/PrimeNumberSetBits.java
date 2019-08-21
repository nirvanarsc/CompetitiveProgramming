import java.util.HashSet;
import java.util.Set;

public final class PrimeNumberSetBits {

    static final Set<Integer> PRIMES = new HashSet<>();

    static {
        PRIMES.add(2);
        PRIMES.add(3);
        PRIMES.add(5);
        PRIMES.add(7);
        PRIMES.add(11);
        PRIMES.add(13);
        PRIMES.add(17);
        PRIMES.add(19);
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(10, 15));
        System.out.println(countPrimeSetBits(842, 888));
    }

    public static int countPrimeSetBits(int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (PRIMES.contains(Integer.bitCount(i))) { res++; }
        }
        return res;
    }

    private PrimeNumberSetBits() {}
}
