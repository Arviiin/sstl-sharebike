package com.sstl.sharebike.service.impl;

import com.sstl.sharebike.mapper.BikeMapper;
import com.sstl.sharebike.model.LngLatObject;
import com.sstl.sharebike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeMapper bikeMapper;


    @Override
    public Integer getTotalBikeAmount() {
        return bikeMapper.getTotalBikeAmount();
    }

    @Override
    public List<LngLatObject> getLastPositionByCompanyId(String companyId) {
        return bikeMapper.getLastPositionByCompanyId(companyId);
    }

    @Override
    public List<LngLatObject> getLastPositionByCompanyIdAndTime(String companyId, String searchDate) {
        String searchBeginDate = searchDate+" 00:00:00";
        String searchEndDate = searchDate+" 23:59:59";
        return bikeMapper.getLastPositionByCompanyIdAndTime(companyId,searchBeginDate,searchEndDate);
    }

    @Override
    public List<LngLatObject> getAllPositionByCompanyIdAndTime(String companyId, String searchDate) {
        String searchBeginDate = searchDate+" 00:00:00";
        String searchEndDate = searchDate+" 23:59:59";
        return bikeMapper.getAllPositionByCompanyIdAndTime(companyId,searchBeginDate,searchEndDate);
    }
}
