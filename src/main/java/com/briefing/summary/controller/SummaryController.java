package com.briefing.summary.controller;

import com.briefing.summary.model.Summary;
import com.briefing.summary.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/summary")
public class SummaryController {
    private SummaryService summaryService;

    @Autowired
    public void setSummaryService(SummaryService summaryService){
        this.summaryService=summaryService;
    }

    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public Summary getSummaryById(@RequestParam("id") String id){
        return summaryService.getSummaryById(id);
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
