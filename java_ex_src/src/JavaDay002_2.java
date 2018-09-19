/**
 * Created by y0nz1 on 2017/4/18.
 * 2.设计一个Dog类，有名字，颜色，年龄等属性，定义构造方法来初始化类的这些属性，
 * 定义方法输出Dog信息，编写应用程序使用Dog类
 */
public class JavaDay002_2 {

    String strName;
    String strColor;
    String strAge;
    public JavaDay002_2(String strName, String strColor, String strAge) {
        this.strName = strName;
        this.strColor = strColor;
        this.strAge = strAge;
    }

    void ShowDog()
    {
        System.out.println("此狗叫" + strName + "," + strColor + "色," + strAge + "岁");
    }

    public static void main(String []args)
    {
        JavaDay002_2 Dog = new JavaDay002_2("旺财", "白", "2");
        Dog.ShowDog();
    }
}
