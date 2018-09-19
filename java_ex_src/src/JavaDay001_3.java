import java.util.Scanner;

/**
 * Created by y0nz1 on 2017/4/17.
 * 3.从键盘上输入3个数，求出这三个数字中的最大值，并将最大值输出
 */
public class JavaDay001_3 {
    public static void main(String[] args) {
        System.out.println("请输入3个数：");
        Scanner scanner = new Scanner(System.in);
        int nNumA = scanner.nextInt();
        int nNumB = scanner.nextInt();
        int nNumC = scanner.nextInt();

        int nMax = 0;
        if (nNumA >= nNumB && nNumA >= nNumC)
        {
            nMax = nNumA;
        }
        else if (nNumB >= nNumC && nNumB >= nNumA)
        {
            nMax = nNumB;
        }
        else if (nNumC >= nNumA && nNumC >= nNumB)
        {
            nMax = nNumC;
        }
        else
        {
            System.out.println("无法比较!");
        }
        System.out.println("Max = " + nMax);
    }
}
