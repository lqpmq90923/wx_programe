/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.zzx.controller
 *
 *    Filename:    PnTypeController.java
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
 *    Create at:   2017年1月5日 下午7:57:06
 *
 *    Revision:
 *
 *    2017年1月5日 下午7:57:06
 *        - first revision
 *
 *****************************************************************/
package com.zzx.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zzx.model.PnType;
import com.zzx.model.result.ResultMessage;
import com.zzx.service.PnTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName PnTypeController
 * @Description TODO(公众号分类)
 * @author liqiang
 * @Date 2017年1月5日 下午7:57:06
 * @version 1.0.0
 */

@RestController
@RequestMapping("/api/pntype")
@Api(value = "PnTypeController", description = "公众号类型")  
public class PnTypeController {
    
    @Autowired
    private PnTypeService pnTypeService;
    
    @ApiOperation(value="获取公众号类型列表", notes="")
    @RequestMapping(value = "/getlist", method=RequestMethod.GET)
    @ResponseBody
    public Object getPnTypes(){
        List<PnType> data = pnTypeService.getPnTypes();
        if(data.size() >0){
            return ResultMessage.buildSuccessMsg(data);
        } else {
            return ResultMessage.buildNullResultMsg();
        }
    }
}
