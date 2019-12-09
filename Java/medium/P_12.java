package medium;

public class P_12 {

    String[][] map = {
            { "", "M", "MM", "MMM" },
            { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
            { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
            { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" }
    };

    public String intToRoman(int num) {
        return map[0][num / 1000] + map[1][(num % 1000) / 100] + map[2][(num % 100) / 10] + map[3][num % 10];
    }
}
