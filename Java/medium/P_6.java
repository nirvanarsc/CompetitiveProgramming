package medium;

public class P_6 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        final StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }
        boolean down = true;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[j].append(s.charAt(i));
            j += down ? 1 : -1;
            if (j == numRows - 1 || j == 0) {
                down ^= true;
            }
        }
        final StringBuilder res = new StringBuilder();
        for (StringBuilder sb : arr) {
            res.append(sb);
        }
        return res.toString();
    }
}
