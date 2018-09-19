package com.y0n.java;

import com.y0n.java.Utils.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.List;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

/**
 * Created by y0n on 2017/7/5.
 */
public class UIOperator {

    private JLabel jLabel;
    public static JTextField mJTextField;
    private static JTextArea mJTextArea;
    public static JButton jButton;

    private boolean bFixFlag;

    public boolean isbFixFlag() {
        return bFixFlag;
    }

    public void setbFixFlag(boolean bFixFlag) {
        this.bFixFlag = bFixFlag;
    }

    public UIOperator() {
        bFixFlag = false;
    }

    //封装输出信息，显示到界面
    public static void MsgShow2TextArea(String strMsg){
        //追加的方式插入数据
        if(mJTextArea.getText().equals("")){
            mJTextArea.setText("-----提示信息-----\n");
        }
        mJTextArea.append(strMsg);
        //手动清空单行文本框中的内容
        mJTextArea.setText(mJTextArea.getText());
    }

    public static void Show2TextArea(String strMsg){
        mJTextArea.setText(strMsg);
    }

    //界面主框架
    public void UIMainFrame() {
        JFrame jFrame = new JFrame("APK加壳小工具v0.1");
        jFrame.setSize(650,500);
        jFrame.setResizable(false);
        ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir")
                + File.separator
                + "imgs"
                + File.separator
                + "fix.png");
        jFrame.setIconImage(imageIcon.getImage());
        jFrame.setLocationRelativeTo(null);     //null 表示屏幕居中
        //1.设置滑块容器
        JScrollPane jScrollPane = new JScrollPane();
        //显示发送的信息的控件
        //用于显示聊天信息
        //创建一个能插入多行的文本的控件对象
        mJTextArea = new JTextArea();
        mJTextArea.setEditable(false);
        //将多行文本添加入滑块容器中
        jScrollPane.setViewportView(mJTextArea);

        //2.容器中保存3个控件(标签,单行文本框,按钮)
        JPanel jPaneSend = new JPanel();
        //设置边距(该控件距离主窗口边距的距离)
        jPaneSend.setBorder(new EmptyBorder(5,5,5,5));
        //创建网格包布局
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPaneSend.setLayout(gridBagLayout);       //设置容器的布局方式

        //创建GridBagContraints对象，设置属性
        GridBagConstraints constraints = new GridBagConstraints();

        //表示所有的组件都可以在横向,纵向上扩大
        constraints.fill = GridBagConstraints.BOTH; // 设置组件横向纵向可以拉伸
        //设置权重
        constraints.weightx = 0.2;
        JLabel jLabel = new JLabel("路径");   //创建标签
        jLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        gridBagLayout.setConstraints(jLabel,constraints);
        //
        jPaneSend.add(jLabel);

        //创建单行的文本框
        mJTextField = new JTextField();
        constraints.weightx = 6.2;
        gridBagLayout.setConstraints(mJTextField,constraints);
        jPaneSend.add(mJTextField);
        //实现拖拽，并获取文件路径设置到textfield中
        drag();

        //创建按钮
        jButton = new JButton("加固");
        constraints.weightx = 1;
        gridBagLayout.setConstraints(jButton,constraints);
        jPaneSend.add(jButton);
        jButton.setEnabled(false);

        //给按钮添加动作
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //int nRows = mJTextArea.getRows();
                // mJTextArea.insert(mJTextArea.getText(),nRows++);
                //设置标志为true,可以进行加固
                setbFixFlag(true);
            }
        });

        jFrame.add(jScrollPane,BorderLayout.CENTER);
        jFrame.add(jPaneSend,BorderLayout.SOUTH);
        jFrame.setVisible(true);
    }

    private void drag() {
        //panel表示要接受拖拽的控件
        new DropTarget(mJTextField, DnDConstants.ACTION_COPY_OR_MOVE, new DropTargetAdapter()
        {
            @Override
            public void drop(DropTargetDropEvent dtde)//重写适配器的drop方法
            {
                try
                {
                    dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);//接收拖拽来的数据
                    java.util.List<File> list = (java.util.List<File>) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    String path = list.get(0).getAbsolutePath();
                    int index = path.lastIndexOf('.');
                    String fileAttr = path.substring(index, path.length());
                    if (path != null && fileAttr.equals(".apk")){
                        jButton.setEnabled(true);
                        mJTextField.setText(path);
                        dtde.dropComplete(true);//指示拖拽操作已完成
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "请拖入apk文件!");
                        dtde.rejectDrop();//否则拒绝拖拽来的数据
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }


}
