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

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zzx.model.PnInfo;
import com.zzx.model.result.ResultMessage;
import com.zzx.service.PnInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName PnInfoController
 * @Description TODO(公众号信息)
 * @author liqiang
 * @Date 2017年1月4日 下午4:47:56
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/pninfo")
@Api(value = "PnInfoController", description = "公众号类型")  
public class PnInfoController {
    
    private Logger logger = Logger.getLogger(PnInfoController.class);
    
    @Autowired
    private PnInfoService pnInfoService;

    @ApiOperation(value="获取公众号详情", notes="")
    @ApiImplicitParam(name="id", value="公众号流水编号", required = true, paramType="path", dataType="int")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getPnInfoById(@PathVariable Integer id) {
        PnInfo info = pnInfoService.findPnInfoById(id);
        if(null == info)
            return ResultMessage.buildNullResultMsg();
        else
            return PnInfo.buildJsonById(info);
    }
    
    @ApiOperation(value="按类型分页获取公众号列表", notes="")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pnType", value = "公众号类型编号(0:表示全部)", required = true, paramType="path", dataType="int"),
        @ApiImplicitParam(name = "offset", value = "分页偏移量", required = true, paramType="path", dataType="int")
    })
    @RequestMapping(value = "/type/{pnType}/{offset}", method = RequestMethod.GET )
    public Object getPnInfoByType(@PathVariable Integer pnType,@PathVariable Integer offset){
        if(pnType == null)
            pnType = 0;
        if(offset == null)
            offset = 0;
        List<PnInfo> data = pnInfoService.findPnByType(pnType, offset, 10);
        if(data.size() >0)
            return PnInfo.buildJsonByType(data);
        else
            return ResultMessage.buildNullResultMsg();
    }
    
    @ApiOperation(value="根据公众号名称，进行关键字检索", notes="")
    @ApiImplicitParam(name = "searchKey", value = "检索关键字", paramType="query", dataType="String")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Object getPnInfoBySearchKey(@RequestParam("searchKey") String searchKey){
        List<PnInfo> data = pnInfoService.findPnBySearchKey(searchKey);
        if(data.size() >0)
            return PnInfo.buildJsonByType(data);
        else
            return ResultMessage.buildNullResultMsg();
    }
}
