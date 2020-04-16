package weekly_contests.weekly_53;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("StringRepeatCanBeUsed")
public class P_691 {

    public int minStickersDP(String[] stickers, String target) {
        final int N = target.length();
        final int[] dp = new int[1 << N];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int state = 0; state < 1 << N; state++) {
            if (dp[state] != -1) {
                for (String sticker : stickers) {
                    int now = state;
                    for (char letter : sticker.toCharArray()) {
                        for (int i = 0; i < N; i++) {
                            if (((now >> i) & 1) != 1) {
                                if (target.charAt(i) == letter) {
                                    now |= 1 << i;
                                    break;
                                }
                            }
                        }
                    }
                    if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                        dp[now] = dp[state] + 1;
                    }
                }
            }
        }
        return dp[(1 << N) - 1];
    }

    public int minStickers(String[] stickers, String target) {
        final int n = stickers.length;
        final int[] targetLetters = new int[26];
        final int[][] stickerLetters = new int[n][26];
        for (char c : target.toCharArray()) {
            targetLetters[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerLetters[i][c - 'a']++;
            }
        }
        final Deque<int[]> queue = new ArrayDeque<>(Collections.singleton(targetLetters));
        final Set<String> visited = new HashSet<>();
        for (int res = 1; !queue.isEmpty(); res++) {
            for (int level = queue.size(); level > 0; level--) {
                final int[] curr = queue.removeFirst();
                final String hash = getHash(curr);
                if (visited.add(hash)) {
                    for (int i = 0; i < n; i++) {
                        if (stickerLetters[i][hash.charAt(0) - 'a'] != 0) {
                            final int[] temp = curr.clone();
                            for (int j = 0; j < 26; j++) {
                                temp[j] = Math.max(0, temp[j] - stickerLetters[i][j]);
                            }
                            if (Arrays.equals(temp, new int[26])) {
                                return res;
                            }
                            queue.offerLast(temp);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static String getHash(int[] arr) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
