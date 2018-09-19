import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;

/**
 * Created by y0n on 2017/8/22.
 */
public class Main {
    private static String a = "DESede";
    private static Key b;
    private static int c = 5;
    public static byte[] step1_string(String arg9) {
        byte[] v1 = arg9.getBytes();
        int v2 = v1.length;
        byte[] v3 = new byte[v2 / 2];
        int v0;
        for(v0 = 0; v0 < v2; v0 += 2) {
            v3[v0 / 2] = ((byte)Integer.parseInt(new String(v1, v0, 2), 16));
        }
        return v3;
    }
    public static String step3_byte(byte[] arg6) {

        StringBuffer v2 = new StringBuffer();
        int v1;
        for(v1 = 0; v1 < arg6.length; ++v1) {
            System.out.print(arg6[v1] + " ");
            String v0 = Integer.toHexString(arg6[v1] & 255);
            if(v0.length() == 1) {
                v0 = String.valueOf('0') + v0;
            }
            v2.append(v0);
        }
        //System.out.println(v2);
        return v2.toString();
    }
    public static byte[] step3_string(String arg6) {
        String arg16[] = new String[32];
        byte [] abyte = new byte[32];
        for (int i = 0; i < arg16.length; i = i+2){
            arg16[i] = arg6.substring(i, i+2);
            Integer in = Integer.parseInt(arg16[i], 16);
            byte intnum = in.byteValue();
            abyte[i] = (byte) (intnum & 255);
            System.out.print(abyte[i] + " ");
        }
        return abyte;
    }
    private static byte[] step2_key(byte[] arg7, byte[] arg8) {
        IvParameterSpec v0 = new IvParameterSpec(arg7);
        Cipher v1 = null;
        try {
            v1 = Cipher.getInstance(String.valueOf(a) + "/CBC/PKCS5Padding");
            v1.init(1, b, ((AlgorithmParameterSpec)v0));
            c = v1.getBlockSize();
            byte[] v0_1 = v1.doFinal(arg8);
            byte[] v1_1 = new byte[v0_1.length + c];
            System.arraycopy(arg7, 0, v1_1, 0, c);
            System.arraycopy(v0_1, 0, v1_1, c, v0_1.length);
            return v1_1;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static byte[] step2_dekey(byte[] arg7, byte[] arg8) {

        IvParameterSpec v0 = new IvParameterSpec(arg7);
        Cipher v1 = null;
        try {
            v1 = Cipher.getInstance(String.valueOf(a) + "/CBC/NoPadding");
            v1.init(Cipher.DECRYPT_MODE, b, ((AlgorithmParameterSpec)v0)); // 操作模式为解密,key为密钥
            byte[] sourceText = v1.doFinal(arg8);
            System.out.println();
            for (int j = 0 ; j < sourceText.length; j++){
                System.out.print(sourceText[j] + " ");
            }
            return sourceText;
        }catch (BadPaddingException e) {
            e.printStackTrace();
        }catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Key get_key(byte[] arg4) {
        SecretKey v0_1 = null;
        try {

            if(arg4 == null) {
                KeyGenerator v0 = KeyGenerator.getInstance(a);
                v0.init(new SecureRandom());
                v0_1 = v0.generateKey();
            }
            else {
                SecretKeySpec v0_2 = new SecretKeySpec(arg4, a);
                return ((Key)v0_2);
            }


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return ((Key)v0_1);
    }
    public static void main(String []args){
        //-26 -105 -91 -27 -92 -87 64 -27 -100 -97 -28 -66 -72 3 3 3
//        byte[] sourcebyte = new byte[16];
//
//        sourcebyte[0] = -26;
//        sourcebyte[1] = -105;
//        sourcebyte[2] = -91;
//        sourcebyte[3] = -27;
//        sourcebyte[4] = -92;
//        sourcebyte[5] = -87;
//        sourcebyte[6] = 64;
//        sourcebyte[7] = -27;
//        sourcebyte[8] = -100;
//        sourcebyte[9] = -97;
//        sourcebyte[10] = -28;
//        sourcebyte[11] = -66;
//        sourcebyte[12] = -72;
//        sourcebyte[13] = 3;
//        sourcebyte[14] = 3;
//        sourcebyte[15] = 3;
        //加密模拟
        //1.给key  b 赋值  v0.a(v0.a(a.a(arg5)));
        //argc5 = 1f98ceab209770efa875c245853ece761f98ceab209770ef
        b = get_key(step1_string("1f98ceab209770efa875c245853ece761f98ceab209770ef"));
        //2.获取 arg6 = a.a(v0.a(a.a("000a0a0a0a0202aa"), arg6.getBytes()));
        String result = step3_byte(step2_key(step1_string("000a0a0a0a0202aa"), "日天@土侸".getBytes()));
        System.out.println(result);

        //解密部分
        //000a0a0a0a0202aa5458d715704493d8e6b9bd38f8b6be0e
        //step2_key返回的字节数组:84 88 -41 21 112 68 -109 -40 -26 -71 -67 56 -8 -74 -66 14
        step3_string("5458d715704493d8e6b9bd38f8b6be0e");
        //构造解密的字节
        byte[] bytedecode = new byte[16];
        bytedecode[0] = 84;
        bytedecode[1] = 88;
        bytedecode[2] = -41;
        bytedecode[3] = 21;
        bytedecode[4] = 112;
        bytedecode[5] = 68;
        bytedecode[6] = -109;
        bytedecode[7] = -40;
        bytedecode[8] = -26;
        bytedecode[9] = -71;
        bytedecode[10] = -67;
        bytedecode[11] = 56;
        bytedecode[12] = -8;
        bytedecode[13] = -74;
        bytedecode[14] = -66;
        bytedecode[15] = 14;

        step2_dekey(step1_string("000a0a0a0a0202aa"), bytedecode);
        //-26 -105 -91 -27 -92 -87 64 -27 -100 -97 -28 -66 -72 3 3 3
        byte[] sourcebyte = new byte[16];
        sourcebyte[0] = -26;
        sourcebyte[1] = -105;
        sourcebyte[2] = -91;
        sourcebyte[3] = -27;
        sourcebyte[4] = -92;
        sourcebyte[5] = -87;
        sourcebyte[6] = 64;
        sourcebyte[7] = -27;
        sourcebyte[8] = -100;
        sourcebyte[9] = -97;
        sourcebyte[10] = -28;
        sourcebyte[11] = -66;
        sourcebyte[12] = -72;
        sourcebyte[13] = 3;
        sourcebyte[14] = 3;
        sourcebyte[15] = 3;
        try {
            String str = new String(sourcebyte, "utf-8");
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
