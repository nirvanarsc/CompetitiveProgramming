package easy;

public class P_949 {

    public String largestTimeFromDigits(int[] ints) {
        String ans = "";
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                for (int k = 0; k < 4; ++k) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    final String h = String.valueOf(ints[i]) + ints[j];
                    final String m = String.valueOf(ints[k]) + ints[6 - i - j - k];
                    final String t = h + ':' + m;
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(t) < 0) {
                        ans = t;
                    }
                }
            }
        }
        return ans;
    }
}
