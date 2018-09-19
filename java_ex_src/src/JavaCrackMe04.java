/**
 * Created by y0nz1 on 2017/4/21.
 */
public class JavaCrackMe04 {

    private static char[] key = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();

    public static char[] encode(byte[] var0) {
        char[] var1 = new char[(var0.length + 2) / 3 << 2];
        int var2 = 0;

        for(int var3 = 0; var2 < var0.length; var3 += 4) {
            boolean var4 = false;
            boolean var5 = false;
            int var6 = (var6 = 255 & var0[var2]) << 8;
            if(var2 + 1 < var0.length) {
                var6 |= 255 & var0[var2 + 1];
                var5 = true;
            }

            var6 <<= 8;
            if(var2 + 2 < var0.length) {
                var6 |= 255 & var0[var2 + 2];
                var4 = true;
            }

            var1[var3 + 3] = key[var4?var6 & 63:64];
            var6 >>= 6;
            var1[var3 + 2] = key[var5?var6 & 63:64];
            var6 >>= 6;
            var1[var3 + 1] = key[var6 & 63];
            var6 >>= 6;
            var1[var3] = key[var6 & 63];
            var2 += 3;
        }

        return var1;
    }

    public static char[] DeCode(byte[] cipherText) {
        char[] var1 = new char[(cipherText.length + 2) / 4 << 2];
        int var2 = 0;
        int []tempj = new int[20];
        for(int var3 = 0; var2 < cipherText.length; var3 += 3) {
            boolean var4 = false;
            boolean var5 = false;
            //boolean var7 = false;
            for (int i =0; i < cipherText.length; i++)
            {
                for (int j = 0; j < 64; j++)
                if (cipherText[i] == key[j])
                {
                    tempj[i] = j;
                    break;
                }
            }
            int var6 = (var6 = 63 & tempj[var2]) << 6;

            if(var2 + 1 < cipherText.length) {
                var6 |= 63 & tempj[var2 + 1];
                var5 = true;
            }
            var6 <<= 6;
            if(var2 + 2 < cipherText.length) {
                var6 |= 63 & tempj[var2 + 2];
                var4 = true;
            }
            var6 <<= 6;
            if(var2 + 3 < cipherText.length) {
                var6 |= 63 & tempj[var2 + 3];
               // var7 = true;
            }
            var1[var3 + 2] = (char)(var6 & 255);//key[var4?var6 & 255:64];
            var6 >>= 8;
            var1[var3 + 1] = (char)(var6 & 255);//key[var5?var6 & 255:64];
            var6 >>= 8;
            var1[var3] = (char)(var6);
            var2 += 4;
        }
        return var1;
    }



    public static void main(String []args)
    {
        char[] a = encode("y0n".getBytes());
        System.out.print("密文：");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]);

        System.out.println();
        char[] b = DeCode("eTBu".getBytes());
        System.out.print("明文：");
        for (int i = 0; i < b.length; i++)
            System.out.print(b[i]);

        // char[] b = DeCode("ZmVuZ3ppeWFu".getBytes());
       // b.toString();
       // System.out.println("明文：" + b);

    }
}
