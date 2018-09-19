package com.y0n.ApkShell.Utils;

import com.y0n.ApkShell.UIOperator;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by y0n on 2017/6/29.
 */
public class XmlUtils {
    // 1. 获取Document对象
    public static Document getDocument(String xml){
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(new File(xml));
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 2. 获取 application节点
    public static Element getElement(Document doc, String name){
        Element element = doc.getRootElement();
        String name0 = element.getName();
        System.out.println("root: " + name0);
        UIOperator.MsgShow2TextArea("root: " + name0);
        UIOperator.MsgShow2TextArea("\n");
        if (name0.equals(name))
            return element;
        else
            return getChildElement(element, name);
    }

    private static Element getChildElement(Element element, String name) {
        List<Element> eles = element.elements();
        for (int i = 0; i <eles.size() ; i++) {
            String name0 = eles.get(i).getName();
            System.out.println("Child: " +name0);
            UIOperator.MsgShow2TextArea("Child: " +name0);
            UIOperator.MsgShow2TextArea("\n");
            if (name0.equals(name))
                return eles.get(i);
        }
        return null;
    }


    public static void ChangeAplication(String xml) {
        // 1. 获取doc对象
        Document doc = getDocument(xml);
        // 2. 获取application节点
        Element element = getElement(doc,"application");
        // 3. 获取android:name属性，没有就添加
        Attribute attribute = find(element, "name");
        if (attribute == null){
            element.addAttribute("android:name",
                    "com.example.y0n.puppetdexfrommem.MypuppetApplication");
        }
        try {
            // 4. 删除本身的xml文件
            File file = new File(xml);
            if (file.exists())
                file.delete();
            file.createNewFile();

            // 5. 保存已经修改过的doc对象为新的xml文件
            XMLWriter writer = new XMLWriter(new FileWriter(file));
            writer.write(doc);
            writer.flush();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Attribute find(Element element,String attrName) {
        List<Attribute> attrs = element.attributes();
        for (int i = 0; i < attrs.size(); i++) {
            String name = attrs.get(i).getName();
            System.out.println("attr:" + name);
            UIOperator.MsgShow2TextArea("attr:" + name);
            UIOperator.MsgShow2TextArea("\n");
            if (name.equals(attrName))
                return attrs.get(i);
        }
        return null;
    }
}
