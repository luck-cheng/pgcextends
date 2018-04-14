package com.ponloo.extend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/15.
 */
@Entity
@Table(name = "t_d_ykey_data")
public class T_D_YKeyData extends BaseModel{
    /*昨日播放量*/
    @Column(name = "ye_play")
    private Long yPlay;
    /*昨日粉丝播放量*/
    @Column(name = "y_fans_play")
    private Long yFansPlay;
    /*累计播放量*/
    @Column(name = "all_play")
    private Long allPlay;
    /*累计播放时长(分钟)*/
    @Column(name = "all_play_min")
    private Long allPlayMin;
    /*抓取时间*/
    @Column(name = "capture_date")
    private Date captureDate;
    /*概况数据表id*/
    @Column(name = "overview_id")
    private Long overviewId;

    public Long getyPlay() {
        return yPlay;
    }

    public void setyPlay(Long yPlay) {
        this.yPlay = yPlay;
    }

    public Long getyFansPlay() {
        return yFansPlay;
    }

    public void setyFansPlay(Long yFansPlay) {
        this.yFansPlay = yFansPlay;
    }

    public Long getAllPlay() {
        return allPlay;
    }

    public void setAllPlay(Long allPlay) {
        this.allPlay = allPlay;
    }

    public Long getAllPlayMin() {
        return allPlayMin;
    }

    public void setAllPlayMin(Long allPlayMin) {
        this.allPlayMin = allPlayMin;
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
