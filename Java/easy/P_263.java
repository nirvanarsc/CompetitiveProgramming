package easy;

public class P_263 {

    public boolean isUgly(int num) {
        for (int i = 2; i <= 5 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
