import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        System.out.println(m3("QWJrEn1bge8ZMsWxf66kbs8LhqOASMd/reU+j+OFEKA="));
        System.out.println(new String(Base64.decode("aHR0cDovL3ZlcmRkZGFkZC5qaXl3LmNvbS9pbWRqZGtuZmRiYmFsa2ppZmRuYWJrZGkuYXNweD9wPQ==".getBytes(), 0)));
    }
    private static String m3(String str) {
        byte[] bArr = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec("qyma".toCharArray(), "$9s1{;1H".getBytes("UTF-8"), 5, 256)).getEncoded(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec("F-=5!2]/9G(<(=uY".getBytes("UTF-8")));
            bArr = instance.doFinal(Base64.decode(str, 0));
        } catch (Exception e) {
        }
        if (bArr != null) {
            return new String(bArr);
        }
        return str;
    }

}
