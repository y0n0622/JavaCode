import java.util.Scanner;

/**
 * Created by y0nz1 on 2017/4/17.
 * 5.从键盘输入学生学号：20161103（2016年+11期+03号）
 * 使用“/”和“%”云算符分解学生学号获得年份期数和序号
 * 并且输出：
 * 学生学号：20161103
 * 学生入学年份：2016年
 * 学生期数：11期
 * 学生序号：03号
 */
public class JavaDay001_5 {
    public static void main(String [] args)
    {
        System.out.println("请输入学生学号：");
        Scanner scanner = new Scanner(System.in);
        int nStudent = scanner.nextInt();
        int nStudentYear = nStudent / 10000;
        int nStudentTime = (nStudent / 100) % nStudentYear;
        int nStudentId = nStudent % (nStudent / 100);
        System.out.println("学生学号:" + nStudent);
        System.out.println("学生入学年份:" + nStudentYear + "年");
        System.out.println("学生期数:" + nStudentTime + "期");
        System.out.println("学生序号:" + nStudentId + "号");
    }
}
