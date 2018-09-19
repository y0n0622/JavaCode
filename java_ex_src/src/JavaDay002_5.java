/**
 * Created by y0nz1 on 2017/4/18.
 * 5.编译3个接口，他们之间具有继承关系，
 * 每个接口中包含一个常量，通过一个类继承这些接口
 * 通过显示接口中的常量字符串类展示这些接口的继承性
 */
interface InterfaceA
{
    public final String InterfaceA = "InterfaceA";
    abstract void ShowStringA();
}
interface InterfaceB extends InterfaceA
{
    public final String InterfaceB = "InterfaceB";
    abstract void ShowStringB();
}
interface InterfaceC extends InterfaceB
{
    public final String InterfaceC = "InterfaceC";
    abstract void ShowStringC();
}
public class JavaDay002_5 implements InterfaceA, InterfaceB, InterfaceC{
    @Override
    public void ShowStringA() {
        System.out.println(InterfaceA);
    }

    @Override
    public void ShowStringB() {
        System.out.println(InterfaceB);
    }

    @Override
    public void ShowStringC() {
        System.out.println(InterfaceC);
    }

    public static void main(String []args)
    {
        JavaDay002_5 Interface = new JavaDay002_5();
        Interface.ShowStringA();
        Interface.ShowStringB();
        Interface.ShowStringC();
    }
}
