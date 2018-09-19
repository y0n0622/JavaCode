/**
 * Created by y0nz1 on 2017/4/19.
 * 2.编写一个程序测试异常，
 * 该类提供一个输入整数的方法，然后使用这个方法先后输入
 * 两个整数，再用第一个整数除以第二个整数，当第一个整数为0是抛出异常
 */
class ExceptionNum
{
    void inPutNum(int nNumA, int nNumB)
    {
        try {

            int nNumC =  nNumA / nNumB;
        }
        catch (Exception e)
        {
            System.out.println("发生异常：" + e.getMessage());
            return;
        }

        return;
    }
}

public class JavaDay003_2 {
    public static void main(String []args)
    {
        ExceptionNum en = new ExceptionNum();
        en.inPutNum(1, 0);
    }
}
