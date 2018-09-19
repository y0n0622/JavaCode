/**
 * Created by y0nz1 on 2017/4/18.
 * 1.编写一个代表地址的Address类，地址信息由国家，身份，城市，街道，邮编组成
 * 并可以返回完整的地址信息
 */
public class JavaDay002_1 {
    String Country;
    String Identifiy;
    String City;
    String Street;
    String Stamp;
    public void setCountry(String country) {
        Country = country;
    }
    public void setIdentifiy(String identifiy) {
        Identifiy = identifiy;
    }
    public void setCity(String city) {
        City = city;
    }
    public void setStreet(String street) {
        Street = street;
    }
    public void setStamp(String stamp) {
        Stamp = stamp;
    }
    public String getCountry() {
        return Country;
    }
    public String getIdentifiy() {
        return Identifiy;
    }
    public String getCity() {
        return City;
    }
    public String getStreet() {
        return Street;
    }
    public String getStamp() {
        return Stamp;
    }
    public static void main(String []args)
    {
        JavaDay002_1 address = new JavaDay002_1();
        address.setCountry("Chain");
        address.setIdentifiy("Student");
        address.setCity("Beijing");
        address.setStreet("XinFuRoad");
        address.setStamp("402310");

        System.out.println("地址：" +
                address.getCountry() + "_" +
                address.getIdentifiy() + "_" +
                address.getCity() + "_" +
                address.getStreet() + "_" +
                address.getStamp());
    }
}
