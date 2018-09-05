package com.zhangxq.entity;

/**
 * @Auther: Administrator
 * @Date: 2018/08/08 19:15
 * @Description:
 */
public class MsgEntity{
    /**
     * 消息送达用户
     */
    private String ToUserName;
    /**
     * 消息来源用户
     */
    private String FromUserName;
    /**
     * 消息创建时间
     */
    private String CreateTime;
    /**
     * 消息类型
     */
    private String MsgType;
    /**
     * 消息ID
     */
    private String MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
    public String process(String str){
        return "<![CDATA[" + str +"]]>";
    }
}
