package com.ponloo.extend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/14.
 */
@Entity
@Table(name = "t_d_overview")
public class T_D_OverView extends BaseModel{
    /*文章量*/
    @Column(name = "article_num")
    private Long articleNum;
    /*评论量*/
    @Column(name = "recommend_num")
    private Long recommendNum;
    /*阅读量*/
    @Column(name = "read_num")
    private Long readNum;
    /*粉丝阅读量*/
    @Column(name = "fans_num")
    private Long fansNum;
    /*评论量*/
    @Column(name = "comment_num")
    private Long commentNum;
    /*抓取时间*/
    @Column(name = "capture_date")
    private Date capture_date;
    /*对应的用户id*/
    @Column(name = "user_id")
    private Long userId;

    public Long getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Long articleNum) {
        this.articleNum = articleNum;
    }

    public Long getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Long recommendNum) {
        this.recommendNum = recommendNum;
    }

    public Long getReadNum() {
        return readNum;
    }

    public void setReadNum(Long readNum) {
        this.readNum = readNum;
    }

    public Long getFansNum() {
        return fansNum;
    }

    public void setFansNum(Long fansNum) {
        this.fansNum = fansNum;
    }

    public Long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Long commentNum) {
        this.commentNum = commentNum;
    }

    public Date getCapture_date() {
        return capture_date;
    }

    public void setCapture_date(Date capture_date) {
        this.capture_date = capture_date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
