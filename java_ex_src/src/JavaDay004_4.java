import java.util.*;
/**
 * Created by y0nz1 on 2017/4/19.
 * 4.实现扑克牌小游戏
 *   玩家名字异常检测（不能是数字，只能只能是字符）
 *   随机给玩家3张牌
 *   玩家将3张牌中最大的牌输出
 */
class Card{
    private String color;
    private String number;

    public Card(String color, String number) {
        this.color = color;
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Card))
            return false;
        Card other = (Card) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        return true;
    }

}

class Cards {
    private List<Card> list = new ArrayList<Card>();
    //创建一副扑克牌
    public Cards(){
        System.out.println("-----------------创建扑克牌------------------");
        String[] color = {"黑桃", "红桃", "梅花", "方片"};
        String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J","Q","K", "A"};
        for(int i=0;i<color.length;i++)
            for(int j=0;j<number.length;j++){
                list.add(new Card(color[i], number[j]));
            }
        System.out.println("----------------扑克牌创建成功！---------------");
    }

    //获取一副扑克牌
    public List<Card> getList() {
        return list;
    }

    //洗牌（打乱）
    public void shufCards(){
        System.out.println("----------------开始洗牌------------------------");
        Collections.shuffle(list);
        System.out.println("----------------洗牌结束------------------------");
    }

    //展示一副扑克牌
    public void showCards(){
        System.out.print("当前的扑克牌为：");
        System.out.print("[ ");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i).getColor() + list.get(i).getNumber()+ " ");
        }
        System.out.println(" ]");
    }

}

class Player {
    private int id;
    private String name;
    private List<Card> handCards = new ArrayList<Card>();

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(Card card) {
        handCards.add(card);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        // 构建花色和牌值数组，通过比对，计算得到某张牌的价值（大小）
        String[] color = {"方片", "梅花", "红桃", "黑桃"};
        String[] number = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J","Q","K", "A"};

        //由于比较规则是先比较牌值，如果相等再比较花色（黑红梅方），所以将牌值赋予较高的权值
        int valueOfC1 = 0;
        int valueOfC2 = 0;
        for(int i=0;i<number.length;i++){
            if(c1.getNumber().equals(number[i])) valueOfC1 += i*10;
            if(c2.getNumber().equals(number[i])) valueOfC2 += i*10;
        }
        for(int i=0;i<color.length;i++){
            if(c1.getColor().equals(color[i])) valueOfC1 += i;
            if(c2.getColor().equals(color[i])) valueOfC2 += i;
        }

        if( valueOfC1 > valueOfC2 ) return -1;
        if( valueOfC1 < valueOfC2 ) return 1;

        return 0;
    }

}
public class JavaDay004_4 {
    //创建玩家
    //要对玩家ID的异常处理，要求用户只能输入整数ID，否则需要重新输入
    public Player setPlayer(){
        int id=0;
        String name="";
        Scanner console = new Scanner(System.in);
        boolean ready = true;
        do{
            try{
                System.out.println("输入ID：");
                id = console.nextInt();
                ready = true;
            }catch(Exception e){
                System.out.println("请输入整数类型的ID！");
                ready = false;
                console.nextLine();
            }
        }while(ready==false);

        System.out.println("输入姓名：");
        name = console.next();
        return new Player(id, name);
    }

    public static void main(String[] args) {
        //测试简易扑克牌程序
        JavaDay004_4 game = new JavaDay004_4();
        //（1）创建一副牌
        Cards cards = new Cards();
        //（2）展示新的扑克牌
        cards.showCards();
        //（3）洗牌
        cards.shufCards();
        //（4）创建玩家
        System.out.println("--------------创建两个（or多个）玩家就可以开始游戏啦！-------------");
        List<Player> p = new ArrayList<Player>();
        for(int i=0;i<2;i++)
        {
            System.out.println("请输入第"+(i+1)+"位玩家的ID和姓名:");
            p.add(game.setPlayer());
        }
        for(int i=0;i<p.size();i++)
        {
            System.out.println("欢迎玩家："+p.get(i).getName());
        }
        //（5）扑克牌比大小游戏开始啦~
        int count = 0;
        System.out.println("------------------开始发牌---------------------");
        //设定每人分别拿两张（or多张）
        for(int i=0; i<2;i++){
            //玩家轮流拿牌
            for(int j=0; j< p.size(); j++){
                System.out.println(">玩家"+p.get(j).getName()+"拿牌");
                p.get(j).setHandCards(cards.getList().get(count));
                count++;
            }
        }
        System.out.println("------------------发牌结束！--------------------");
        System.out.println("------------------开始游戏 ---------------------");
        for(int i=0;i<p.size();i++){
            System.out.print("玩家"+p.get(i).getName()+"的手牌为：[ ");
            for(int j=0;j<p.get(i).getHandCards().size();j++){
                Card cur = p.get(i).getHandCards().get(j);
                System.out.print(cur.getColor()+cur.getNumber()+" ");
            }
            System.out.println(" ]");
        }

        //排序得到每个玩家最大的手牌（排序规则自定义）
        for(int i=0;i<p.size();i++){
            Collections.sort(p.get(i).getHandCards(), new CardComparator());
        }
        List<Card> maxCard = new ArrayList<Card>();
        for(int i=0;i<p.size();i++){
            Card maxCur = p.get(i).getHandCards().get(0);
            System.out.println("玩家"+p.get(i).getName()+"最大的手牌为："+ maxCur.getColor()+maxCur.getNumber());
            maxCard.add(maxCur);
        }

        //得到最后的胜者
        List<Card> temp = new ArrayList<Card>();
        temp.addAll(maxCard);
        Collections.sort(temp, new CardComparator());
        for(int i=0;i<p.size();i++){
            if(maxCard.get(i).equals(temp.get(0))) System.out.println("恭喜玩家："+p.get(i).getName()+"获胜！");
        }
    }
}
