class DefangingIPAddress {

    public static void main(String[] args) {
        System.out.println(defangIPaddr("255.100.50.0"));
        System.out.println(defangIPaddr("1.1.1.1"));
    }

    private static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}