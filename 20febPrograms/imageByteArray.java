import java.io.*;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String destinationImage = "copy.jpg";

        byte[] imageData = readImageToByteArray(sourceImage);
        if (imageData != null) {
            writeByteArrayToImage(imageData, destinationImage);
        }
    }

    private static byte[] readImageToByteArray(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image successfully converted to byte array.");
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
            return null;
        }
    }

    private static void writeByteArrayToImage(byte[] imageData, String filePath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(filePath)) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Byte array successfully written to image file.");
        } catch (IOException e) {
            System.out.println("Error writing image: " + e.getMessage());
        }
    }
}
