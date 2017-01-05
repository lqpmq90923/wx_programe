/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.zzx.dao
 *
 *    Filename:    BaseDao.java
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
 *    Create at:   2017年1月5日 下午7:52:38
 *
 *    Revision:
 *
 *    2017年1月5日 下午7:52:38
 *        - first revision
 *
 *****************************************************************/
package com.zzx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName BaseDao
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author liqiang
 * @Date 2017年1月5日 下午7:52:38
 * @version 1.0.0
 */
public class BaseDao {
    @Autowired  
    private JdbcTemplate jdbcTemplate;

    
    /**
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
