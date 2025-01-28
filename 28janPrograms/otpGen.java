import java.util.HashSet;
import java.util.Set;

public class OTPGenerator {

    // Method to generate a 6-digit OTP number using Math.random()
    public static int generateOTP() {
        // Generate a random number between 100000 and 999999
        return (int) (Math.random() * 900000) + 100000;
    }

    // Method to ensure that the OTP numbers generated are unique
    public static boolean areOTPsUnique(int[] otpNumbers) {
        Set<Integer> otpSet = new HashSet<>();
        
        // Add all OTP numbers to a set (Set automatically ensures uniqueness)
        for (int otp : otpNumbers) {
            otpSet.add(otp);
        }
        
        // If the size of the set is the same as the array length, all OTPs are unique
        return otpSet.size() == otpNumbers.length;
    }

    public static void main(String[] args) {
        int[] otpNumbers = new int[10];
        
        // Generate 10 OTP numbers and store them in the array
        for (int i = 0; i < otpNumbers.length; i++) {
            otpNumbers[i] = generateOTP();
        }
        
        // Print the generated OTP numbers
        System.out.println("Generated OTPs:");
        for (int otp : otpNumbers) {
            System.out.println(otp);
        }
        
        // Check if all OTP numbers are unique
        boolean isUnique = areOTPsUnique(otpNumbers);
        if (isUnique) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Some OTPs are not unique.");
        }
    }
}

