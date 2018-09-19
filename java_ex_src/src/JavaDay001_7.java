/**
 * Created by y0nz1 on 2017/4/17.
 *7.画图
 */
public class JavaDay001_7 {
    public static void main(String [] args){
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (i == 0 && j == 3)
                {
                    System.out.print("*");
                }
                else if(i == 1 && j < 5 && j > 1)
                {
                    System.out.print("*");
                }
                else if(i == 2 && j < 6 && j > 0)
                {
                    System.out.print("*");
                }
                else if (i == 3)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if(i == 0 && j < 6 && j > 0)
                {
                    System.out.print("*");
                }
                else if (i == 1 && j < 5 && j > 1)
                {
                    System.out.print("*");
                }
                else if (i == 2 && j ==3)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
