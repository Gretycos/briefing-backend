package com.briefing.summary.controller;

import com.briefing.summary.model.Summary;
import com.briefing.summary.service.SummaryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/summary")
public class SummaryController {
    @Resource
    SummaryService summaryService;

    @RequestMapping(value = "/getLatestDate",method = RequestMethod.POST)
    public String getSummaryById(){
        return summaryService.getLatestDate();
    }

    @RequestMapping(value = "/getListByTime",method = RequestMethod.POST)
    public List<Map<String,Object>> getSummaryListByPublishTime(@RequestParam("time") String time){
        return summaryService.getSummaryListByPublishTime(time);
    }

    @RequestMapping(value = "/getTitleListByTime",method = RequestMethod.POST)
    public List<Map<String,Object>> getTitleListByPublishTime(@RequestParam("time") String time){
        return summaryService.getTitleListByPublishTime(time);
    }

}
