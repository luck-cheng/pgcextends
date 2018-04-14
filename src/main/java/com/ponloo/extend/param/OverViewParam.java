package com.ponloo.extend.param;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/13.
 */
public class OverViewParam {
    /*文章量*/
    private String articleNum;
    /*推荐量*/
    private String recommendNum;
    /*阅读量*/
    private String readNum;
    /*粉丝阅读量*/
    private String fansNum;
    /*评论量*/
    private String commentNum;
    /*抓取时间*/
    private Date captureDate;
    /*userId*/
    private Long userId;

    public String getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(String articleNum) {
        this.articleNum = articleNum;
    }

    public String getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(String recommendNum) {
        this.recommendNum = recommendNum;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
    }

    public String getFansNum() {
        return fansNum;
    }

    public void setFansNum(String fansNum) {
        this.fansNum = fansNum;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }
}
