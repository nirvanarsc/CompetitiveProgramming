import java.util.Stack;

public final class BaseballGame {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    public static int calPoints(String[] ops) {
        final Stack<Integer> valid = new Stack<>();
        int sum = 0;
        for (String s : ops) {
            if ("+".equals(s)) {
                valid.push(valid.elementAt(valid.size() - 1) + valid.elementAt(valid.size() - 2));
            } else if ("D".equals(s)) {
                valid.push(2 * valid.peek());
            } else if ("C".equals(s)) {
                valid.pop();
            } else {
                valid.push(Integer.parseInt(s));
            }
        }

        for (int i : valid) {
            sum += i;
        }
        return sum;
    }

    private BaseballGame() {
    }
}
