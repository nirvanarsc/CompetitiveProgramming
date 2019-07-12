public final class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

    private static int numJewelsInStones(String J, String S) {
        final char[] jewels = J.toCharArray();
        final char[] stones = S.toCharArray();

        int res = 0;

        for (char c : stones) {
            if(contains(jewels, c)) {
                res++;
            }
        }

        return res;
    }

    private static boolean contains(char[] chars, char curr) {
        for (char c : chars) {
            if(c == curr) {
                return true;
            }
        }
        return false;
    }
}
