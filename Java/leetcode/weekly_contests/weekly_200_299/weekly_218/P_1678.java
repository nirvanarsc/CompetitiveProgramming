package leetcode.weekly_contests.weekly_200_299.weekly_218;

public class P_1678 {

    public String interpret(String command) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i += 1;
                } else {
                    sb.append('a');
                    sb.append('l');
                    i += 3;
                }
            }
        }
        return sb.toString();
    }
}
