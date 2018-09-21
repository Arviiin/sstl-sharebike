package com.sstl.sharebike.mapper;

import com.sstl.sharebike.model.LngLatObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BikeMapper {
    /**
     * 获取数据库中单车数量
     * @return
     */
    @Select("SELECT Count(DISTINCT bicycle_id) FROM history_bike_status")
    Integer getTotalBikeAmount();

    /**
     * ofo6.13单车最后位置
     * @return
     */
    @Select("SELECT longitude lng, latitude lat, bicycle_id "  +
            "FROM " +
            "( SELECT * FROM history_bike_status AS hbs WHERE hbs.company_id = #{companyId} AND "+
            "hbs.upload_time BETWEEN '2018-06-13 00:00:00' AND '2018-06-14 00:00:00' " +
            "    ORDER BY hbs.upload_time DESC " +
            " ) temp "+
            "GROUP BY bicycle_id")
    List<LngLatObject> getLastPositionByCompanyId(String companyId);


//    注意:方法不能重载,即不能通过方法名一样参数个数不一样来进行重载!
    /**
     * 单车最后位置
     * @return
     */
//    @Select("SELECT longitude lng, latitude lat, bicycle_id "  +
//            "FROM " +
//            "( SELECT * FROM history_bike_status AS hbs WHERE hbs.company_id = ${companyId} AND "+
//            "hbs.upload_time BETWEEN '${searchBeginData}' AND '${searchEndData}' " +
//            "    ORDER BY hbs.upload_time DESC " +
//            " ) temp "+
//            "GROUP BY bicycle_id")  //${companyId}与#{companyId}是有区别的
    List<LngLatObject> getLastPositionByCompanyIdAndTime(String companyId, String searchBeginDate, String searchEndDate);

    List<LngLatObject> getAllPositionByCompanyIdAndTime(String companyId, String searchBeginDate, String searchEndDate);
}
