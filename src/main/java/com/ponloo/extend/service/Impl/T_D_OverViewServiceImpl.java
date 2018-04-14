package com.ponloo.extend.service.Impl;

import com.ponloo.extend.model.T_D_OverView;
import com.ponloo.extend.param.OverViewParam;
import com.ponloo.extend.repository.OverViewRepository;
import com.ponloo.extend.service.T_D_OverViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/14.
 */
@Service
public class T_D_OverViewServiceImpl implements T_D_OverViewService {
    @Autowired
    OverViewRepository overViewRepository;

    @Override
    @Transactional
    public T_D_OverView addData(OverViewParam overViewParam) {
        T_D_OverView t_d_overView = new T_D_OverView();
        t_d_overView.setArticleNum(Long.parseLong(overViewParam.getArticleNum().replace(",", "")));
        t_d_overView.setCapture_date(new Date());
        t_d_overView.setCommentNum(Long.parseLong(overViewParam.getCommentNum().replace(",", "")));
        t_d_overView.setFansNum(Long.parseLong(overViewParam.getFansNum().replace(",", "")));
        t_d_overView.setReadNum(Long.parseLong(overViewParam.getReadNum().replace(",", "")));
        t_d_overView.setRecommendNum(Long.parseLong(overViewParam.getRecommendNum().replace(",", "")));
        t_d_overView.setUserId(overViewParam.getUserId());

        T_D_OverView overView = overViewRepository.save(t_d_overView);
        return overView;
    }
}
