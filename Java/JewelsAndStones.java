public class JewelsAndStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

    private static int numJewelsInStones(String J, String S) {
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();

        int res = 0;

        for (char c : stones) {
            if(contains(jewels, c)) {
                res++;
            }
        }

        return res;
    }

    private static boolean contains(char[] J, char curr) {
        for (char c: J) {
            if(c == curr) {
                return true;
            }
        }
        return false;
    }
}
