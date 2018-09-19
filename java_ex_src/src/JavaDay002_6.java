/**
 * Created by y0nz1 on 2017/4/18.
 * 6.建立一个人类(Penson)和学生类(Student),功能如下：
 * Person中包含4个保护型成员姓名（name）,地址（addr）
 * 性别（sex），年龄（age）,用一个4个参数的构造函数
 * 初始化这4个属性，以及一个输出方法显示i这4个属性
 * Student类继承Person类，并增加输出成员数学（math）
 * 英语（english）成绩，用一个6参数构造函数初始化属性，
 * 和重写输出方法用于显示6个属性。
 */
class Penson
{
    protected String name;
    protected String addr;
    protected String sex;
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void ShowItems()
    {
        System.out.println("姓名：" + getName()
                + " 地址：" + getAddr()
                + " 性别：" + getSex()
                + " 年龄：" + getAge());
    }
}

class Student extends Penson
{
    int mathScore;
    int englishScore;

    public Student(String name, String addr, String sex, int age, int mathScore, int englishScore) {
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.name = name;
        this.addr = addr;
        this.sex = sex;
        this.age = age;
    }

    void ShowItems()
    {
        System.out.println("姓名：" + getName()
                + " 地址：" + getAddr()
                + " 性别：" + getSex()
                + " 年龄：" + getAge()
                + " 数学成绩：" + mathScore
                + " 英语成绩：" + englishScore);
    }
}
public class JavaDay002_6 {
    public static void main(String []args)
    {
        Student stu = new Student("y0n", "Beijing", "boy", 5, 80, 90);
        stu.ShowItems();
    }
}
