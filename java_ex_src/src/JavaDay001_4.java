import com.sun.webkit.BackForwardList;

import java.util.Scanner;

/**
 * Created by y0nz1 on 2017/4/17.
 * 4.编写万年历小程序
 * 输出结果：
 * 请输入年：2016
 * 请输入月：6
 * 2016年非润年
 * 2016年6月份的天数是30
 */
public class JavaDay001_4 {
    public static void main(String[] args) {
        System.out.println("请输入年：");
        Scanner scanner = new Scanner(System.in);
        int nYear = scanner.nextInt();
        System.out.println("请输入月：");
        int nMounth = scanner.nextInt();
        int nflag = 0;
        if (nYear % 4 == 0)
        {
            if (nYear % 100 == 0)
            {
                if (nYear % 400 == 0)
                {
                    nflag = 1;
                    System.out.println(nYear + "年是润年");
                }
                else
                {
                    System.out.println(nYear + "年不是润年");
                }
            }
            else
            {
                nflag = 1;
                System.out.println(nYear + "年不是润年");
            }
        }
        else
        {
            System.out.println(nYear + "年不是润年");
        }

        //判断2016年月份的天数
        if (nMounth == 1
                || nMounth == 3
                || nMounth == 5
                || nMounth == 7
                || nMounth == 8
                || nMounth == 10
                || nMounth == 12 )
        {
            System.out.println(nYear + "年" + nMounth + "月份的天数是：31" );
        }
        else if (nMounth == 4
                || nMounth == 6
                || nMounth == 9
                || nMounth == 11)
        {
            System.out.println(nYear + "年" + nMounth + "月份的天数是：30" );
        }
        else
        {
            if (nflag == 0)
            {
                System.out.println(nYear + "年" + nMounth + "月份的天数是：28" );
            }
            else
            {
                System.out.println(nYear + "年" + nMounth + "月份的天数是：29" );
            }
        }
    }
}
