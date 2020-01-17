package easy;

public class P_1021 {

    public String removeOuterParentheses(String s) {
        int openParentheses = 0;
        final StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(' && openParentheses++ > 0) { res.append('('); }
            if (c == ')' && openParentheses-- > 0) { res.append(')'); }
        }

        return res.toString();
    }
}
