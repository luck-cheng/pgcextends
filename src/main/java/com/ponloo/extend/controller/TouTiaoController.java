package com.ponloo.extend.controller;

import com.alibaba.fastjson.JSONArray;
import com.ponloo.extend.annotation.Token;
import com.ponloo.extend.model.T_D_OverView;
import com.ponloo.extend.model.T_D_YKeyData;
import com.ponloo.extend.param.OverViewParam;
import com.ponloo.extend.param.TouTiaoParam;
import com.ponloo.extend.param.UserParam;
import com.ponloo.extend.param.YKeyDataParam;
import com.ponloo.extend.service.T_D_OverViewService;
import com.ponloo.extend.service.T_D_VideoAnalysisService;
import com.ponloo.extend.service.T_D_YKeyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;


@Controller
public class TouTiaoController extends BaseController{
    @Autowired
    T_D_OverViewService overViewService;
    @Autowired
    T_D_YKeyDataService yKeyDataService;
    @Autowired
    T_D_VideoAnalysisService videoAnalysisService;

    @Token
    @RequestMapping(value = "/TouTiao", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> postToutiao(TouTiaoParam touTiaoParam, HttpServletRequest request){
        Date now = new Date();
        UserParam userParam = getTokenUser(request);

        OverViewParam overViewParam = new OverViewParam();
        overViewParam.setArticleNum(touTiaoParam.getArticleNum());
        overViewParam.setCommentNum(touTiaoParam.getCommentNum());
        overViewParam.setFansNum(touTiaoParam.getFansNum());
        overViewParam.setReadNum(touTiaoParam.getReadNum());
        overViewParam.setRecommendNum(touTiaoParam.getRecommendNum());
        overViewParam.setCaptureDate(now);
        overViewParam.setUserId(userParam.getUserId());
        T_D_OverView overView = overViewService.addData(overViewParam);
        if(overView != null) {
            YKeyDataParam yKeyDataParam = new YKeyDataParam();
            yKeyDataParam.setyPlayNum(touTiaoParam.getyPlayNum());
            yKeyDataParam.setyFansPlayNum(touTiaoParam.getyFansPlayNum());
            yKeyDataParam.setAllPlayNum(touTiaoParam.getAllPlayNum());
            yKeyDataParam.setAllPlayMinNum(touTiaoParam.getAllPlayMinNum());
            yKeyDataParam.setCaptureDate(now);
            yKeyDataParam.setOverviewId(overView.getId());
            T_D_YKeyData yKeyData = yKeyDataService.addData(yKeyDataParam);
            if(yKeyData != null){
                JSONArray array = (JSONArray) JSONArray.parse(touTiaoParam.getVideoParam());
                videoAnalysisService.addDataList(array, yKeyData.getId(), now);
            }
        }

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", 200);
        hashMap.put("data", "success");
        return hashMap;
    }
}
