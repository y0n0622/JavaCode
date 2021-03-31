import java.security.MessageDigest;
import java.util.Random;
public class Main {
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
//        System.out.println(signRequest("siQEsRC16TI9xSOy7pK9rAPK"));
        int ret = sub_804DFC0(6);
        //登录
//        System.out.println(MD5("cellPhone=18613896223&certificateType=0&channelCode=0&cid=23e4100f030d9abb62064ba0e3429c79&clientId=a249ccdbbce599bb6cdd0fddafa61456&clientSign=2&clientVersion=5965&deviceId=100d855909cbb9ecaa5&osVersion=7.1.2&password=f405aaa4584fdba9997ec51d1e06691e&phoneType=AOSP on msm8996&ttkn=2020.07.27-14:40:421345~opo-4%"));
        //找货大厅
//        System.out.println(MD5("clientId=a249ccdbbce599bb6cdd0fddafa61456&clientSign=2&clientVersion=5965&numberType=0&osVersion=7.1.2&querySign=0&queryType=1&sortType=1&startCoord=367.21,4305.26&startDistance=300&startLonLat=115.47,38.87&ticket=42df67752295cc0593f8286002b5ccbc&ttkn=2020.07.27-14:58:53&userId=4559771345~opo-4%"));//sign=ceb89733401fc1ed14463b20241d4093

        //单个详情页
//        System.out.println(MD5("clientId=a249ccdbbce599bb6cdd0fddafa61456&clientSign=2&clientVersion=5965&detailType=1&goodsId=100314015&osVersion=7.1.2&ticket=42df67752295cc0593f8286002b5ccbc&ttkn=2020.07.27-15:00:20&userId=4559771345~opo-4%"));//&sign=96ae611faace0f7d05c0dfa937c7d520

        //获取手机号
//        System.out.println(MD5("clientId=a249ccdbbce599bb6cdd0fddafa61456&clientSign=2&clientVersion=5965&goodId=53357997&isNeedPhone=2&linkUserId=0&moduleType=3&osVersion=7.1.2&path=findGoodsPage2openGoodsItem_goodsDetailPage2callPhone&ticket=42df67752295cc0593f8286002b5ccbc&ttkn=2020.07.27-15:02:25&userId=4559771345~opo-4%"));
    }
    public static final String MD5(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            char[] cArr2 = new char[(16 * 2)];
            int i = 0;
            for (byte b : instance.digest()) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getRandomString(int i) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    public static String signRequest(String str) {
        StringBuilder sb = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb.append(currentTimeMillis);
        sb.append(str);
        sb2.append(MD5(sb.toString()).toLowerCase());
        sb2.append(',');
        sb2.append(currentTimeMillis);
        return sb2.toString();
    }

    public int[] sub_804E570(int[] a1, byte a2, int len){
        int [] result = a1;
        int v3 = 0;
        if (len != 0){
            do {
                result[v3] = v3+a2;
                ++v3;
            }while (v3 != len);
        }
        return result;
    }
    public static int sub_804DFC0(int a1){
//        int *v1_arry; // ecx
        byte [] v1_arry = new byte[2*a1];
        int result; // eax
        int  v3_key; // bp
        int v4_i = 0; // edx
        int v5_key_left_move_8; // edi
        int v6_key_left_move_16; // esi
        int v7; // eax
        char v8; // [esp+0h] [ebp-2Ch]


        result = 0x0DEADBEEF;
        if ( v1_arry[v4_i + 2] == 0 )
        {
            v3_key = 0x0DEADBEEF;
            v4_i = 0;
            v5_key_left_move_8 = 0x0DEADBEEF >> 8;
            v8 = (0x0DEAD);
            v6_key_left_move_16 = 0x0DEADBEEF >> 16;
            do
            {
                (v1_arry[v4_i]) ^= v3_key;
                (v1_arry[v4_i]) ^= v5_key_left_move_8;
                (v1_arry[v4_i]) ^= v6_key_left_move_16;
                v7 = v4_i++;
                v1_arry[v7] ^= v8;
                result = v1_arry[1] & 0xFFFF;
            }
            while ( result > v4_i );
        }
        return result;

    }

}
