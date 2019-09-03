public final class VerifyingAlienDictionary {

    public static void main(String[] args) {
        final String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(new String[] { "word", "world", "row" }, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], order) > 0) {
                return false;
            }
        }

        return true;
    }

    public static int compare(String s1, String s2, String order) {
        final int len1 = s1.length();
        final int len2 = s2.length();
        final int lim = Math.min(len1, len2);
        final char[] v1 = s1.toCharArray();
        final char[] v2 = s2.toCharArray();

        int k = 0;
        while (k < lim) {
            final char c1 = v1[k];
            final char c2 = v2[k];
            if (c1 != c2) {
                return order.indexOf(c1) - order.indexOf(c2);
            }
            k++;
        }
        return len1 - len2;
    }

    private VerifyingAlienDictionary() {}
}
