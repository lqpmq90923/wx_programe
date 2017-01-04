/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.zzx
 *
 *    Filename:    ApplicationTests.java
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
 *    Create at:   2017年1月4日 下午7:34:39
 *
 *    Revision:
 *
 *    2017年1月4日 下午7:34:39
 *        - first revision
 *
 *****************************************************************/
package com.zzx;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzx.model.PnInfo;
import com.zzx.service.PnInfoService;

/**
 * @ClassName ApplicationTests
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author liqiang
 * @Date 2017年1月4日 下午7:34:39
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WeixinXcxApplication.class)
public class ApplicationTests {
    @Autowired
    private PnInfoService pnInfoService;

    @Test
    public void test() throws Exception {
        PnInfo pnInfo = pnInfoService.findPnInfoById(9383);
           System.out.println(new JSONObject(pnInfo));
    }
}
