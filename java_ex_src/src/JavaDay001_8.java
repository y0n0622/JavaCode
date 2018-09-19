import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by y0nz1 on 2017/4/17.
 * 8.键盘输入五位数字的会员卡号：38503
 * 使用“/”和“%”运算符分解获得的会员卡每一位上的数字
 * 将每一位数字求和
 */
public class JavaDay001_8 {
    public static void main(String []args)
    {
        System.out.println("请输入五位数会员卡号：");
        Scanner scanner = new Scanner(System.in);
        int nVIPCard = scanner.nextInt();
        int nW = nVIPCard / 10000;
        int nQ = (nVIPCard / 1000) % 10;
        int nB = (nVIPCard / 100) % 10;
        int nS = (nVIPCard / 10) % 10;
        int nG = nVIPCard % 10;

        System.out.println("会员卡号：" + nVIPCard);
        System.out.println("万位数：" + nW
                + " 千位数：" + nQ
                + " 百位数：" + nB
                + " 十位数：" + nS
                + " 个位数：" + nG);
        System.out.println("会员卡号" + nVIPCard
                + "每位的总和为："
                + (nW + nQ + nB + nS + nG));
    }
}
