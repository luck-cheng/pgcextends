package com.ponloo.extend.service.Impl;

import com.ponloo.extend.model.T_D_YKeyData;
import com.ponloo.extend.param.YKeyDataParam;
import com.ponloo.extend.repository.YKeyDataRepository;
import com.ponloo.extend.service.T_D_YKeyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/7/15.
 */
@Service
public class T_D_YKeyDataServiceImpl implements T_D_YKeyDataService {
    @Autowired
    YKeyDataRepository yKeyDataRepository;

    @Override
    @Transactional
    public T_D_YKeyData addData(YKeyDataParam yKeyDataParam) {
        T_D_YKeyData yKeyData = new T_D_YKeyData();
        yKeyData.setyPlay(Long.parseLong(yKeyDataParam.getyPlayNum().replace(",", "")));
        yKeyData.setyFansPlay(Long.parseLong(yKeyDataParam.getyFansPlayNum().replace(",", "")));
        yKeyData.setAllPlay(Long.parseLong(yKeyDataParam.getAllPlayNum().replace(",", "")));
        yKeyData.setAllPlayMin(Long.parseLong(yKeyDataParam.getAllPlayMinNum().replace(",", "")));
        yKeyData.setOverviewId(yKeyDataParam.getOverviewId());
        yKeyData.setCaptureDate(yKeyDataParam.getCaptureDate());
        return yKeyDataRepository.save(yKeyData);
    }
}
