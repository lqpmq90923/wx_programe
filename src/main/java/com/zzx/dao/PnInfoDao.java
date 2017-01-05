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
import java.util.List;

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
public class PnInfoDao extends BaseDao{
    
    @Transactional(readOnly = true)
    public PnInfo findPnInfoById(int id) {
        return getJdbcTemplate().queryForObject(
                "select p.id,p.wx_pn_name,t.comments as wx_pn_type, p.wx_pn_num, p.wx_pn_brief, p.wx_pn_describe, p.wx_pn_area, p.wx_pn_qr_pic, p.wx_pn_release_date, p.wx_pn_thumb_pic FROM wx_program_db.tb_pn_info p inner join wx_program_db.tb_pn_type t on p.wx_pn_type = t.id where p.id = ?",
                new Object[] {id }, new PnInfoRowMapper());
    }
    
    public List<PnInfo> findPnByType(int pnType, int offset, int pagesize){
        if(pnType>0){
            return getJdbcTemplate().query("select * FROM tb_pn_info where wx_pn_type = ? limit ?,?", new Object[] { pnType, offset, pagesize }, new PnInfoRowMapper());
        }else{
            return getJdbcTemplate().query("select * FROM tb_pn_info limit ?,?", new Object[] { offset, pagesize }, new PnInfoRowMapper());
        }
        
    }
    
    public List<PnInfo> findPnBySearchKey(String searchKey){
        return getJdbcTemplate().query("select * FROM tb_pn_info where wx_pn_name like CONCAT('%',?,'%')", new Object[] { searchKey }, new PnInfoRowMapper());
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
