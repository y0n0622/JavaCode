/**
 * Created by y0nz1 on 2017/4/21.
 *
 */


public class JavaCrackMe01 {
    public static String encode(String plaintext) {
        String stringIV = "abcdefghijklmnopqrstuvwxyz";
        byte key = 15;
        StringBuffer stringDestIV = new StringBuffer();

        int i;
        char ch;
        for(int ciphertext = 0; ciphertext < 26; ++ciphertext) {
            i = (key + ciphertext) % 26;//15+0 % 26       15 16 17 18 19 20 21 22 23 24 25 26 1 2 3 4 5 6 7 8 9 10 11 12 13 14
            ch = stringIV.charAt(i);  //                  p  q  r  s  t  u  v  w  x  y  z   a a b c d e f g h i j  k  l  m  n  o
            stringDestIV.append(Character.toUpperCase(ch)); //
        }

        System.out.println("加密表为: " + stringDestIV);
        StringBuffer var9 = new StringBuffer();

        for(i = 0; i < plaintext.length(); ++i) { ///明文plaintext  fengziyan  9
            ch = plaintext.charAt(i);              ///
            int index = 0;

            for(int ch2 = 0; ch2 < stringIV.length(); ++ch2) {  //f 0-23
                if(ch == stringIV.charAt(ch2)) {
                    index = ch2;
                    break;
                }
            }

            char var10 = stringDestIV.charAt(index);
            var9.append(Character.toUpperCase(var10));
        }

        return new String(var9);
    }

    public static String DeCode(String cipherText) {
        String stringIV = "abcdefghijklmnopqrstuvwxyz";

        byte key = 15;
        StringBuffer stringDestIV = new StringBuffer();

        int i;
        char ch;

        for(int ciphertext = 0; ciphertext < 26; ++ciphertext) {
            i = (key + ciphertext) % 26;//15+0 % 26       15 16 17 18 19 20 21 22 23 24 25 26 1 2 3 4 5 6 7 8 9 10 11 12 13 14
            ch = stringIV.charAt(i);  //                  p  q  r  s  t  u  v  w  x  y  z   a a b c d e f g h i j  k  l  m  n  o
            stringDestIV.append(Character.toUpperCase(ch)); //
        }

        System.out.println("解密表为: " + stringIV);
        StringBuffer var9 = new StringBuffer();

        for(i = 0; i < cipherText.length(); ++i) {
            ch = cipherText.charAt(i);
            int index = 0;

            for(int ch2 = 0; ch2 < stringDestIV.length(); ++ch2) {
                if(ch == stringDestIV.charAt(ch2)) {
                    index = ch2;
                    break;
                }
            }

            char var10 = stringIV.charAt(index);
            var9.append(var10);
        }

        return new String(var9);
    }

    public static void main(String []args)
    {
       System.out.println(encode("y0n"));//PQRSTUVWXYZABCDEFGHIJKLMNO
        //                                       abcdefghijklmnopqrstuvwxyz
       System.out.print(DeCode("NPC"));
    }
}
