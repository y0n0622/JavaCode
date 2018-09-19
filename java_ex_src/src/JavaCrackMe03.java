/**
 * Created by y0nz1 on 2017/4/21.
 */
public class JavaCrackMe03 {

    public static char[] szSrc = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static char[] szKey = new char[]{'b', 'f', 'd', 'j', 'z', 'e', 'r', 'm', 'i', 'a', 'k', 'x', 'v', 'h', 'c', 'g', 'o', 'p', 'l', 'q', 's', 'n', 't', 'u', 'w', 'y'};

    public static int getIndex(char[] arr, char ch) {
        for(int i = 0; i < arr.length; ++i) {
            if(ch == arr[i]) {
                return i;
            }
        }

        return -1;
    }

    public static String encode(String string) {
        StringBuffer stringbuffer = new StringBuffer();

        for(int i = 0; i < string.length(); ++i) {
            char ch = string.charAt(i);
            int m = getIndex(szSrc, ch);
            stringbuffer.append(szKey[m]);
        }

        System.out.println("密文：" + stringbuffer);
        return new String(stringbuffer);
    }

    public static String DeCode(String string) {
        StringBuffer stringbuffer = new StringBuffer();

        for(int i = 0; i < string.length(); ++i) {
            char ch = string.charAt(i);
            int m = getIndex(szKey, ch);
            stringbuffer.append(szSrc[m]);
        }

        System.out.println("明文：" + stringbuffer);
        return new String(stringbuffer);
    }

    public static void main(String []args)
    {
        encode("java");
        DeCode("abnb");
    }
}
