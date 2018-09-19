import com.sun.org.apache.bcel.internal.generic.PUSH;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by y0nz1 on 2017/4/19.
 * 1.声明一个图书类，其数据成员为书名，编号，作者
 * 出版社名，书价，并拥有静态数据册数，记录图书馆总册数，实现简单的添加
 * 查询删除
 * 使用ArrayList类保存数据，查询规则自定
 */
class Book
{
    String strName;
    static int nID;
    String strAuthoName;
    String strPushName;
    int priceBook;
    static int nNumBook;
    int totalBookNum;

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public static int getnID() {
        return nID;
    }

    public static void setnID(int nID) {
        Book.nID = nID;
    }

    public String getStrAuthoName() {
        return strAuthoName;
    }

    public void setStrAuthoName(String strAuthoName) {
        this.strAuthoName = strAuthoName;
    }

    public String getStrPushName() {
        return strPushName;
    }

    public void setStrPushName(String strPushName) {
        this.strPushName = strPushName;
    }

    public int getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(int priceBook) {
        this.priceBook = priceBook;
    }

    public static int getnNumBook() {
        return nNumBook;
    }

    public static void setnNumBook(int nNumBook) {
        Book.nNumBook = nNumBook;
    }

    public int getTotalBookNum() {
        return totalBookNum;
    }

    public void setTotalBookNum(int totalBookNum) {
        this.totalBookNum = totalBookNum;
    }

    //添加
    List<Book> AddBook(String bookName, int nId, String authoName, String PushName, int priceBook, int numBook)
    {
        Book bk = new Book();
        List<Book> list = new ArrayList<Book>();
        bk.setStrName(bookName);
        Book.setnID(nId);
        bk.setStrAuthoName(authoName);
        bk.setStrPushName(PushName);
        bk.setPriceBook(priceBook);
        //Book.setnNumBook(numBook);
        bk.setTotalBookNum(Book.getnNumBook() + numBook);
        list.add(bk);
        return list;
    }

    //查询
    Book SelectBook(List<Book> al, int nID)
    {
        //List<Book> list = new ArrayList<Book>();
        for (int x = 0; x < al.size(); x++)
        {
            if (al.get(nID) != null)
            {
                return al.get(nID);
            }
            else
            {
                System.out.println("没找到!");
            }
        }
        return null;
    }

    //删除
    void DeleteBook(List<Book> al, int nID)
    {
        Book bk = al.remove(nID);
        if (bk != null)
        {
            System.out.println("删除成功!");
        }
    }
}

public class JavaDay003_1 {
    public static void main(String []args)
    {
        Book bk = new Book();
        List<Book> list = new ArrayList<Book>();
        list = bk.AddBook("MathBook", 1, "y0n", "xxxPusher", 10, 10);
        bk = bk.SelectBook(list, 0);
        System.out.println("书名：" + bk.getStrName()
                + " 编号：" + Book.getnID()
                + " 作者名：" + bk.getStrAuthoName()
                + " 出版社名：" + bk.getStrPushName()
                + " 书价：" + bk.getPriceBook()
                + " 册数：" + Book.getnNumBook()
                + " 总数：" + bk.getTotalBookNum());
        bk.DeleteBook(list, 0);

    }

}
