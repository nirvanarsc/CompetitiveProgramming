package easy;

public class P_299 {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        final int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            final int s = secret.charAt(i) - '0';
            final int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                if (numbers[s] < 0) { cows++; }
                if (numbers[g] > 0) { cows++; }
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + 'B';
    }

    public String getHintBF(String secret, String guess) {
        final int n = secret.length();
        final int[] freq = new int[10];
        final boolean[] seen = new boolean[n];
        for (char c : secret.toCharArray()) {
            freq[c - '0']++;
        }
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                freq[secret.charAt(i) - '0']--;
                seen[i] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            final int curr = guess.charAt(i) - '0';
            if (!seen[i] && freq[curr] > 0) {
                cows++;
                freq[curr]--;
            }
        }
        return bulls + "A" + cows + 'B';
    }
}
