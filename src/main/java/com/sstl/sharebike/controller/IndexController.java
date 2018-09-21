package com.sstl.sharebike.controller;

import com.sstl.sharebike.model.JsonResult;
import com.sstl.sharebike.model.LngLatObject;
import com.sstl.sharebike.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private BikeService bikeService;

    private static String SEARCH_DATE = "2018-06-13";

    @RequestMapping(path = {"/hello" ,"/test"})
    @ResponseBody
    public String test(){
        return "Hello Share Bike";
    }

    @RequestMapping(path = {"/template"})
    public String template(){
        return "template";
    }

    /*@RequestMapping("/index")
    public String index(){
        return "sharebikeImplByPointSet";
    }*/

    @RequestMapping("/index")
    public String index(Map<String,Object> map, HttpServletRequest request){
        map.put("searchDate",SEARCH_DATE);
        if (request.getParameter("searchDate") != null){
            SEARCH_DATE = request.getParameter("searchDate");
            System.out.println(SEARCH_DATE+"request");
        }
        System.out.println(SEARCH_DATE);
        //拿到数据库中所查询到的单车总数量数据放入map传给html
        int totalBikeAmount = bikeService.getTotalBikeAmount();
//        map.put("totalBikeAmount","122199");
        map.put("totalBikeAmount",totalBikeAmount);
        //拿到数据库中所查询到的某天单车最后所处的位置数据放入map传给html
//        List<LngLatObject> lngLatObjects = bikeService.getLastPositionByTime();
//        String lastPositionJsonDate = JsonUtils.objectToJson(lngLatObjects);
//        System.out.println(lastPositionJsonDate);
//        map.put("lastPositionJsonDate",lastPositionJsonDate);
        return "DbSharebikeImplByPointSet";
    }

    @RequestMapping(value = "/getOfoLastPositionData", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<JsonResult> getOfoData(){
        JsonResult r = new JsonResult();
        try {
            List<LngLatObject> lngLatOfoObjects = bikeService.getLastPositionByCompanyIdAndTime("05ofo",SEARCH_DATE);
            System.out.println(SEARCH_DATE);
            r.setResult(lngLatOfoObjects);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    @RequestMapping(value = "/getOfoAllPositionByTime", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<JsonResult> getOfoAllPositionByTime(){
        JsonResult r = new JsonResult();
        try {
            List<LngLatObject> lngLatOfoObjects = bikeService.getAllPositionByCompanyIdAndTime("05ofo",SEARCH_DATE);
            r.setResult(lngLatOfoObjects);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value = "/getMobikeLastPositionData", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<JsonResult> getMobikeData(){
        JsonResult r = new JsonResult();
        try {
            List<LngLatObject> lngLatMobikeObjects = bikeService.getLastPositionByCompanyIdAndTime("07mobike",SEARCH_DATE);
            r.setResult(lngLatMobikeObjects);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    @RequestMapping(value = "/getXqLastPositionData", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<JsonResult> getXqData(){
        JsonResult r = new JsonResult();
        try {
            List<LngLatObject> lngLatXqObjects = bikeService.getLastPositionByCompanyIdAndTime("01xqcx",SEARCH_DATE);
            r.setResult(lngLatXqObjects);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
