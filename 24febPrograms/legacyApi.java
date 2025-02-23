// Class with deprecated and new methods
class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature and should not be used.");
    }

    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // Warning: Deprecated method
        api.newFeature(); // Recommended method
    }
}
