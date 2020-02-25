package weekly_contests.weekly_140;

public class P_1079 {

    public int numTilePossibilities(String tiles) {
        final int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        return dfs(count);
    }

    private static int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                sum++;
                arr[i]--;
                sum += dfs(arr);
                arr[i]++;
            }
        }
        return sum;
    }
}
