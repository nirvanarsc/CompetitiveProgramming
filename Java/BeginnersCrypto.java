import java.math.BigInteger;

public final class BeginnersCrypto {

    // https://hackmd.io/@hakatashi/HJJoxeAyD
    public static void main(String[] args) {
        final BigInteger c = new BigInteger(
                "1002773875431658367671665822006771085816631054109509173556585546508965236428620487083647585179992085437922318783218149808537210712780660412301729655917441546549321914516504576");

        final BigInteger mod = BigInteger.valueOf(5).pow(175);
        final BigInteger phi = BigInteger.valueOf(5)
                                         .pow(174)
                                         .multiply(BigInteger.valueOf(4))
                                         .subtract(BigInteger.ONE);
        final BigInteger a = BigInteger.valueOf(2).pow(10000);

        final BigInteger inv = modPow(a, phi, mod);

        System.out.println(decode(c.multiply(inv).mod(mod)));
    }

    private static BigInteger modPow(BigInteger a, BigInteger n, BigInteger mod) {
        BigInteger res = BigInteger.ONE;
        while (n.compareTo(BigInteger.ZERO) > 0) {
            if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                res = res.multiply(a).mod(mod);
            }
            a = a.multiply(a).mod(mod);
            n = n.shiftRight(1);
        }
        return res;
    }

    private static String decode(BigInteger n) {
        final StringBuilder s = new StringBuilder();
        for (byte value : n.toByteArray()) {
            s.append((char) value);
        }
        return s.toString();
    }
}
