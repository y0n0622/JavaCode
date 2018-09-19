package com.y0n.ApkShell;


import static com.y0n.ApkShell.FunOperator.makeApk;


/**
 * Created by y0n on 2017/7/3.
 */
public class Main {
    public static void main(String[] args) {
        UIOperator uiOperator = new UIOperator();
        uiOperator.UIMainFrame();
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    //判断是否点击了加固按钮
                    if (uiOperator.isbFixFlag()){
                        //设置按钮变灰
                        UIOperator.jButton.setEnabled(false);
                        makeApk();
                        //设置按钮还原
                        UIOperator.jButton.setEnabled(true);
                        //将标志置为false
                        uiOperator.setbFixFlag(false);
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    ///////
                    //添加其他按钮事件

                }
            }
        }.start();

    }
}
