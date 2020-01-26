package biweekly_18;

public class P_1328 {

    public String breakPalindrome(String palindrome) {
        final char[] chars = palindrome.toCharArray();
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        chars[palindrome.length() - 1] = 'b';
        return palindrome.length() == 1 ? "" : new String(chars);
    }
}
