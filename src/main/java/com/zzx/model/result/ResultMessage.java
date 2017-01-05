/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.zzx.model.result
 *
 *    Filename:    ResultData.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     liqiang
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年1月5日 下午7:59:27
 *
 *    Revision:
 *
 *    2017年1月5日 下午7:59:27
 *        - first revision
 *
 *****************************************************************/
package com.zzx.model.result;


/**
 * @ClassName ResultData
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author liqiang
 * @Date 2017年1月5日 下午7:59:27
 * @version 1.0.0
 */
public class ResultMessage {
    private int code;
    private String msg;
    private Object data;
    
    /**
     * 
     * @Description (接口访问成功)
     * @param data
     * @return
     */
    public static ResultMessage buildSuccessMsg(Object data){
        ResultMessage result = new ResultMessage();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }
    
    /**
     * 
     * @Description (未查询到数据)
     * @return
     */
    public static ResultMessage buildNullResultMsg(){
        ResultMessage result = new ResultMessage();
        result.setCode(404);
        result.setMsg("not find data");
        result.setData(null);
        return result;
    }
    
    /**
     * @Description TODO(这里用一句话描述这个方法的作用)
     */
    public ResultMessage() {
        super();
    }

    /**
     * @Description TODO(这里用一句话描述这个方法的作用)
     * @param error
     * @param msg
     * @param data
     */
    public ResultMessage(int code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * @return the error
     */
    public int getCode() {
        return code;
    }
    
    /**
     * @param error the error to set
     */
    public void setCode(int code) {
        this.code = code;
    }
    
    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }
    
    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }
    
    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
    
}
