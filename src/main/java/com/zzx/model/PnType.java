/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.zzx.model
 *
 *    Filename:    PnType.java
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
 *    Create at:   2017年1月5日 下午7:50:15
 *
 *    Revision:
 *
 *    2017年1月5日 下午7:50:15
 *        - first revision
 *
 *****************************************************************/
package com.zzx.model;


/**
 * @ClassName PnType
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author liqiang
 * @Date 2017年1月5日 下午7:50:15
 * @version 1.0.0
 */
public class PnType {
    //编号
    private Integer id;
    //描述
    private String comments;
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }
    
    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
}
