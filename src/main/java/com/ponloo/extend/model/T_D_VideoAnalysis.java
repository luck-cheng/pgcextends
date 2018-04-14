package com.ponloo.extend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/15.
 */
@Entity
@Table(name = "t_d_video_analysis")
public class T_D_VideoAnalysis extends BaseModel {
    /*视频标题*/
    @Column(name = "title")
    private String title;
    /*推荐量*/
    @Column(name = "recommend_num")
    private Long recommendNum;
    /*播放量*/
    @Column(name = "play_num")
    private Long playNum;
    /*评论量*/
    @Column(name = "comment_num")
    private Long commentNum;
    /*涨粉量*/
    @Column(name = "add_fans_num")
    private Long addFansNum;
    /*收藏量*/
    @Column(name = "collection_num")
    private Long collectionNum;
    /*转发量*/
    @Column(name = "relay_num")
    private Long relayNum;
    /*播放时长（分钟）*/
    @Column(name = "play_time")
    private Long playTime;
    /*详细分析路径*/
    @Column(name = "analysis_msg")
    private String analysisMsg;
    /*抓取时间*/
    @Column(name = "capture_date")
    private Date captureDate;
    /*昨日关键数据表id*/
    @Column(name = "ykey_data_id")
    private Long ykeyDataId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Long recommendNum) {
        this.recommendNum = recommendNum;
    }

    public Long getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Long playNum) {
        this.playNum = playNum;
    }

    public Long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Long commentNum) {
        this.commentNum = commentNum;
    }

    public Long getAddFansNum() {
        return addFansNum;
    }

    public void setAddFansNum(Long addFansNum) {
        this.addFansNum = addFansNum;
    }

    public Long getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Long collectionNum) {
        this.collectionNum = collectionNum;
    }

    public Long getRelayNum() {
        return relayNum;
    }

    public void setRelayNum(Long relayNum) {
        this.relayNum = relayNum;
    }

    public Long getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Long playTime) {
        this.playTime = playTime;
    }

    public String getAnalysisMsg() {
        return analysisMsg;
    }

    public void setAnalysisMsg(String analysisMsg) {
        this.analysisMsg = analysisMsg;
    }

    public Date getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }

    public Long getYkeyDataId() {
        return ykeyDataId;
    }

    public void setYkeyDataId(Long ykeyDataId) {
        this.ykeyDataId = ykeyDataId;
    }
}