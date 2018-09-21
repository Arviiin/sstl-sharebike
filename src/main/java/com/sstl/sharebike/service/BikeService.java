package com.sstl.sharebike.service;

import com.sstl.sharebike.model.LngLatObject;

import java.util.List;

public interface BikeService {

    Integer getTotalBikeAmount();

    List<LngLatObject> getLastPositionByCompanyId(String companyId);
    List<LngLatObject> getLastPositionByCompanyIdAndTime(String companyId,String searchDate);
    List<LngLatObject> getAllPositionByCompanyIdAndTime(String companyId, String searchDate);
}
