package biweekly_8;

public class P_1180 {

    public int countLetters(String str) {
        int res = 0, i = 0;
        char prev = str.charAt(0);
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) != prev) {
                prev = str.charAt(j);
                while (str.charAt(i) != prev) {
                    i++;
                }
            }
            res += j - i + 1;
        }
        return res;
    }
}
