package com.ponloo.extend.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.ponloo.extend.model.T_D_VideoAnalysis;
import com.ponloo.extend.repository.VideoAnalysisRepository;
import com.ponloo.extend.service.T_D_VideoAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/16.
 */
@Service
public class T_D_VideoAnalysisServiceImpl implements T_D_VideoAnalysisService {
    @Autowired
    VideoAnalysisRepository videoAnalysisRepository;

    @Override
    public void addDataList(JSONArray jsonArray, Long ykeyDataId, Date date) {
        for(int i = 0; i < jsonArray.size(); i++){
            JSONArray array = (JSONArray) jsonArray.get(i);
            addData(array, ykeyDataId, date);
        }
    }

    @Override
    @Transactional
    public T_D_VideoAnalysis addData(JSONArray data, Long ykeyDataId, Date date) {
        T_D_VideoAnalysis videoAnalysis = new T_D_VideoAnalysis();
        videoAnalysis.setTitle((String) data.get(0));
        videoAnalysis.setRecommendNum(Long.parseLong((String) data.get(1)));
        videoAnalysis.setPlayNum(Long.parseLong((String) data.get(2)));
        videoAnalysis.setCommentNum(Long.parseLong((String) data.get(3)));
        videoAnalysis.setAddFansNum(Long.parseLong((String) data.get(4)));
        videoAnalysis.setCollectionNum(Long.parseLong((String) data.get(5)));
        videoAnalysis.setRelayNum(Long.parseLong((String ) data.get(6)));
        videoAnalysis.setPlayTime(Long.parseLong((String) data.get(7)));
        videoAnalysis.setAnalysisMsg((String) data.get(8));
        videoAnalysis.setCaptureDate(date);
        videoAnalysis.setYkeyDataId(ykeyDataId);
        return videoAnalysisRepository.save(videoAnalysis);
    }
}
