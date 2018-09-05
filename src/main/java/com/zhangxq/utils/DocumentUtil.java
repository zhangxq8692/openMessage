package com.zhangxq.utils;

import com.zhangxq.entity.MsgEntity;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/08/03 21:15
 * @Description:
 */
@Component
public class DocumentUtil {
    private SAXReader saxReader;

    public DocumentUtil() {
        this.saxReader = new SAXReader();
    }
    public void DocumentUtil(InputStream in, MsgEntity msg){
        try {
            Document document = saxReader.read(in);
            List<Element> elements = document.getRootElement().elements();
            for (Element element : elements) {
                System.out.println(element.getName() +":"+element.getText());
                String methodName = "set" + element.getName();
                try {
                    Method method = msg.getClass().getMethod(methodName, String.class);
                    method.setAccessible(true);
                    method.invoke(msg, element.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        InputStream file = DocumentUtil.class.getResourceAsStream("xml.xml");
        GeneralMsgEntity msg = new GeneralMsgEntity();
        new DocumentUtil().DocumentUtil(file,msg);
        System.out.println(msg);
    }*/
}
