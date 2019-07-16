public class DIStringMatch {

    public static void main(String[] args) {
        for (int i : diStringMatch("IDID")) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static int[] diStringMatch(String S) {
        int l = S.length(), currI = 0, currD = l;
        int[] res = new int[l + 1];
        for (int i = 0; i < l; i++) {
            res[i] = S.charAt(i) == 'I' ? currI++ : currD--;
        }
        res[l] = currI;
        return res;
    }
}
