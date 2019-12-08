package medium;

public final class P_1079 {

    public static int numTilePossibilities(String tiles) {
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

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("ABC"));
    }

    private P_1079() {}
}
