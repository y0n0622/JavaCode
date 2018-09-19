import java.util.Scanner;

/**
 * Created by y0nz1 on 2017/4/17.
 * 9.编写万年历程序
 */
public class JavaDay001_9 {
    static String CaculateWeekDay(int y,int m,int d)
    {
        if(m==1)
        {
            m = 13;
            y--;
        }
        if(m==2)
        {
            m=14;
            y--;
        }
        int week=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7;
        String weekstr = null;
        switch(week)
        {
            case 0: weekstr="星期一"; break;
            case 1: weekstr="星期二"; break;
            case 2: weekstr="星期三"; break;
            case 3: weekstr="星期四"; break;
            case 4: weekstr="星期五"; break;
            case 5: weekstr="星期六"; break;
            case 6: weekstr="星期日"; break;
        }
        return weekstr;
    }

    public static void main(String [] args)
    {
        int [][] day = new int[5][7];
        System.out.print("请选择年份：");
        Scanner scanner = new Scanner(System.in);
        int nYear = scanner.nextInt();
        System.out.print("请选择月份：");
        int nMounth = scanner.nextInt();

        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
        int bflag = 0;
        String strWeek = CaculateWeekDay(nYear, nMounth, 1);
        if (strWeek.equals("星期一"))
        {
            day[0][1] = 1;
        }
        if (strWeek.equals("星期二"))
        {
            day[0][2] = 1;
        }
        if (strWeek.equals("星期三"))
        {
            day[0][3] = 1;
        }
        if (strWeek.equals("星期四"))
        {
            day[0][4] = 1;
        }
        if (strWeek.equals("星期五"))
        {
            day[0][5] = 1;
        }
        if (strWeek.equals("星期六"))
        {
            day[0][6] = 1;
            bflag = 1;
        }
        if (strWeek.equals("星期日"))
        {
            day[0][0] = 1;
        }

        if (nMounth == 1 ||
                nMounth == 3 ||
                nMounth == 5 ||
                nMounth == 7 ||
                nMounth == 8 ||
                nMounth == 10 ||
                nMounth == 12)
        {
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 7; j++)
                {
                    if (day[i][j] == 1)
                    {
                        for (int m = 0; m < 31; m++)
                        {
                            System.out.print(day[i][j] + m + "\t\t");
                            if ((j + m + 1) % 7 == 0)
                            {
                                System.out.println();
                            }
                        }
                    }
                    else
                    {
                        System.out.print("\t\t");
                    }
                }

            }
        }
        else if (nMounth == 4 ||
                nMounth == 6 ||
                nMounth == 9 ||
                nMounth == 11)
        {
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 7; j++)
                {
                    if (day[i][j] == 1)
                    {
                        for (int m = 0; m < 30; m++)
                        {
                            System.out.print(day[i][j] + m + "\t\t");
                            if ((j + m + 1) % 7 == 0)
                            {
                                System.out.println();
                            }
                        }
                    }
                    else
                    {
                        System.out.print("\t\t");
                    }
                }

            }
        }
        else
        {
            if ((nYear % 4 == 0 || nYear % 400 == 0) && nYear % 100 != 0)
            {
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 7; j++)
                    {
                        if (day[i][j] == 1)
                        {
                            for (int m = 0; m < 29; m++)
                            {
                                System.out.print(day[i][j] + m + "\t\t");
                                if ((j + m + 1) % 7 == 0)
                                {
                                    System.out.println();
                                }
                            }
                        }
                        else
                        {
                            System.out.print("\t\t");
                        }
                    }
                }
            }
            else
            {
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 7; j++)
                    {
                        if (day[i][j] == 1)
                        {
                            for (int m = 0; m < 28; m++)
                            {
                                System.out.print(day[i][j] + m + "\t\t");
                                if ((j + m + 1) % 7 == 0)
                                {
                                    System.out.println();
                                }
                            }
                        }
                        else
                        {
                            System.out.print("\t\t");
                        }
                    }

                }
            }
        }
    }
}
