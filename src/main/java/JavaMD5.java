import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

public class JavaMD5 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)){
            byte[] bytes = MessageDigest.getInstance("MD5").digest(in.nextLine().getBytes());
            System.out.printf("%32x\n", new BigInteger(1, bytes));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
