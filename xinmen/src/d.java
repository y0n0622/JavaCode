//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

//package com.my.sdk.stpush.common.d;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class d {
    public static List<char[]> a = new ArrayList();
    public static List<byte[]> b = new ArrayList();
    public static String[] c = new String[]{"rMf5HE08tGnPYbydcZUiAgTlkepJqCNsO2xS7R6FLvQ9Va3WoDm4Ku1hwBzIjX+/=", "2WjYJh60fmDru1nXMRSGQsU5OE7avAIL3PiyxolpC9gNdV8zwBcqek4TKHbFtZ+/=", "xtH0aiTugLPBz9NyWb76crAXkwqs1v3C4FpJfoDeM2SUnm8QOdRjKYVhZ5GEIl+/=", "McNirjO3X7pKIBwCFSu2HEZU15ae8xsPVvzJqQdgWA9h0DtlmGoT6yn4YLkbRf+/=", "RO3rB2wpXmcixTd8qCnhQ9FHzofbG4YkyIZEWjDNtLPa5KuA1gsMl0eJV7vUS6+/=", "FufxbzJCOp4kn3yUasH6itX0ejqMow5vE1dKSTZ9lgYWrBAIhN7mQDG8V2RcLP+/=", "30Owz1lWvSRN2e94a5xiTI6Q8LbgytGFuVqjEfhsDkcAPKUHJp7rmYZCoMnBXd+/=", "hgYcPI58nidvW14yVGtlSx9eTKZ3LU0bRB6JmOFqHjX7zfas2ECkoQprDAuNMw+/=", "fCgxyqDnpBdAVuiPOsQ0TK9N8LhkFJe4vlIEwz5H62XGSmRUcW3Z7jYab1oMtr+/=", "UoKWvCdiHtwS5B27PnLaATFy4DYfrIlukNX9bQ3EpZeRqJGx0cj81zhM6smVOg+/=", "qjod0M1Sn9rsUAwtmLkBPx53JOHuGD2hEz6paFN8iIeZbTlg4YXQfKyv7VWRcC+/=", "OdUbEeSBp7yHLoRW82wFDsAZzgXfnQIJCkGt9ach0V4N31rvKqYx6mjTi5luPM+/=", "6tXKe5bwvORkfJmh1VEBFyP30HSlj4u2DqGcdMnxpoWzYIAgUr97QCiNaLTZs8+/=", "MOtoudUjsv1KlEpfCTaRnZrwbceDH5q4JLyB6PXhW9FQxAk7NImSVgY832G0iz+/=", "VRWucGgEofizMdq6PxlS0JX95bmT4pvUetZwjaOK1Ik3rYChDQ8ynNLHsA2B7F+/=", "nOm1vuWUN5KMHRxpFVykI9zALCT8BX3brZj0fedlS6DPoGcws2aJq4EhYQgt7i+/=", "x1sdAYPzyWipREB6GwlojVCXeM9rkUFOSa2NhHq0gfmLZT8KJtnIb4357QcvuD+/=", "KGBAijw9PJHLcD1SNnaEqerCmbzUpl0RhFg7kyoVduT6vtYQ43fW28xOs5IXZM+/=", "Cjli5W2FY8wBHg4OJkvATdhq1Xo0bIpxnuLPZsmafUN9y37tcEG6zMRQKDVeSr+/=", "Y28iFvuXOCoE7fDq3MBkAJrwygbdGeVhHWZNmcln4aT9sxLIS5Q6t0pKPRjz1U+/=", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="};

    static {
        String[] var0 = c;
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            char[] var3 = var0[var2].toCharArray();
            a.add(var3);
            byte[] var4 = new byte[256];

            int var5;
            for(var5 = 0; var5 < 256; ++var5) {
                var4[var5] = (byte)-1;
            }

            int var6 = var3.length;
            int var7 = 0;

            for(int var8 = 0; var7 < var6; var8 = var5) {
                label56: {
                    char var9 = var3[var7];
                    if ((var9 < 'A' || var9 > 'Z') && (var9 < 'a' || var9 > 'z')) {
                        var5 = var8;
                        if (var9 < '0') {
                            break label56;
                        }

                        var5 = var8;
                        if (var9 > '9') {
                            break label56;
                        }
                    }

                    var4[var9] = (byte)((byte)var8);
                    var5 = var8 + 1;
                }

                ++var7;
            }

            var4[43] = (byte)62;
            var4[47] = (byte)63;
            b.add(var4);
        }

    }

    public d() {
    }

    public static String a(String var0) throws IOException {
        int var1;
        if (var0.startsWith("@")) {
            var1 = Integer.parseInt(var0.substring(1, 4));
            var0 = var0.substring(4);
        } else {
            var1 = 20;
        }

        return new String(a(var0.toCharArray(), var1), "UTF-8");
    }

    public static String a(String var0, int var1) {
        if (var1 == -1) {
            return new String(a((byte[])var0.getBytes(), 20));
        } else {
            var1 = (int)(System.currentTimeMillis() % 20L);
            return String.format("@%03d%s", var1, new String(a(var0.getBytes(), var1)));
        }
    }

    public static void a(String[] var0) throws IOException {
        System.out.println(4);
        String var3 = a((String)"\"小米\"", 1);
        PrintStream var1 = System.out;
        StringBuilder var2 = new StringBuilder();
        var2.append("加密：\t");
        var2.append(var3);
        var1.println(var2.toString());
        PrintStream var4 = System.out;
        StringBuilder var5 = new StringBuilder();
        var5.append("解密：\t");
        var5.append(a("@008e3BZJDq7JNVIiIpcpIcI8NCchYK1pE27FHKz4O=="));
        var4.println(var5.toString());
    }

    public static byte[] a(char[] var0, int var1) {
        int var2 = var0.length;
        byte[] var3 = (byte[])b.get(var1);
        var1 = var2;

        int var4;
        for(var4 = 0; var4 < var0.length; var1 = var2) {
            label45: {
                if (var0[var4] <= 255) {
                    var2 = var1;
                    if (var3[var0[var4]] >= 0) {
                        break label45;
                    }
                }

                var2 = var1 - 1;
            }

            ++var4;
        }

        var2 = var1 / 4 * 3;
        var4 = var1 % 4;
        var1 = var2;
        if (var4 == 3) {
            var1 = var2 + 2;
        }

        var2 = var1;
        if (var4 == 2) {
            var2 = var1 + 1;
        }

        byte[] var5 = new byte[var2];
        var4 = 0;
        var2 = 0;
        int var6 = 0;

        for(int var7 = 0; var4 < var0.length; var7 = var1) {
            byte var8;
            if (var0[var4] > 255) {
                var8 = -1;
            } else {
                var8 = var3[var0[var4]];
            }

            PrintStream var9 = System.out;
            StringBuilder var10 = new StringBuilder();
            var10.append(Integer.toString(var8));
            var10.append("|");
            var9.printf(var10.toString());
            int var11 = var2;
            int var12 = var6;
            var1 = var7;
            if (var8 >= 0) {
                var7 += 6;
                var6 = var6 << 6 | var8;
                var11 = var2;
                var12 = var6;
                var1 = var7;
                if (var7 >= 8) {
                    var1 = var7 - 8;
                    var5[var2] = (byte)((byte)(var6 >> var1 & 255));
                    var11 = var2 + 1;
                    var12 = var6;
                }
            }

            ++var4;
            var2 = var11;
            var6 = var12;
        }

        System.out.println("");
        if (var2 == var5.length) {
            return var5;
        } else {
            StringBuilder var13 = new StringBuilder();
            var13.append("Miscalculated data length (wrote ");
            var13.append(var2);
            var13.append(" instead of ");
            var13.append(var5.length);
            var13.append(")");
            throw new Error(var13.toString());
        }
    }

    public static char[] a(byte[] var0, int var1) {
        char[] var2 = new char[(var0.length + 2) / 3 * 4];
        char[] var3 = (char[])a.get(var1);
        int var4 = 0;

        for(var1 = 0; var4 < var0.length; var1 += 4) {
            int var5 = (var0[var4] & 255) << 8;
            int var6 = var4 + 1;
            int var7 = var0.length;
            boolean var8 = true;
            boolean var10;
            if (var6 < var7) {
                var5 |= var0[var6] & 255;
                var10 = true;
            } else {
                var10 = false;
            }

            var5 <<= 8;
            var6 = var4 + 2;
            if (var6 < var0.length) {
                var5 |= var0[var6] & 255;
            } else {
                var8 = false;
            }

            byte var9 = 64;
            int var11;
            if (var8) {
                var11 = var5 & 63;
            } else {
                var11 = 64;
            }

            var2[var1 + 3] = (char)var3[var11];
            var11 = var5 >> 6;
            var5 = var9;
            if (var10) {
                var5 = var11 & 63;
            }

            var2[var1 + 2] = (char)var3[var5];
            var7 = var11 >> 6;
            var2[var1 + 1] = (char)var3[var7 & 63];
            var2[var1 + 0] = (char)var3[var7 >> 6 & 63];
            var4 += 3;
        }

        return var2;
    }
}
