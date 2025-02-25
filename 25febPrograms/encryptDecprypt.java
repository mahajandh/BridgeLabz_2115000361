import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;

public class EncryptDecryptCSV {
    private static final String AES = "AES";
    private static final byte[] KEY = "MySecretKey12345".getBytes(); 

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        SecretKey secretKey = new SecretKeySpec(KEY, AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public static String decrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(AES);
        SecretKey secretKey = new SecretKeySpec(KEY, AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }

    public static void writeEncryptedCSV(String filePath, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("ID,Name,Email,Salary\n");
            for (String[] row : data) {
                bw.write(row[0] + "," + row[1] + "," + encrypt(row[2]) + "," + encrypt(row[3]) + "\n");
            }
            System.out.println("Encrypted CSV written: " + filePath);
        } catch (Exception e) {
            System.err.println("Error writing encrypted CSV: " + e.getMessage());
        }
    }

    public static void readDecryptedCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            System.out.println(line);
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println(data[0] + "," + data[1] + "," + decrypt(data[2]) + "," + decrypt(data[3]));
            }
        } catch (Exception e) {
            System.err.println("Error reading decrypted CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "employees_encrypted.csv";
        List<String[]> employees = new ArrayList<>();
        employees.add(new String[]{"101", "John", "john@example.com", "50000"});
        employees.add(new String[]{"102", "Emma", "emma@example.com", "60000"});

        writeEncryptedCSV(filePath, employees);
        System.out.println("\nDecrypted CSV Data:");
        readDecryptedCSV(filePath);
    }
}
