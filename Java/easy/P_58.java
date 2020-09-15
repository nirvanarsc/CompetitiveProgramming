package easy;

public class P_58 {

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i == -1) {
            return 0;
        }
        int j = i - 1;
        while (j >= 0 && s.charAt(j) != ' ') {
            j--;
        }
        return i - j;
    }
}
