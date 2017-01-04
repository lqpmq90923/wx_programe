/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.zzx.dao
 *
 *    Filename:    PnInfoDao.java
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
 *    Create at:   2017年1月4日 下午6:35:45
 *
 *    Revision:
 *
 *    2017年1月4日 下午6:35:45
 *        - first revision
 *
 *****************************************************************/
package com.zzx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zzx.model.PnInfo;

/**
 * @ClassName PnInfoDao
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author liqiang
 * @Date 2017年1月4日 下午6:35:45
 * @version 1.0.0
 */
@Repository
public class PnInfoDao {
    @Autowired  
    private JdbcTemplate jdbcTemplate; 
    
    @Transactional(readOnly = true)
    public PnInfo findUserById(int id) {
        return jdbcTemplate.queryForObject("select * FROM tb_pn_info where id = ?", new Object[] { id }, new PnInfoRowMapper());
    }
}

class PnInfoRowMapper implements RowMapper<PnInfo> {  
    
    @Override  
    public PnInfo mapRow(ResultSet rs, int rowNum) throws SQLException {  
        PnInfo info = new PnInfo();  
        info.setId(rs.getInt("id"));  
        info.setName(rs.getString("wx_pn_name"));  
        info.setArea(rs.getString("wx_pn_area"));
        info.setBrief(rs.getString("wx_pn_brief"));
        info.setDescribe(rs.getString("wx_pn_describe"));
        info.setNum(rs.getString("wx_pn_num"));
        info.setQrPic(rs.getString("wx_pn_qr_pic"));
        info.setReleaseDate(rs.getDate("wx_pn_release_date"));
        info.setThumbPic(rs.getString("wx_pn_thumb_pic"));
        info.setType(rs.getString("wx_pn_type"));
        return info;  
    }  
} 
