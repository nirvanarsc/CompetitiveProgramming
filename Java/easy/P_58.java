package easy;

public class P_58 {

    public int lengthOfLastWord(String s) {
        int res = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return res;
            }
            res++;
        }

        return res;
    }
}
