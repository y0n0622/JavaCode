package com.y0n;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;

public class Main {

    //
    public static /* synthetic */ String getClassName(String str) {
        char[] toCharArray = str.toCharArray();
        for (int i = 0; i < toCharArray.length; i++) {
            toCharArray[i] = (char) (toCharArray[i] ^ 116);
        }
        return new String(toCharArray);
    }


    public static /* synthetic */ String access$_T15566(String str) {
        int i = 0;
        byte[] bArr = new byte[17];
        bArr[0] = (byte) 33;
        bArr[1] = (byte) -95;
        bArr[2] = (byte) 116;
        bArr[3] = (byte) -2;
        bArr[4] = (byte) 94;
        bArr[5] = (byte) -127;
        bArr[6] = (byte) -34;
        bArr[7] = (byte) 114;
        bArr[8] = Byte.MIN_VALUE;
        bArr[9] = (byte) 62;
        bArr[10] = (byte) 122;
        bArr[11] = (byte) 20;
        bArr[12] = (byte) 99;
        bArr[13] = (byte) -64;
        bArr[14] = (byte) -14;
        bArr[15] = Byte.MIN_VALUE;
        bArr[16] = (byte) 48;
        bArr[1] = (byte) (bArr[1] - bArr[12]);
        byte[] bArr2 = new byte[12];
        bArr2[0] = (byte) 16;
        bArr2[1] = (byte) 95;
        bArr2[2] = (byte) -91;
        bArr2[3] = (byte) 122;
        bArr2[4] = (byte) -83;
        bArr2[5] = (byte) -76;
        bArr2[6] = (byte) 21;
        bArr2[7] = (byte) 52;
        bArr2[8] = (byte) 24;
        bArr2[9] = (byte) 21;
        bArr2[10] = (byte) -75;
        bArr2[11] = (byte) 4;
        bArr2[6] = (byte) (bArr2[6] - bArr2[11]);
        AccessibleObject method = null;
        try {

            String classNameStr = new String(new BigInteger(bArr).divide(BigInteger.valueOf((long) (bArr[11] + 60))).toByteArray(), "UTF-8");
            String methodStr = new String(new BigInteger(bArr2).divide(BigInteger.valueOf((long) (bArr2[3] ^ 94))).toByteArray(), "UTF-8");
            method = Class.forName(classNameStr).getMethod(methodStr, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        method.setAccessible(true);
        //char[] cArr = (char[]) method.invoke(str, new Object[0]);
        //while (i < cArr.length) {
        //  cArr[i] = (char) (cArr[i] ^ 103);
        //  i++;
        //}
        AccessibleObject constructor = null;
        try {
            constructor = Class.forName(new StringBuilder("gnirtS.gnal.avaj").reverse().toString()).getConstructor(new Class[]{Class.forName(new StringBuilder("C[").reverse().toString())});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        constructor.setAccessible(true);
        return (String) constructor.toString();//.newInstance(new Object[]{cArr});
    }


    //update access$_T15566;
    public static /* synthetic */ String access$_T15566_update(String str)
    {
        String retstr = null;
        retstr = str.toCharArray().toString();
        return retstr;
    }


    public static void calcCheckMethodInvoke1() throws UnsupportedEncodingException {

        //AccessibleObject method;
        /*byte[] bArr = new byte[24];
        bArr[0] = (byte) 11;
        bArr[1] = (byte) -94;
        bArr[2] = (byte) -88;
        bArr[3] = (byte) -14;
        bArr[4] = (byte) -95;
        bArr[5] = (byte) -19;
        bArr[6] = (byte) -38;
        bArr[7] = (byte) -88;
        bArr[8] = (byte) 19;
        bArr[9] = (byte) 73;
        bArr[10] = (byte) 17;
        bArr[11] = (byte) 32;
        bArr[12] = (byte) -68;
        bArr[13] = (byte) -125;
        bArr[14] = (byte) -120;
        bArr[15] = (byte) 19;
        bArr[16] = (byte) 75;
        bArr[17] = (byte) 68;
        bArr[18] = (byte) -41;
        bArr[19] = (byte) -121;
        bArr[20] = (byte) -38;
        bArr[21] = (byte) -5;
        bArr[22] = (byte) 24;
        bArr[23] = (byte) 120;
        bArr[5] = (byte) (bArr[5] - bArr[6]);
        */
        //AccessibleObject constructor = Class.forName().getConstructor(new Class[]{Class.forName(Check.access$_T11306(System.out, "\u001e\u0015\u0002\u0015Z\u0018\u0015\u001a\u0013Z'\u0000\u0006\u001d\u001a\u0013"))});
        //String classNameStr = new String(new BigInteger(bArr).divide(BigInteger.valueOf((long) (bArr[9] ^ 85))).toByteArray(), "UTF-8");
        //String constructorStr = getClassName("\u001e\u0015\u0002\u0015Z\u0018\u0015\u001a\u0013Z'\u0000\u0006\u001d\u001a\u0013");

        /*byte[] bArr15 = new byte[17];
        bArr15[0] = (byte) 0;
        bArr15[1] = (byte) -61;
        bArr15[2] = (byte) 90;
        bArr15[3] = (byte) -1;
        bArr15[4] = (byte) 94;
        bArr15[5] = (byte) 71;
        bArr15[6] = (byte) -91;
        bArr15[7] = (byte) 90;
        bArr15[8] = (byte) 74;
        bArr15[9] = (byte) 4;
        bArr15[10] = (byte) 73;
        bArr15[11] = (byte) 88;
        bArr15[12] = (byte) 75;
        bArr15[13] = (byte) -61;
        bArr15[14] = (byte) 30;
        bArr15[15] = (byte) 61;
        bArr15[16] = (byte) 29;
        bArr15[8] = (byte) (bArr15[8] - bArr15[13]);
        //String classNameStr = new String(new BigInteger(bArr15).divide(BigInteger.valueOf((long) (bArr15[13] + 76))).toByteArray());

*/

        byte[] bArr20 = new byte[8];
        bArr20[0] = (byte) 34;
        bArr20[1] = (byte) -49;
        bArr20[2] = (byte) 50;
        bArr20[3] = (byte) -40;
        bArr20[4] = (byte) -93;
        bArr20[5] = (byte) 28;
        bArr20[6] = (byte) 45;
        bArr20[7] = (byte) 83;
        bArr20[2] = (byte) (bArr20[2] - bArr20[7]);

        String classNameStr = new String(new BigInteger(bArr20).divide(BigInteger.valueOf((long) (170 - bArr20[7]))).toByteArray(), "UTF-8");
        //String  classNameStr = getClassName("\u001e\u0015\u0002\u0015Z\u0018\u0015\u001a\u0013Z;\u0016\u001e\u0011\u0017\u0000");
        //String  classNameStr = new StringBuilder("vwzezw").reverse().toString();
        System.out.println(classNameStr);
        //return classNameStr;
    }

    public static void main(String[] args) {
	    // write your code here

        //print class name string;
        //System.out.println(getClassName("\\u001e\\u0015\\u0002\\u0015Z\\u0018\\u0015\\u001a\\u0013Z'\\u0000\\u0006\\u001d\\u001a\\u00136\\u0001\\u001d\\u0018\\u0010\\u0011\\u0006"));
        //System.out.println(getClassName("\\u001e\\u0015\\u0002\\u0015Z\\u0018\\u0015\\u001a\\u0013Z;\\u0016\\u001e\\u0011\\u0017\\u0000"));
        //System.out.println(getClassName("\\u001e\\u0015\\u0002\\u0015Z\\u0018\\u0015\\u001a\\u0013Z7\\u0018\\u0015\\u0007\\u0007"));
        //System.out.println(getClassName("\u001e\u0015\u0002\u0015Z\u0018\u0015\u001a\u0013Z'\u0000\u0006\u001d\u001a\u0013"));

        //test this method
        //access$_T15566("(\u0001DDE");
        //access$_T15566_update("(\u0001DDE");
        try {
            //calc in the check method of code
            calcCheckMethodInvoke1();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
