import java.util.regex.Pattern;

final class DefangingIPAddress {

    private static final Pattern PATTERN = Pattern.compile("\\.");

    public static void main(String[] args) {
        System.out.println(defangIPaddr("255.100.50.0"));
        System.out.println(defangIPaddr("1.1.1.1"));
    }

    private static String defangIPaddr(String address) {
        return PATTERN.matcher(address).replaceAll("[.]");
    }
}
