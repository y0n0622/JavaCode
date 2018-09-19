/**
 * Created by y0nz1 on 2017/4/18.
 * 4.定义一个抽象类Shape，用类标示二维图形，
 * Shape具有抽象方法area和perimeter，分别用来计算形状的面积和周长，
 * 定义一些二维形状类(矩形，三角形，圆)
 * 这些类都是Shape类的子类
 */
public abstract class JavaDay002_4 {
    abstract int area();
    abstract int perimeter();
}

class Rect extends JavaDay002_4
{
    int length;
    int wight;
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    @Override
    int area() {

        return length * wight;
    }

    @Override
    int perimeter() {
        return (length + wight) * 2;
    }
}

class Trangle extends JavaDay002_4
{
    int aSide;
    int bSide;
    int cSide;

    public int getaSide() {
        return aSide;
    }

    public void setaSide(int aSide) {
        this.aSide = aSide;
    }

    public int getbSide() {
        return bSide;
    }

    public void setbSide(int bSide) {
        this.bSide = bSide;
    }

    public int getcSide() {
        return cSide;
    }

    public void setcSide(int cSide) {
        this.cSide = cSide;
    }

    @Override
    int area() {
        int s = (aSide + bSide + cSide) / 2;
        double area = (double) (s * (s - aSide) * (s - bSide) * (s - cSide));
        return (int) Math.pow(area, 0.5);
    }

    @Override
    int perimeter() {
        return aSide + bSide + cSide;
    }
}

class Round extends JavaDay002_4
{
    int Rides;

    public int getRides() {
        return Rides;
    }

    public void setRides(int rides) {
        Rides = rides;
    }

    @Override
    int area() {
        return (int) (Rides * Rides * 3.14);
    }

    @Override
    int perimeter() {
        return (int) (2 * Rides * 3.14);
    }
}

class ExObj
{
    public static void main(String []args)
    {
        Rect rc = new Rect();
        rc.setLength(3);
        rc.setWight(4);
        System.out.println("矩形面积 = " + rc.area()
                + ",矩形周长 = " + rc.perimeter());

        Trangle tg = new Trangle();
        tg.setaSide(3);
        tg.setbSide(4);
        tg.setcSide(5);
        System.out.println("三角形面积 = " + tg.area()
                + ",三角形周长 = " + tg.perimeter());

        Round rd = new Round();
        rd.setRides(2);
        System.out.println("圆面积 = " + rd.area()
                + ",圆周长 = " + rd.perimeter());
    }
}