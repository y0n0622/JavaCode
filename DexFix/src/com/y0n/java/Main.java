package com.y0n.java;


import com.y0n.java.Utils.*;

import java.io.File;

import static com.y0n.java.FuncOperator.makeFixApk;

/**
 * Created by y0n on 2017/6/29.
 */

public class Main {
    public static void main(String[] args){
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
                        makeFixApk();
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
                }
            }
        }.start();


    }
}
