import java.util.regex.*;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        return color.matches("^#[0-9A-Fa-f]{6}$");
    }

    public static void main(String[] args) {
        String[] testColors = {"#FFA500", "#ff4500", "#123", "#GGGGGG", "#abcdef"};

        for (String color : testColors) {
            if (isValidHexColor(color)) {
                System.out.println("✅ \"" + color + "\" → Valid");
            } else {
                System.out.println("❌ \"" + color + "\" → Invalid");
            }
        }
    }
}
