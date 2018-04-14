package com.ponloo.extend.param;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/18.
 */
public class YKeyDataParam {
    private String yPlayNum;
    private String yFansPlayNum;
    private String allPlayNum;
    private String allPlayMinNum;
    private Date captureDate;
    private Long overviewId;

    public String getyPlayNum() {
        return yPlayNum;
    }

    public void setyPlayNum(String yPlayNum) {
        this.yPlayNum = yPlayNum;
    }

    public String getyFansPlayNum() {
        return yFansPlayNum;
    }

    public void setyFansPlayNum(String yFansPlayNum) {
        this.yFansPlayNum = yFansPlayNum;
    }

    public String getAllPlayNum() {
        return allPlayNum;
    }

    public void setAllPlayNum(String allPlayNum) {
        this.allPlayNum = allPlayNum;
    }

    public String getAllPlayMinNum() {
        return allPlayMinNum;
    }

    public void setAllPlayMinNum(String allPlayMinNum) {
        this.allPlayMinNum = allPlayMinNum;
    }

    public Date getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }

    public Long getOverviewId() {
        return overviewId;
    }

    public void setOverviewId(Long overviewId) {
        this.overviewId = overviewId;
    }
}
