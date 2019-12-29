package weekly_169;

public final class P_1306 {

    public static boolean canReach(int[] arr, int start) {
        return recurse(arr, start, new Boolean[arr.length], new boolean[arr.length]);
    }

    private static boolean recurse(int[] arr, int start, Boolean[] dp, boolean[] visited) {
        if (start < 0 || start >= arr.length || visited[start]) {
            return false;
        }
        if (dp[start] != null && !visited[start]) {
            visited[start] = true;
            return dp[start];
        }
        if (arr[start] == 0) {
            return true;
        }
        visited[start] = true;
        return dp[start] = recurse(arr, start - arr[start], dp, visited) ||
                           recurse(arr, start + arr[start], dp, visited);
    }

    public static void main(String[] args) {
        System.out.println(canReach(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 5));
        System.out.println(canReach(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 0));
        System.out.println(canReach(new int[] { 3, 0, 2, 1, 2 }, 2));
    }

    private P_1306() {}
}
