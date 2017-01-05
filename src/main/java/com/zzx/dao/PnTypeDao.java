/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.zzx.dao
 *
 *    Filename:    PnTypeDao.java
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
 *    Create at:   2017年1月5日 下午7:52:22
 *
 *    Revision:
 *
 *    2017年1月5日 下午7:52:22
 *        - first revision
 *
 *****************************************************************/
package com.zzx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zzx.model.PnType;

/**
 * @ClassName PnTypeDao
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author liqiang
 * @Date 2017年1月5日 下午7:52:22
 * @version 1.0.0
 */
@Repository
public class PnTypeDao extends BaseDao{

    
    public List<PnType> getPnTyps(){
        return getJdbcTemplate().query("select * from tb_pn_type where deleted_flag = 0", new PnTypeRowMapper());
    }
}

class PnTypeRowMapper implements RowMapper<PnType> {  
    
    @Override  
    public PnType mapRow(ResultSet rs, int rowNum) throws SQLException {  
        PnType info = new PnType();  
        info.setId(rs.getInt("id"));  
        info.setComments(rs.getString("comments"));  
        return info;  
    }  
} 