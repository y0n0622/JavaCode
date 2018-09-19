/**
 * Created by y0nz1 on 2017/4/18.
 * 3.定义一个数组，它可以存储一个矩形，三角形，圆形
 * 一个双精度数或一个整数
 */
public class JavaDay002_3 {
    int Rectangle(int length, int wight)
    {
        return length * wight;
    }
    int Trangle(int aSide, int bSide, int cSide)
    {
        int s = (aSide + bSide + cSide) / 2;
        double area = (double) (s * (s - aSide) * (s - bSide) * (s - cSide));
        return (int) Math.pow(area, 0.5);
    }
    int Round(int redis)
    {
        return (int) (redis * redis * 3.14);
    }
    int IntNumber(int nNum)
    {
        return nNum;
    }
    public static void main(String []args)
    {
        JavaDay002_3 array = new JavaDay002_3();

        System.out.println("矩形：" + array.Rectangle(3, 4)
                + " 三角形：" + array.Trangle(3, 4, 5)
                + " 圆：" + array.Round(2)
                + " 整数：" + array.IntNumber(5));
    }
}
