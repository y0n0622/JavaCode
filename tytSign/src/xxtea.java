import javafx.scene.web.WebView;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/* compiled from: XXTEA */
public class xxtea {
    private xxtea() {
    }
    public static final int NORMAL_MODE_ALPHA = 255;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        return a(a(a(bArr, false), a(bArr2, false)), true);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        return a(b(a(bArr, true), a(bArr2, false)), false);
    }

    public static int[] a(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length < 1) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i = iArr[length];
        int i2 = iArr[0];
        for (int i3 = ((52 / (length + 1)) + 6) * -1640531527; i3 != 0; i3 -= -1640531527) {
            int i4 = (i3 >>> 2) & 3;
            int i5 = i2;
            int i6 = length;
            while (i6 > 0) {
                int i7 = iArr[i6 - 1];
                i5 = iArr[i6] - (((i5 ^ i3) + (i7 ^ iArr2[(i6 & 3) ^ i4])) ^ (((i7 >>> 5) ^ (i5 << 2)) + ((i5 >>> 3) ^ (i7 << 4))));
                iArr[i6] = i5;
                i6--;
            }
            int i8 = iArr[length];
            i2 = iArr[0] - ((((i8 >>> 5) ^ (i5 << 2)) + ((i5 >>> 3) ^ (i8 << 4))) ^ ((i5 ^ i3) + (iArr2[(i6 & 3) ^ i4] ^ i8)));
            iArr[0] = i2;
        }
        return iArr;
    }

    public static int[] b(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length < 1) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i = iArr[length];
        int i2 = iArr[0];
        int i3 = (52 / (length + 1)) + 6;
        int i4 = i;
        int i5 = 0;
        while (true) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                return iArr;
            }
            i5 -= 1640531527;
            int i7 = (i5 >>> 2) & 3;
            int i8 = i4;
            int i9 = 0;
            while (i9 < length) {
                int i10 = i9 + 1;
                int i11 = iArr[i10];
                i8 = ((((i8 >>> 5) ^ (i11 << 2)) + ((i11 >>> 3) ^ (i8 << 4))) ^ ((i11 ^ i5) + (i8 ^ iArr2[(i9 & 3) ^ i7]))) + iArr[i9];
                iArr[i9] = i8;
                i9 = i10;
            }
            int i12 = iArr[0];
            i4 = iArr[length] + ((((i8 >>> 5) ^ (i12 << 2)) + ((i12 >>> 3) ^ (i8 << 4))) ^ ((i12 ^ i5) + (iArr2[i7 ^ (i9 & 3)] ^ i8)));
            iArr[length] = i4;
            i3 = i6;
        }
    }

    private static int[] a(byte[] bArr, boolean z) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z) {
            iArr = new int[(length + 1)];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        for (int i = 0; i < length2; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & 255) << ((i & 3) << 3));
        }
        return iArr;
    }

    private static byte[] a(int[] iArr, boolean z) {
        int i;
        int length = iArr.length << 2;
        if (z) {
            i = iArr[iArr.length - 1];
            if (i > length) {
                return null;
            }
        } else {
            i = length;
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((iArr[i2 >>> 2] >>> ((i2 & 3) << 3)) & NORMAL_MODE_ALPHA);
        }
        return bArr;
    }
    public static void main(String[] args) {
        try {
            //这里base64要按照android里面的base64计算
            String ret = Base64.getEncoder().encodeToString(xxtea.b("{\"Password\":\"845F9635A77714C5FA2B0CB830AC6FDD\",\"Phone\":\"13566668888\"}".getBytes("UTF-8"), "8Z74UGrRMDSttcQNlJBd1UmJGBvBT2g2".getBytes("UTF-8")));
            System.out.println(ret);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}