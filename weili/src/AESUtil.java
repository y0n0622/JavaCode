import java.nio.charset.Charset;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
    private static int AES_128 = 128;
    private static String AES_CBC_PADDING = "AES/CBC/PKCS5Padding";
    public static String ALGORITHM = "AES";
    private static final Charset CHARSET = Charset.forName("UTF-8");
    private static int IV_16 = 16;

//    public static String genHexIv() {
//        byte[] bArr = new byte[IV_16];
//        new SecureRandom().nextBytes(bArr);
//        return Hex.encodeHexString(bArr);
//    }
//
//    public static String genSecretKey() {
//        try {
//            KeyGenerator instance = KeyGenerator.getInstance(ALGORITHM);
//            instance.init(AES_128);
//            return Hex.encodeHexString(instance.generateKey().getEncoded());
//        } catch (Exception e) {
//            a.b(e);
//            return "";
//        }
//    }
//
//    private static String encrypt(String str, String str2, String str3) {
//        try {
//            return Hex.encodeHexString(encrypt(Hex.decodeHex(str), Hex.decodeHex(str2), str3.getBytes(CHARSET)));
//        } catch (Exception e) {
//            a.b(e);
//            return str3;
//        }
//    }

    public static String decrypt(String str, String str2, String str3) {
        try {
            return new String(decrypt(Hex.decodeHex(str), Hex.decodeHex(str2), Hex.decodeHex(str3)), CHARSET);
        } catch (Exception e) {
//            a.b(e);
            return str3;
        }
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        return encryptDecrpty(1, bArr, bArr2, bArr3);
    }



    private static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        return encryptDecrpty(2, bArr, bArr2, bArr3);
    }

    private static byte[] encryptDecrpty(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        Cipher instance = Cipher.getInstance(AES_CBC_PADDING);
        instance.init(i, new SecretKeySpec(bArr, ALGORITHM), new IvParameterSpec(bArr2));
        return instance.doFinal(bArr3);
    }
}