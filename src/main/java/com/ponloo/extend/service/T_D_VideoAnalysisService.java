package com.ponloo.extend.service;

import com.alibaba.fastjson.JSONArray;
import com.ponloo.extend.model.T_D_VideoAnalysis;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/16.
 */
public interface T_D_VideoAnalysisService {
    void addDataList(JSONArray jsonArray, Long ykeyDataId, Date date);
    T_D_VideoAnalysis addData(JSONArray data, Long ykeyDataId, Date date);
}
