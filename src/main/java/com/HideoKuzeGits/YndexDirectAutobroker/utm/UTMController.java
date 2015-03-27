package com.HideoKuzeGits.YndexDirectAutobroker.utm;

import com.HideoKuzeGits.YndexDirectAutobroker.strategies.StrategiesDao;
import com.HideoKuzeGits.YndexDirectAutobroker.strategies.conversion.CampaignsGoalsWireService;
import com.HideoKuzeGits.YndexDirectAutobroker.SessionAttributeWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by root on 28.07.14.
 */
@Controller
public class UTMController {


    @Autowired
    private UTMService utmService;

    @Autowired
    private CampaignsGoalsWireService wireService;

    @Autowired
    private SessionAttributeWrap sessionWrap;

    @Autowired
    private StrategiesDao strategiesDao;

    @RequestMapping(value = "/add_utm")
    @ResponseBody
    public String addUTM(@RequestParam Long id){

        if (sessionWrap.isEmpty())
            return "redirect:/accounts";

        try {
            utmService.addUTMtoCampaign(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }



    @RequestMapping(value = "/refresh_wire", method = RequestMethod.POST)
    @ResponseBody
    public String refreshWire(){

        try {
            wireService.refreshWire();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "a";
    }

}
