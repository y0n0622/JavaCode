/**
 * Created by y0nz1 on 2017/4/19.
 * 3.完成下列要求，写一程序进行异常验证
 * 1）定义一个继承于Exception类的异常类
 * InsufficientFundException
 * 2)定义一个银行账户类Account，包括
 * 属性：账户名称，name，String
 * 存款余额balance，double
 * 构造函数：Account(String name, double balance);
 * 取款操作：void withdrawal(double amount),若大于余额则抛出异常
 */
class InsufficientFundException extends Exception
{

}

class Account
{
    String name;
    double balance;
    public Account(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
    }

    void withdrawal(double amount) throws InsufficientFundException
    {
        if (amount > this.balance) {
            throw new InsufficientFundException();
        }
        else
        {
            this.balance = this.balance - amount;
            System.out.println("取款成功！\n余额：" + this.balance);
        }
    }
}
public class JavaDay003_3 {
    public static void main(String []args)
    {
        try {
            Account ac = new Account("y0n", 50);
            ac.withdrawal(40);
            ac.withdrawal(40);
        }
        catch (InsufficientFundException e)
        {
            System.out.print("余额不足!");
        }
    }
}
