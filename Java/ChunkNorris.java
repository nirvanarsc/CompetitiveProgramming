import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public final class ChunkNorris {

    // https://www.josephsurin.me/posts/2020-08-24-googlectf-2020-writeups#chunk-norris

    static String hexN = "ab802dca026b18251449baece42ba2162bf1f8f5dda60da5f8baef3e5dd49d155c1701a21c2bd5dfee142"
                         + "fd3a240f429878c8d4402f5c4c7f4bc630c74a4d263db3674669a18c9a7f5018c2f32cb4732acf448c9"
                         + "5de86fcd6f312287cebff378125f12458932722ca2f1a891f319ec672da65ea03d0e74e7b601a044355"
                         + "98e2994423362ec605ef5968456970cb367f6b6e55f9d713d82f89aca0b633e7643ddb0ec263dc29f09"
                         + "46cfc28ccbf8e65c2da1b67b18a3fbc8cee3305a25841dfa31990f9aab219c85a2149e51dff2ab7e098"
                         + "9a50d988ca9ccdce34892eb27686fa985f96061620e6902e42bdd00d2768b14a9eb39b3feee51e80273"
                         + "d3d4255f6b19";
    static String hexE = "10001";
    static String hexC = "6a12d56e26e460f456102c83c68b5cf355b2e57d5b176b32658d07619ce8e542d927bbea12fb8f90d7a19"
                         + "22fe68077af0f3794bfd26e7d560031c7c9238198685ad9ef1ac1966da39936b33c7bb00bdb13bec27b"
                         + "23f87028e99fdea0fbee4df721fd487d491e9d3087e986a79106f9d6f5431522270200c5d545d19df44"
                         + "6dee6baa3051be6332ad7e4e6f44260b1594ec8a588c0450bcc8f23abb0121bcabf7551fd0ec11cd61c"
                         + "55ea89ae5d9bcc91f46b39d84f808562a42bb87a8854373b234e71fe6688021672c271c22aad0887304"
                         + "f7dd2b5f77136271a571591c48f438e6f1c08ed65d0088da562e0d8ae2dadd1234e72a40141429f5746"
                         + "d2d41452d916";
    static BigInteger a = new BigInteger("e64a5f84e2762be5", 16);
    static final BigInteger shift64 = BigInteger.ONE.shiftLeft(64);
    static final BigInteger shift128 = BigInteger.ONE.shiftLeft(128);

    public static void main(String[] args) {
        final BigInteger a_inverse = modInverse(bezout(a, shift64)[0], shift64);

        assert a_inverse.multiply(a).mod(shift64).equals(BigInteger.ONE);

        final BigInteger r = BigInteger.ONE.shiftLeft(65).multiply(a_inverse).add(BigInteger.ONE);
        final BigInteger r_inverse = modInverse(bezout(r, shift128)[0], shift128);

        assert r_inverse.multiply(r).mod(shift128).equals(BigInteger.ONE);

        final BigInteger n = new BigInteger(hexN, 16);
        final BigInteger s1s2 = n.multiply(r_inverse).mod(shift128);

        //11 × 13 × 109 × 223 × 1290533 × 4608287 × 167541865434116759
        final List<BigInteger> factors = getPrimeFactors(s1s2);
        System.out.println(factors);
        BigInteger p = BigInteger.ZERO;
        BigInteger q = BigInteger.ZERO;
        for (int i = 0; i < 1 << factors.size(); i++) {
            BigInteger s1 = BigInteger.ONE;
            for (int bit = 0; bit < Integer.SIZE; bit++) {
                if ((i & (1 << bit)) != 0) {
                    s1 = s1.multiply(factors.get(bit));
                }
            }
            final BigInteger s2 = s1s2.divide(s1);
            if (s1.bitLength() == s2.bitLength()) {
                final BigInteger t1 = reverseGetPrime(s1, a_inverse);
                final BigInteger t2 = reverseGetPrime(s2, a_inverse);
                if (t1.multiply(t2).equals(n)) {
                    p = t1;
                    q = t2;
                    break;
                }
            }
        }
        final BigInteger c = new BigInteger(hexC, 16);
        final BigInteger e = new BigInteger(hexE, 16);
        final BigInteger carmichael = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        final BigInteger d = modInverse(bezout(e, carmichael)[0], carmichael);
        final BigInteger message = modPow(c, d, n);
        System.out.println(decode(message));
    }

    private static String decode(BigInteger n) {
        final StringBuilder s = new StringBuilder();
        for (byte value : n.toByteArray()) {
            s.append((char) value);
        }
        return s.toString();
    }

    private static BigInteger[] bezout(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            return new BigInteger[] { BigInteger.ONE, BigInteger.ZERO };
        }
        final BigInteger[] res = bezout(b, a.mod(b));
        return new BigInteger[] { res[1], res[0].subtract(a.divide(b).multiply(res[1])) };
    }

    private static BigInteger modInverse(BigInteger res, BigInteger mod) {
        return res.mod(mod).add(mod).mod(mod);
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

    private static BigInteger reverseGetPrime(BigInteger s, BigInteger a_inv) {
        BigInteger res = s;
        for (int i = 1; i < 16; i++) {
            s = a_inv.multiply(s).mod(shift64);
            res = res.add(s.shiftLeft(64 * i));
        }
        return res;
    }

    private static List<BigInteger> getPrimeFactors(BigInteger number) {
        final List<BigInteger> factors = new ArrayList<>();
        final BigInteger root = number.sqrt();
        for (BigInteger p = BigInteger.valueOf(2); p.compareTo(root) <= 0; p = p.add(BigInteger.ONE)) {
            if (number.mod(p).equals(BigInteger.ZERO)) {
                factors.add(p);
                while (number.mod(p).equals(BigInteger.ZERO)) {
                    number = number.divide(p);
                }
                if (number.isProbablePrime(100)) {
                    break;
                }
            }
        }
        if (number.compareTo(BigInteger.ONE) != 0) {
            factors.add(number);
        }
        return factors;
    }
}
