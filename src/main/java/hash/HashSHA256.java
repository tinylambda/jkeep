package hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.util.encoders.Hex;

import com.google.common.hash.Hashing;

public class HashSHA256 {
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i=0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String s = "hello world !";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
        String sha256hex = bytesToHex(encodedHash);
        System.out.println(sha256hex);

        sha256hex = Hashing.sha256().hashString(s, StandardCharsets.UTF_8).toString();
        System.out.println(sha256hex);

        sha256hex = DigestUtils.sha256Hex(s);
        System.out.println(sha256hex);

        byte hash[] = digest.digest(s.getBytes(StandardCharsets.UTF_8));
        sha256hex = new String(Hex.encode(hash));
        System.out.println(sha256hex);
    }
}
