import java.util.Scanner;
/**
 * Created by y0nz1 on 2017/4/17.
 * 6.为指定成绩加分，直到分数大于等于60为止，
 * 输出加分前和加分后的成绩，并统计加分的次数
 * 输出结果：
 * 加分前成绩：55
 * 加分后成绩：60
 * 共加了5次！
 */
public class JavaDay001_6 {
    public static void main(String [] args)
    {
        System.out.println("请指定分数：");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        int nCount = 0;
        if (score < 60)
        {
            int temp = score;
            while (temp < 60)
            {
                temp++;
                nCount++;
            }
            System.out.println("加分前成绩：" + score);
            System.out.println("加分后成绩：" + temp);
            System.out.println("共加了" + nCount + "次!");
        }
        else
        {
            System.out.println("不用加分!");
        }
    }
}
