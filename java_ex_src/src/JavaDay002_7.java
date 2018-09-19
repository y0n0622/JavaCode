/**
 * Created by y0nz1 on 2017/4/18.
 * 7.定义一个接口，并使用匿名类部类方式创建接口实例
 */
interface InterFace
{
    abstract void fun();
}

class ImpClass implements InterFace
{

    @Override
    public void fun() {
        System.out.println("匿名内部类1");
    }
}

public class JavaDay002_7{

    public static void main(String []args)
    {
        InterFace i = new ImpClass()
        {
            @Override
            public void fun() {
                super.fun();
                System.out.println("匿名内部类2");
            }
        };
        i.fun();
    }
}
