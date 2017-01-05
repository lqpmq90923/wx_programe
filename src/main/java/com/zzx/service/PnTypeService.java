/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.zzx.service
 *
 *    Filename:    PnTypeService.java
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
 *    Create at:   2017年1月5日 下午7:52:12
 *
 *    Revision:
 *
 *    2017年1月5日 下午7:52:12
 *        - first revision
 *
 *****************************************************************/
package com.zzx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzx.dao.PnTypeDao;
import com.zzx.model.PnType;

/**
 * @ClassName PnTypeService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author liqiang
 * @Date 2017年1月5日 下午7:52:12
 * @version 1.0.0
 */
@Service
public class PnTypeService {
    @Autowired
    private PnTypeDao pnTypeDao;
    
    
    public List<PnType> getPnTypes(){
        return pnTypeDao.getPnTyps();
    }
}
