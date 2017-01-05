/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     service
 *
 *    Filename:    PnInfoService.java
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
 *    Create at:   2017年1月4日 下午5:03:34
 *
 *    Revision:
 *
 *    2017年1月4日 下午5:03:34
 *        - first revision
 *
 *****************************************************************/
package com.zzx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzx.dao.PnInfoDao;
import com.zzx.model.PnInfo;

/**
 * @ClassName PnInfoService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author liqiang
 * @Date 2017年1月4日 下午5:03:34
 * @version 1.0.0
 */
@Repository
public class PnInfoService {
    
    @Autowired
    private PnInfoDao pnInfoDao;
    
    public PnInfo findPnInfoById(int id){
        return pnInfoDao.findPnInfoById(id);
    }
    
    /**
     * 
     * @Description (按分类查找公众号)
     * @param pnType
     * @param offset
     * @param pagesize
     * @return
     */
    public List<PnInfo> findPnByType(int pnType, int offset, int pagesize){
        return pnInfoDao.findPnByType(pnType, offset, pagesize);
    }
    
    public List<PnInfo> findPnBySearchKey(String searchKey){
        return pnInfoDao.findPnBySearchKey(searchKey);
    }
}
