package weekly_contests.weekly_113;

public class P_949 {

    public String largestTimeFromDigitsIterative(int[] ints) {
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

    public String largestTimeFromDigits(int[] ints) {
        final String[] res = { "" };
        final char[] chars = new char[4];
        for (int i = 0; i < ints.length; i++) {
            chars[i] = (char) ('0' + ints[i]);
        }
        dfs(0, res, chars);
        return res[0].isEmpty() ? res[0] : res[0].substring(0, 2) + ':' + res[0].substring(2);
    }

    private static void dfs(int idx, String[] res, char[] curr) {
        if (idx == curr.length) {
            final String word = new String(curr);
            if (isValidAndGreater(word, res[0])) {
                res[0] = word;
            }
        }
        for (int i = idx; i < curr.length; i++) {
            swap(curr, i, idx);
            dfs(idx + 1, res, curr);
            swap(curr, i, idx);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        final char t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

    private static boolean isValidAndGreater(String left, String right) {
        if ("24".compareTo(left.substring(0, 2)) > 0 && "60".compareTo(left.substring(2)) > 0) {
            return right.isEmpty() || left.compareTo(right) > 0;
        }
        return false;
    }
}
