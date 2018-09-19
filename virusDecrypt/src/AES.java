/**
 * Created by y0nz1 on 2017/8/4.
 */
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
public class AES {
        private static final String CipherMode = "AES/ECB/PKCS5Padding";
        public AES() {
            super();
        }
        public static String byte2hex(byte[] arg5) {
            StringBuffer v1 = new StringBuffer(arg5.length * 2);
            int v0;
            for(v0 = 0; v0 < arg5.length; ++v0) {
                String v2 = Integer.toHexString(arg5[v0] & 255);
                if(v2.length() == 1) {
                    v1.append("0");
                }

                v1.append(v2);
            }

            return v1.toString().toUpperCase();
        }

        private static SecretKeySpec createKey(String arg4) {
            byte[] v0 = new byte[7];
            int v3 = 32;
            if(arg4 == null) {
                arg4 = "";
            }

            StringBuffer v1 = new StringBuffer(v3);
            v1.append(arg4);
            while(v1.length() < v3) {
                v1.append("0");
            }

            if(v1.length() >= v3) {
                v1.setLength(v3);
            }

            try {
                v0 = v1.toString().getBytes("UTF-8");
            }
            catch(UnsupportedEncodingException v1_1) {
                v1_1.printStackTrace();
            }

            return new SecretKeySpec(v0, "AES");
        }

        public static String decrypt(String arg4, String arg5) {
            byte[] v0 = new byte[20];
            String v1 = null;
            try {
                v0 = AES.hex2byte(arg4);
            }
            catch(Exception v2) {
                v2.printStackTrace();
            }

            byte[] v2_1 = AES.decrypt(v0, arg5);
            if(v2_1 != null) {
                try {
                    v1 = new String(v2_1, "UTF-8");
                }
                catch(UnsupportedEncodingException v0_1) {
                    v0_1.printStackTrace();
                }
            }

            return v1;
        }

        public static byte[] decrypt(byte[] arg3, String arg4) {
            byte[] v0_2;
            try {
                SecretKeySpec v0_1 = AES.createKey(arg4);
                Cipher v1 = Cipher.getInstance("AES/ECB/PKCS5Padding");
                v1.init(2, ((Key)v0_1));
                v0_2 = v1.doFinal(arg3);
            }
            catch(Exception v0) {
                v0.printStackTrace();
                v0_2 = null;
            }

            return v0_2;
        }
        //public  static  byte[] v0 = new byte[20];
        public static String encrypt(String arg2, String arg3) {
            byte[] v0 = new byte[7];
            try {
                v0 = arg2.getBytes("UTF-8");
            }
            catch(Exception v1) {
                v1.printStackTrace();
            }

            return AES.byte2hex(AES.encrypt(v0, arg3));
        }

        public static byte[] encrypt(byte[] arg3, String arg4) {
            byte[] v0_2;
            try {
                SecretKeySpec v0_1 = AES.createKey(arg4);
                //Key v0_1 = AES.createKey(arg4);
                //SecretKeySpec v0_1 = new SecretKeySpec(arg4.getBytes(), "AES");
                System.out.println(v0_1);
                Cipher v1 = Cipher.getInstance("AES/CBC/PKCS5PADDING");
                v1.init(Cipher.ENCRYPT_MODE, ((Key)v0_1));//, new SecureRandom()

                v0_2 = v1.doFinal(arg3);
            }
            catch(Exception v0) {
                v0.printStackTrace();
                v0_2 = null;
            }

            return v0_2;
        }

        private static byte[] hex2byte(String arg6) {
            byte[] v0;
            int v1 = 0;
            if(arg6 == null || arg6.length() < 2) {
                v0 = new byte[0];
            }
            else {
                String v2 = arg6.toLowerCase();
                int v3 = v2.length() / 2;
                v0 = new byte[v3];
                while(v1 < v3) {
                    v0[v1] = ((byte)(Integer.parseInt(v2.substring(v1 * 2, v1 * 2 + 2), 16) & 255));
                    ++v1;
                }
            }
            return v0;
        }
}
