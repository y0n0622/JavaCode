import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Arrays;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
public class aesUtil {
    public static String ees_ccp(String arg4) {
        if(arg4.isEmpty()) {
            return null;
        }

        try {
            MessageDigest v0 = MessageDigest.getInstance("SHA-256");
            v0.update("dea5a27becaa2e054b959b3b7c8c95034949e4ab".getBytes("UTF-8"));
            byte[] v4_1 = ees_ccc(ees_cco(arg4.getBytes("UTF-8"), v0.digest()).getBytes("UTF-8"));
            if(v4_1 != null) {
                return new String(v4_1);
            }
        }
        catch(Exception v4) {
//            pjv.cco(v4);
        }

        return null;
    }
    public static byte[] ees_ccc(byte[] arg3) {
        byte[] v0 = null;
        if(arg3 != null) {
            if(arg3.length == 0) {
                return null;
            }

            int v2 = arg3.length - arg3[arg3.length - 1];
            if(v2 > 0) {
                if(v2 > arg3.length) {
                    return null;
                }

                v0 = new byte[v2];
                System.arraycopy(((Object)arg3), 0, ((Object)v0), 0, v2);
            }
        }

        return v0;
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static final String KEY_ALGORITHM = "AES";
    private static SecretKeySpec getSecretKey(final String key) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;

        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);

            //AES 要求密钥长度为 128
            kg.init(128, new SecureRandom(key.getBytes()));

            //生成一个密钥
            SecretKey secretKey = kg.generateKey();

            return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);// 转换为AES专用密钥
        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(AESUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
//    private static String secretKey = "boooooooooom!!!!";
//    private static String salt = "ssshhhhhhhhhhh!!!!";
//
//    public static String decrypt(String strToDecrypt, String secret) {
//        try
//        {
//            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//            IvParameterSpec ivspec = new IvParameterSpec(iv);
//
//            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
//            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
//            SecretKey tmp = factory.generateSecret(spec);
//            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
//
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
//            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
//        }
//        catch (Exception e) {
//            System.out.println("Error while decrypting: " + e.toString());
//        }
//        return null;
//    }

    public static String ees_cco(byte[] arg4, byte[] arg5) {
        try {
            Cipher v0 = Cipher.getInstance("AES/CBC/NoPadding");
            v0.init(Cipher.DECRYPT_MODE, new SecretKeySpec(arg5, "AES"), new IvParameterSpec("sa3c94yy71wrr8oy".getBytes()));
//            v0.init(2, getSecretKey("sa3c94yy71wrr8oy"));
            byte[] v4_1 = v0.doFinal(eek_cco(arg4));
            return new String(ees_ccp("sa3c94yy71wrr8oy".getBytes(), v4_1));
        }
        catch(Exception v4) {
//            pjv.cco(v4);
            return "发生异常";
        }
    }
    public static byte[] eek_cco(byte[] arg2) {
        return eek_ccc(arg2, 0, arg2.length);
    }
    private static byte[] eek_ccd = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 0x3F, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 0x1F, 0x20, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 0x2F, 0x30, 49, 50, 51, -9, -9, -9, -9, -9};

    public static byte[] eek_ccc(byte[] arg1, int arg2, int arg3) {
        return eek_ccc(arg1, arg2, arg3, eek_ccd);
    }
    public static byte[] eek_ccc(byte[] arg17, int arg18, int arg19, byte[] arg20) {
        int v0_1;
        int v2 = arg19;
        byte[] v3 = arg20;
        byte[] v4 = new byte[v2 * 3 / 4 + 2];
        byte[] v7 = new byte[4];
        int v9 = 0;
        int v10 = 0;
        int v11 = 0;
        while(v9 < v2) {
            int v14 = v9 + arg18;
            byte v15 = (byte)(arg17[v14] & 0x7F);
            int v8 = v3[v15];
            if(v8 >= -5) {
                if(v8 >= -1) {
                    if(v15 == 61) {
                        int v5 = v2 - v9;
                        byte v0 = (byte)(arg17[v2 - 1 + arg18] & 0x7F);
                        if(v10 != 0 && v10 != 1) {
                            if(v10 == 3 && v5 > 2 || v10 == 4 && v5 > 1) {
//                                throw new Exception("padding byte \'=\' falsely signals end of encoded value at offset " + v9);
                            }

                            if(v0 == 61 || v0 == 10) {
                                break;
                            }

//                            throw new Exception("encoded value has invalid trailing byte");
                        }

//                        throw new Exception("invalid padding byte \'=\' at byte offset " + v9);
                    }

                    int v5_1 = v10 + 1;
                    v7[v10] = v15;
                    if(v5_1 == 4) {
                        v11 += eek_ccc(v7, 0, v4, v11, v3);
                        v10 = 0;
                    }
                    else {
                        v10 = v5_1;
                    }
                }

                ++v9;
                continue;
            }

//            throw new Exception("Bad Base64 input character at " + v9 + ": " + arg17[v14] + "(decimal)");
        }

        if(v10 == 0) {
            v0_1 = 0;
        }
        else {
            if(v10 == 1) {
//                throw new Exception("single trailing character at offset " + (v2 - 1));
            }

            v7[v10] = 61;
            v0_1 = 0;
            v11 += eek_ccc(v7, 0, v4, v11, v3);
        }

        byte[] v1 = new byte[v11];
        System.arraycopy(((Object)v4), v0_1, ((Object)v1), v0_1, v11);
        return v1;
    }
    private static int eek_ccc(byte[] arg6, int arg7, byte[] arg8, int arg9, byte[] arg10) {
        int v0 = arg7 + 2;
        if(arg6[v0] == 61) {
            arg8[arg9] = (byte)((arg10[arg6[arg7 + 1]] << 24 >>> 12 | arg10[arg6[arg7]] << 24 >>> 6) >>> 16);
            return 1;
        }

        int v1 = arg7 + 3;
        if(arg6[v1] == 61) {
            int v6 = arg10[arg6[v0]] << 24 >>> 18 | (arg10[arg6[arg7 + 1]] << 24 >>> 12 | arg10[arg6[arg7]] << 24 >>> 6);
            arg8[arg9] = (byte)(v6 >>> 16);
            arg8[arg9 + 1] = (byte)(v6 >>> 8);
            return 2;
        }

        int v6_1 = arg10[arg6[v1]] << 24 >>> 24 | (arg10[arg6[arg7 + 1]] << 24 >>> 12 | arg10[arg6[arg7]] << 24 >>> 6 | arg10[arg6[v0]] << 24 >>> 18);
        arg8[arg9] = (byte)(v6_1 >> 16);
        arg8[arg9 + 1] = (byte)(v6_1 >> 8);
        arg8[arg9 + 2] = (byte)v6_1;
        return 3;
    }

    public static byte[] ees_ccp(byte[] arg1, byte[] arg2) {
        return Arrays.copyOfRange(arg2, arg1.length, arg2.length);
    }

}
