import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Scanner;

public class JavaSHA256 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner( System.in )) {
            String word = scanner.nextLine();

            MessageDigest messageDigest = MessageDigest.getInstance( "SHA-256" );
            messageDigest.update(word.getBytes(StandardCharsets.UTF_8));
            byte[] byteHash = messageDigest.digest();

            for (byte b : byteHash ) {
                System.out.format( "%02x", b );
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
