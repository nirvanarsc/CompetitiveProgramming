package weekly_contests.weekly_63;

public class P_748 {

    @SuppressWarnings("ConstantConditions")
    public String shortestCompletingWord(String licensePlate, String[] words) {
        final int[] map = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                map[c - 'a']++;
            }
        }
        String res = null;
        for (String w : words) {
            if (check(map, w) && (res == null || res.length() > w.length())) {
                res = w;
            }
        }
        return res;
    }

    private static boolean check(int[] map, String w) {
        final int[] map2 = new int[26];
        for (char c : w.toCharArray()) {
            map2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > map2[i]) {
                return false;
            }
        }
        return true;
    }
}
