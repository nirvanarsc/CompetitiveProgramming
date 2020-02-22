package biweekly_4;

public class P_1119 {

    public String removeVowels(String s) {
        final StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
