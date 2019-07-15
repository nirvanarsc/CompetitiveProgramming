import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class RobotReturnOrigin {

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
    }

    @Contract(pure = true)
    private static boolean judgeCircle(@NotNull String moves) {
        int v = 0, h = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    v++;
                    break;
                case 'D':
                    v--;
                    break;
                case 'R':
                    h++;
                    break;
                case 'L':
                    h--;
            }
        }
        return v == 0 && h == 0;
    }
}
