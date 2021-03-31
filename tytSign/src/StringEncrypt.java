




import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class StringEncrypt {
    public static String Encrypt(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bytes);
            return getBase64(instance.digest());
        } catch (Exception unused) {
            return "";
        }
    }

//    public static String EncryptApp(String str) {
//        if (str != null && str.length() > 0) {
//            try {
//                MessageDigest instance = MessageDigest.getInstance("SHA-256");
//                instance.update(str.getBytes());
//                byte[] digest = instance.digest();
//                StringBuffer stringBuffer = new StringBuffer();
//                for (byte b : digest) {
//                    String hexString = Integer.toHexString(b & 255);
//                    if (hexString.length() == 1) {
//                        stringBuffer.append('0');
//                    }
//                    stringBuffer.append(hexString);
//                }
//                return stringBuffer.toString();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }

//    private static String bytes2Hex(byte[] bArr) {
//        String str = "";
//        for (byte b : bArr) {
//            String hexString = Integer.toHexString(b & 255);
//            if (hexString.length() == 1) {
//                str = str + b.x;
//            }
//            str = str + hexString;
//        }
//        return str;
//    }

//    public static String getBase64(String str) {
//        if (str != null) {
//            try {
//                return getBase64(str.getBytes("utf-8"));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//        return "";
//    }

    public static String getBase64(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(Base64.encode(bArr, bArr.length));//, "utf-8"
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

//    public static final String simpleEncrypt(String str) {
//        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
//        try {
//            byte[] bytes = str.getBytes();
//            MessageDigest instance = MessageDigest.getInstance("MD5");
//            instance.update(bytes);
//            char[] cArr2 = new char[(r1 * 2)];
//            int i = 0;
//            for (byte b : instance.digest()) {
//                int i2 = i + 1;
//                cArr2[i] = cArr[(b >>> 4) & 15];
//                i = i2 + 1;
//                cArr2[i2] = cArr[b & 15];
//            }
//            return new String(cArr2);
//        } catch (Exception unused) {
//            return "";
//        }
//    }

//    public static String decodeBase64(String str) {
//        return !TextUtils.isEmpty(str) ? new String(Base64.decode(str.getBytes(), 0)) : "";
//    }
//
//    public static boolean ih_verifySHA256WithRSA(String str, String str2, String str3) {
//        try {
//            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(Utils.isCheckPubKey(str3), 0)));
//            Signature instance = Signature.getInstance("SHA256withRSA");
//            instance.initVerify(generatePublic);
//            instance.update(str.getBytes());
//            L.d("ih_verifySHA256WithRSA: clearText=" + str + "  signKey=" + str2);
//            return instance.verify(Base64.decode(str2, 0));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    public static void main(String[] args) {
        String key = "cnvuxbg4vtihydyemAXdqpcawf9uglym";
        String realkey = key.substring(2, 6) + key.substring(8, 15) + key.substring(10, 13) + key.substring(25, 27);
        System.out.println(realkey);
        String xx = Encrypt(realkey+"appid=8&deviceid=7c447081e8ba6669d9db705d6c5f0c955a&password=N+lqHSdbIr9eVArxgcnUIA4DzHuOFC/Wq0muFzzRak2spSCHHFboiLcs/eH495ZHzRwETlQTkr29hSawkiO7wR4g5fsRJikQ3vwL1flkSdF8YF/tXRs3JOKlVPWqdw394y0/Qm4D1YqI4lASnxdU4AkhKnq9d0G7TLXuxWJ1o7w=&safemobile=wo+4R81RzEjrC0/nMyIAXg==&timestamp=1596351978");
        System.out.println(xx);
    }

}