package com.zhangxq.controller;

import com.zhangxq.entity.GeneralMsgEntity;
import com.zhangxq.utils.DocumentUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


/**
 * @Auther: Administrator
 * @Date: 2018/07/31 00:59
 * @Description:
 */
@RestController
@RequestMapping("/open")
public class InterfaceController{
    private static String TOKEN = "zhangxq5104";
    @RequestMapping(value = "")
    /* public String interfacePoint(String signature, String timestamp, String nonce, String echostr, HttpServletRequest request){*/
    public String interfacePoint(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        Document document = DocumentHelper.createDocument();
        DocumentUtil documentUtil = new DocumentUtil();
        GeneralMsgEntity generalMsgEntity = new GeneralMsgEntity();

        InputStream in = null;
        try {
            in = request.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
            documentUtil.DocumentUtil(in, generalMsgEntity);
            Element xml = document.addElement("xml");
        String str = "<xml><ToUserName><![CDATA["+generalMsgEntity.getFromUserName()
                +"]]></ToUserName><FromUserName><![CDATA["+generalMsgEntity.getToUserName()
                +"]]></FromUserName><CreateTime>"+String.valueOf(System.currentTimeMillis())
                +"</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA["+generalMsgEntity.getContent()
                +"]]></Content></xml>";

        return str;
    }

    @RequestMapping("/point")
    public String point() {
        return "ssss";
    }


}
