package easy;

public class P_299 {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        final int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            final int s = Character.getNumericValue(secret.charAt(i));
            final int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) { bulls++; } else {
                if (numbers[s] < 0) { cows++; }
                if (numbers[g] > 0) { cows++; }
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + 'B';
    }
}
