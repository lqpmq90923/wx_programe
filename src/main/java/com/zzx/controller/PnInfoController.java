/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     controller
 *
 *    Filename:    PnInfoController.java
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
 *    Create at:   2017年1月4日 下午4:47:56
 *
 *    Revision:
 *
 *    2017年1月4日 下午4:47:56
 *        - first revision
 *
 *****************************************************************/
package com.zzx.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zzx.dao.PnInfoDao;
import com.zzx.model.PnInfo;
import com.zzx.service.PnInfoService;

/**
 * @ClassName PnInfoController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author liqiang
 * @Date 2017年1月4日 下午4:47:56
 * @version 1.0.0
 */
@RestController
public class PnInfoController {
    
    private Logger logger = Logger.getLogger(PnInfoController.class);
    
    @Autowired
    private PnInfoService pnInfoService;

    @RequestMapping("/PnInfo/{id}")
    @ResponseBody
    public PnInfo getUserInfo(@PathVariable Integer id) {
        PnInfo user = pnInfoService.findPnInfoById(id);
        return user;
    }
    
}
