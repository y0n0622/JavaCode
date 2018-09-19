import java.security.MessageDigest;

/**
 * Created by y0nz1 on 2017/4/23.
 */
public class JavaCrackMe05 {
    public static String toHexString(byte[] byteArray) {
        StringBuffer hexValue = new StringBuffer();

        for(int i = 0; i < byteArray.length; ++i) {
            int val = byteArray[i] & 255;
            if(val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

    public static String encode(String inStr) {
        MessageDigest messageDigest = null;

        try {
            char[] e = new char[]{'B', 'K', ':'};
            StringBuffer buf = new StringBuffer();

            for(int byteArray = 0; byteArray < 3; ++byteArray) {
                buf.append((char)(e[byteArray] ^ 15));
            }

            messageDigest = MessageDigest.getInstance(buf.toString());
            byte[] var7 = inStr.getBytes("UTF-8");
            byte[] md5Bytes = messageDigest.digest(var7);
            return toHexString(md5Bytes);
        } catch (Exception var6) {
            System.out.println(var6.toString());
            var6.printStackTrace();
            return "";
        }
    }

    public static void main(String []args)
    {
        System.out.print(encode("123"));
    }
}
