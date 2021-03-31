import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
public class d {

//        public static final int a = 76;
        public static  byte[] b;
        public static  byte[] c;
        public static  byte[] d;
        private final int e;
        private final byte[] f;
        private final int g;
        private final int h;
        private byte[] i;
        public int j;
        private int k;
//        private int l;
        private int m;
        private boolean n;
        private int o;
        private static final char[] p;

        static {
            b = new byte[]{13, 10};
            c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 0x4F, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 120, 0x79, 0x7A, 0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 0x2F};
            d = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 0x3F, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 0x1F, 0x20, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 0x2F, 0x30, 49, 50, 51};
            p = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        }

        public d() {
            this(76, b);
        }

//        public d(int arg2) {
//            this(arg2, d.b);
//        }

        public d(int arg4, byte[] arg5) {
            String v4;
            this.e = arg4;
            this.f = new byte[arg5.length];
            System.arraycopy(((Object)arg5), 0, this.f, 0, arg5.length);
            this.h = arg4 > 0 ? arg5.length + 4 : 4;
            this.g = this.h - 1;
            if(!j(arg5)) {
                return;
            }

            try {
                v4 = new String(arg5, "UTF-8");
            }
            catch(UnsupportedEncodingException unused_ex) {
                v4 = new String(arg5);
            }

            throw new IllegalArgumentException("lineSeperator must not contain base64 characters: [" + v4 + "]");
        }
        public static boolean j(byte[] arg3) {
            int v1;
            for(v1 = 0; v1 < arg3.length; ++v1) {
                if(a(arg3[v1])) {
                    return true;
                }
            }

            return false;
        }
        public static boolean a(byte arg1) {
            return arg1 == 61 || arg1 >= 0 && arg1 < d.length && d[arg1] != -1;
        }

//        public static final String a(String arg3) {
//            try {
//                return new String(d.b(arg3.getBytes("UTF-8"), false));
//            }
//            catch(UnsupportedEncodingException v3) {
//                System.err.println("Base64 encoding error: " + v3.getMessage());
//                v3.printStackTrace();
//                return null;
//            }
//        }

//        public static boolean a(byte arg1) {
//            return arg1 == 61 || arg1 >= 0 && arg1 < d.d.length && d.d[arg1] != -1;
//        }

//        public static boolean a(byte[] arg3) {
//            int v1;
//            for(v1 = 0; v1 < arg3.length; ++v1) {
//                if(!d.a(arg3[v1]) && !d.b(arg3[v1])) {
//                    return 0;
//                }
//            }
//
//            return 1;
//        }

//        public static byte[] a(BigInteger arg1) {
//            if(arg1 != null) {
//                return d.a(d.b(arg1), false);
//            }
//
//            throw new NullPointerException("encodeInteger called with null parameter");
//        }

//        public static byte[] a(byte[] arg11, boolean arg12) {
//            if(arg11 != null && arg11.length != 0) {
//                d v1 = arg12 ? new d() : new d(0);
//                long v2 = (long)(arg11.length * 4 / 3);
//                long v6 = v2 % 4L;
//                if(v6 != 0L) {
//                    v2 += 4L - v6;
//                }
//
//                if(arg12) {
//                    v2 += (v2 + 76L - 1L) / 76L * ((long)d.b.length);
//                }
//
//                if(v2 <= 0x7FFFFFFFL) {
//                    byte[] v12 = new byte[((int)v2)];
//                    v1.b(v12, 0, v12.length);
//                    v1.c(arg11, 0, arg11.length);
//                    v1.c(arg11, 0, -1);
//                    if(v1.i != v12) {
//                        v1.a(v12, 0, v12.length);
//                    }
//
//                    return v12;
//                }
//
//                throw new IllegalArgumentException("Input array too big, output array would be bigger than Integer.MAX_VALUE=2147483647");
//            }
//
//            return arg11;
//        }

        int a(byte[] arg4, int arg5, int arg6) {
            if(this.i != null) {
                int v6 = Math.min(this.b(), arg6);
                if(this.i != arg4) {
                    System.arraycopy(this.i, this.k, ((Object)arg4), arg5, v6);
                    this.k += v6;
                    if(this.k < this.j) {
                        return v6;
                    }

                    this.i = null;
                    return v6;
                }

                this.i = null;
                return v6;
            }

            return this.n ? -1 : 0;
        }

//        boolean a() {
//            return this.i != null;
//        }

//        private static boolean b(byte arg1) {
//            if(arg1 != 13 && arg1 != 0x20) {
//                switch(arg1) {
//                    case 9:
//                    case 10: {
//                        return 1;
//                    }
//                    default: {
//                        return 0;
//                    }
//                }
//            }
//
//            return 1;
//        }

//        static byte[] b(BigInteger arg5) {
//            int v0 = arg5.bitLength() + 7 >> 3 << 3;
//            byte[] v1 = arg5.toByteArray();
//            if(arg5.bitLength() % 8 != 0 && arg5.bitLength() / 8 + 1 == v0 / 8) {
//                return v1;
//            }
//
//            int v2 = 0;
//            int v4 = v1.length;
//            if(arg5.bitLength() % 8 == 0) {
//                --v4;
//                v2 = 1;
//            }
//
//            int v0_1 = v0 / 8;
//            byte[] v0_2 = new byte[v0_1];
//            System.arraycopy(((Object)v1), v2, ((Object)v0_2), v0_1 - v4, v4);
//            return v0_2;
//        }

//        public static byte[] b(byte[] arg1) {
//            return d.a(arg1, false);
//        }

//        public static final char[] b(byte[] arg17, boolean arg18) {
//            byte[] v0 = arg17;
//            int v2 = 0;
//            int v3 = v0 == null ? 0 : v0.length;
//            if(v3 == 0) {
//                return new char[0];
//            }
//
//            int v4 = v3 / 3 * 3;
//            int v5 = v3 - 1;
//            int v6 = v5 / 3 + 1 << 2;
//            int v6_1 = v6 + arg18 ? (v6 - 1) / 76 << 1 : 0;
//            char[] v8 = new char[v6_1];
//            int v9 = 0;
//            int v10 = 0;
//            int v11 = 0;
//            while(v9 < v4) {
//                int v13 = v9 + 1;
//                int v14 = v13 + 1;
//                int v13_1 = v14 + 1;
//                int v9_1 = (v0[v9] & 0xFF) << 16 | (v0[v13] & 0xFF) << 8 | v0[v14] & 0xFF;
//                int v14_1 = v10 + 1;
//                v8[v10] = d.p[v9_1 >>> 18 & 0x3F];
//                int v10_1 = v14_1 + 1;
//                v8[v14_1] = d.p[v9_1 >>> 12 & 0x3F];
//                int v14_2 = v10_1 + 1;
//                v8[v10_1] = d.p[v9_1 >>> 6 & 0x3F];
//                v10 = v14_2 + 1;
//                v8[v14_2] = d.p[v9_1 & 0x3F];
//                if(arg18) {
//                    ++v11;
//                    if(v11 == 19 && v10 < v6_1 - 2) {
//                        int v9_2 = v10 + 1;
//                        v8[v10] = '\r';
//                        v10 = v9_2 + 1;
//                        v8[v9_2] = '\n';
//                        v11 = 0;
//                    }
//                }
//
//                v9 = v13_1;
//            }
//
//            int v3_1 = v3 - v4;
//            if(v3_1 > 0) {
//                int v1 = (v0[v4] & 0xFF) << 10;
//                if(v3_1 == 2) {
//                    v2 = (v0[v5] & 0xFF) << 2;
//                }
//
//                int v0_1 = v1 | v2;
//                v8[v6_1 - 4] = d.p[v0_1 >> 12];
//                v8[v6_1 - 3] = d.p[v0_1 >>> 6 & 0x3F];
//                v8[v6_1 - 2] = v3_1 == 2 ? d.p[v0_1 & 0x3F] : '=';
//                v8[v6_1 - 1] = '=';
//            }
//
//            return v8;
//        }

        int b() {
            return this.i == null ? 0 : this.j - this.k;
        }

        void b(byte[] arg2, int arg3, int arg4) {
            if(arg2 != null && arg2.length == arg4) {
                this.i = arg2;
                this.j = arg3;
                this.k = arg3;
            }
        }

        private void c() {
            if(this.i == null) {
                this.i = new byte[0x2000];
                this.j = 0;
                this.k = 0;
                return;
            }

            byte[] v0 = new byte[this.i.length * 2];
            System.arraycopy(this.i, 0, ((Object)v0), 0, this.i.length);
            this.i = v0;
        }

//        public static byte[] c(byte[] arg1) {
//            return d.a(arg1, true);
//        }

//        void c(byte[] arg8, int arg9, int arg10) {
//            if(this.n) {
//                return;
//            }
//
//            if(arg10 < 0) {
//                this.n = true;
//                if(this.i == null || this.i.length - this.j < this.h) {
//                    this.c();
//                }
//
//                switch(this.m) {
//                    case 1: {
//                        byte[] v8_4 = this.i;
//                        int v10_4 = this.j;
//                        this.j = v10_4 + 1;
//                        v8_4[v10_4] = d.c[this.o >> 2 & 0x3F];
//                        byte[] v8_5 = this.i;
//                        int v10_5 = this.j;
//                        this.j = v10_5 + 1;
//                        v8_5[v10_5] = d.c[this.o << 4 & 0x3F];
//                        byte[] v8_6 = this.i;
//                        int v10_6 = this.j;
//                        this.j = v10_6 + 1;
//                        v8_6[v10_6] = 61;
//                        byte[] v8_7 = this.i;
//                        int v10_7 = this.j;
//                        this.j = v10_7 + 1;
//                        v8_7[v10_7] = 61;
//                        break;
//                    }
//                    case 2: {
//                        byte[] v8 = this.i;
//                        int v10 = this.j;
//                        this.j = v10 + 1;
//                        v8[v10] = d.c[this.o >> 10 & 0x3F];
//                        byte[] v8_1 = this.i;
//                        int v10_1 = this.j;
//                        this.j = v10_1 + 1;
//                        v8_1[v10_1] = d.c[this.o >> 4 & 0x3F];
//                        byte[] v8_2 = this.i;
//                        int v10_2 = this.j;
//                        this.j = v10_2 + 1;
//                        v8_2[v10_2] = d.c[this.o << 2 & 0x3F];
//                        byte[] v8_3 = this.i;
//                        int v10_3 = this.j;
//                        this.j = v10_3 + 1;
//                        v8_3[v10_3] = 61;
//                    }
//                }
//
//                if(this.e > 0) {
//                    System.arraycopy(this.f, 0, this.i, this.j, this.f.length);
//                    this.j += this.f.length;
//                    return;
//                }
//            }
//            else {
//                int v2 = arg9;
//                int v9 = 0;
//                while(v9 < arg10) {
//                    if(this.i == null || this.i.length - this.j < this.h) {
//                        this.c();
//                    }
//
//                    int v3 = this.m + 1;
//                    this.m = v3;
//                    this.m = v3 % 3;
//                    int v3_1 = v2 + 1;
//                    int v2_1 = arg8[v2];
//                    if(v2_1 < 0) {
//                        v2_1 += 0x100;
//                    }
//
//                    this.o = (this.o << 8) + v2_1;
//                    if(this.m == 0) {
//                        byte[] v2_2 = this.i;
//                        int v4 = this.j;
//                        this.j = v4 + 1;
//                        v2_2[v4] = d.c[this.o >> 18 & 0x3F];
//                        byte[] v2_3 = this.i;
//                        int v4_1 = this.j;
//                        this.j = v4_1 + 1;
//                        v2_3[v4_1] = d.c[this.o >> 12 & 0x3F];
//                        byte[] v2_4 = this.i;
//                        int v4_2 = this.j;
//                        this.j = v4_2 + 1;
//                        v2_4[v4_2] = d.c[this.o >> 6 & 0x3F];
//                        byte[] v2_5 = this.i;
//                        int v4_3 = this.j;
//                        this.j = v4_3 + 1;
//                        v2_5[v4_3] = d.c[this.o & 0x3F];
//                        this.l += 4;
//                        if(this.e > 0 && this.e <= this.l) {
//                            System.arraycopy(this.f, 0, this.i, this.j, this.f.length);
//                            this.j += this.f.length;
//                            this.l = 0;
//                        }
//                    }
//
//                    ++v9;
//                    v2 = v3_1;
//                }
//            }
//        }

        public void d(byte[] arg6, int arg7, int arg8) {
            if(this.n) {
                return;
            }

            if(arg8 < 0) {
                this.n = true;
            }

            int v1 = 0;
            while(v1 < arg8) {
                if(this.i == null || this.i.length - this.j < this.g) {
                    this.c();
                }

                int v2 = arg7 + 1;
                int v7 = arg6[arg7];
                if(v7 == 61) {
                    this.o <<= 6;
                    switch(this.m) {
                        case 2: {
                            this.o <<= 6;
                            byte[] v6_2 = this.i;
                            int v7_3 = this.j;
                            this.j = v7_3 + 1;
                            v6_2[v7_3] = (byte)(this.o >> 16 & 0xFF);
                            break;
                        }
                        case 3: {
                            byte[] v6 = this.i;
                            int v7_1 = this.j;
                            this.j = v7_1 + 1;
                            v6[v7_1] = (byte)(this.o >> 16 & 0xFF);
                            byte[] v6_1 = this.i;
                            int v7_2 = this.j;
                            this.j = v7_2 + 1;
                            v6_1[v7_2] = (byte)(this.o >> 8 & 0xFF);
                        }
                    }

                    this.n = true;
                    return;
                }

                if(v7 >= 0 && v7 < d.length) {
                    int v7_4 = d[v7];
                    if(v7_4 >= 0) {
                        int v3 = this.m + 1;
                        this.m = v3;
                        this.m = v3 % 4;
                        this.o = (this.o << 6) + v7_4;
                        if(this.m == 0) {
                            byte[] v7_5 = this.i;
                            int v3_1 = this.j;
                            this.j = v3_1 + 1;
                            v7_5[v3_1] = (byte)(this.o >> 16 & 0xFF);
                            byte[] v7_6 = this.i;
                            int v3_2 = this.j;
                            this.j = v3_2 + 1;
                            v7_6[v3_2] = (byte)(this.o >> 8 & 0xFF);
                            byte[] v7_7 = this.i;
                            int v3_3 = this.j;
                            this.j = v3_3 + 1;
                            v7_7[v3_3] = (byte)(this.o & 0xFF);
                        }
                    }
                }

                ++v1;
                arg7 = v2;
            }
        }

//        public byte[] d(byte[] arg1) {
//            return d.e(arg1);
//        }
//
//        public static byte[] e(byte[] arg4) {
//            if(arg4 != null && arg4.length != 0) {
//                d v0 = new d();
//                v0.b(new byte[((int)(((long)(arg4.length * 3 / 4))))], 0, new byte[((int)(((long)(arg4.length * 3 / 4))))].length);
//                v0.d(arg4, 0, arg4.length);
//                v0.d(arg4, 0, -1);
//                byte[] v4 = new byte[v0.j];
//                v0.a(v4, 0, v4.length);
//                return v4;
//            }
//
//            return arg4;
//        }
//
//        static byte[] f(byte[] arg6) {
//            byte[] v0 = new byte[arg6.length];
//            int v2 = 0;
//            int v3 = 0;
//            while(v2 < arg6.length) {
//                int v4 = arg6[v2];
//                if(v4 != 13 && v4 != 0x20) {
//                    switch(v4) {
//                        case 9:
//                        case 10: {
//                            break;
//                        }
//                        default: {
//                            v0[v3] = arg6[v2];
//                            ++v3;
//                        }
//                    }
//                }
//
//                ++v2;
//            }
//
//            byte[] v6 = new byte[v3];
//            System.arraycopy(((Object)v0), 0, ((Object)v6), 0, v3);
//            return v6;
//        }
//
//        static byte[] g(byte[] arg6) {
//            byte[] v0 = new byte[arg6.length];
//            int v2 = 0;
//            int v3 = 0;
//            while(v2 < arg6.length) {
//                if(d.a(arg6[v2])) {
//                    v0[v3] = arg6[v2];
//                    ++v3;
//                }
//
//                ++v2;
//            }
//
//            byte[] v6 = new byte[v3];
//            System.arraycopy(((Object)v0), 0, ((Object)v6), 0, v3);
//            return v6;
//        }
//
//        public byte[] h(byte[] arg2) {
//            return d.a(arg2, false);
//        }
//
//        public static BigInteger i(byte[] arg2) {
//            return new BigInteger(1, d.e(arg2));
//        }
//
//        public boolean j(byte[] arg3) {
//            int v1;
//            for(v1 = 0; v1 < arg3.length; ++v1) {
//                if(d.a(arg3[v1])) {
//                    return 1;
//                }
//            }
//
//            return 0;
//        }
}




