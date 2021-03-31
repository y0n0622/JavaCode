

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
    public static String b(String arg3, String arg4) {
        if(arg3.isEmpty()) {
            return null;
        }

        try {
            byte[] v3_1 = Base64.decode(arg3, 0);
            SecretKeySpec v0 = new SecretKeySpec(arg4.getBytes(), "AES");
            Cipher v4 = Cipher.getInstance("AES/ECB/PKCS5Padding");
            v4.init(2, v0);
            return new String(v4.doFinal(v3_1));
        }
        catch(Exception v3) {
            v3.printStackTrace();
            return null;
        }
    }
}
