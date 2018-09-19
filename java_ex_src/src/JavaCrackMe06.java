/**
 * Created by y0nz1 on 2017/4/23.
 */
public class JavaCrackMe06 {
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

    public static void encrypt(int[] v, int[] k) {
        int y = v[0];
        int z = v[1];
        int sum = 0;
        int delta = -1640531527;

        for(int n = 32; n-- > 0; z += (y << 4) + k[2] ^ y + sum ^ (y >> 5) + k[3]) {
            sum += delta;
            y += (z << 4) + k[0] ^ z + sum ^ (z >> 5) + k[1];
        }

        v[0] = y;
        v[1] = z;
    }

    public static byte[] intToBytes(int n) {
        byte[] b = new byte[4];

        for(int i = 0; i < 4; ++i) {
            b[i] = (byte)(n >> 24 - i * 8);
        }

        return b;
    }

    public static byte[] intToBytes2(int n) {
        byte[] b = new byte[]{(byte)(n & 255), (byte)(n >> 8 & 255), (byte)(n >> 16 & 255), (byte)(n >> 24 & 255)};
        return b;
    }

    public static String encode(String inStr) {
        Object messageDigest = null;

        try {
            byte[] e = inStr.getBytes();
            int nlen = e.length % 4 > 0?1:0;
            if(e.length / 4 + nlen != 2) {
                return "";
            } else {
                int[] v = new int[e.length / 4];
                int k = 0;

                for(int size = 0; k < e.length; ++size) {
                    v[size] |= e[k] & 255;
                    v[size] |= e[k + 1] << 8 & '\uff00';
                    v[size] |= e[k + 2] << 16 & 16711680;
                    v[size] |= e[k + 3] << 24 & -16777216;
                    k += 4;
                }

                int[] var15 = new int[]{19088743, -1985229329, -19088744, 1985229328};
                boolean var16 = false;
                encrypt(v, var15);
                byte[] b1 = intToBytes(v[0]);
                byte[] b2 = intToBytes(v[1]);
                byte[] bCode = new byte[8];
                int index = 0;
                new StringBuffer();

                int i;
                for(i = 0; i < b1.length; ++i) {
                    bCode[index++] = b1[i];
                }

                for(i = 0; i < b2.length; ++i) {
                    bCode[index++] = b2[i];
                }

                return new String(toHexString(bCode));
            }
        } catch (Exception var14) {
            System.out.println(var14.toString());
            var14.printStackTrace();
            return "";
        }
    }

    public static void main(String []args)
    {
        System.out.print(encode("1234"));

    }

}
