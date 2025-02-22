public class IPAddressValidator {
    public static boolean isValidIPv4(String ip) {
        if (ip == null || ip.isEmpty()) return false;
        
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;
        
        for (String part : parts) {
            if (!isValidPart(part)) return false;
        }
        
        return true;
    }

    private static boolean isValidPart(String part) {
        if (part.isEmpty() || part.length() > 3) return false;
        if (!part.matches("\\d+")) return false;  // Ensure it's numeric
        
        int num = Integer.parseInt(part);
        if (num < 0 || num > 255) return false;
        
        return part.equals(String.valueOf(num)); // Check for leading zeros
    }

    public static void main(String[] args) {
        System.out.println(isValidIPv4("192.168.1.1"));  // true
        System.out.println(isValidIPv4("255.255.255.255"));  // true
        System.out.println(isValidIPv4("256.100.50.25"));  // false
        System.out
