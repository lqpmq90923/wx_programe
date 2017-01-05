package com.zzx.model;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.zzx.model.result.ResultMessage;

/**
 * 微信公众号
 */
public class PnInfo {
    private Integer id;
    private String name;
    private String type;
    private String num;
    private Date releaseDate;
    private String brief;
    private String describe;
    private String thumbPic;
    private String qrPic;
    private String area;

    /**
     * 
     * @Description (json build by type)
     * @param data
     * @return
     */
    public static String buildJsonById(Object data){
        ResultMessage msg = ResultMessage.buildSuccessMsg(data);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(PnInfo.class , "name", "qrPic", "brief", "type", "num", "describe");
        return JSONObject.toJSONString(msg, filter, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty);
    }
    
    /**
     * 
     * @Description (json build by type)
     * @param data
     * @return
     */
    public static String buildJsonByType(Object data){
        ResultMessage msg = ResultMessage.buildSuccessMsg(data);
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(PnInfo.class , "id", "name", "thumbPic", "brief");
        return JSONObject.toJSONString(msg, filter, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty);
    }

    @Override
    public String toString() {
        return "wx_pn_info [wx_pn_name=" + name + ", wx_pn_type=" + type
                + ", wx_pn_num=" + num + ", wx_pn_release_date=" + releaseDate
                + ", wx_pn_describe=" + describe + ", wx_pn_thumb_pic=" + thumbPic
                + ", wx_pn_qr_pic=" + qrPic + ", wx_pn_area=" + area + ", wx_pn_brief=" + brief +"]";
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getThumbPic() {
        return thumbPic;
    }

    public void setThumbPic(String thumbPic) {
        this.thumbPic = thumbPic;
    }

    public String getQrPic() {
        return qrPic;
    }

    public void setQrPic(String qrPic) {
        this.qrPic = qrPic;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
