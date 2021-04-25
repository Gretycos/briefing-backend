package com.briefing.summary.service;

import com.alibaba.druid.support.json.JSONParser;
import com.briefing.summary.dao.SummaryMapper;
import com.briefing.summary.model.Summary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SummaryServiceImpl implements SummaryService{
    // 按名称注入
    @Resource
    private SummaryMapper summaryMapper;

    @Override
    public Summary getSummaryById(String id) {
        return summaryMapper.getSummaryById(id);
    }

    @Override
    public List<Map<String,Object>> getSummaryListByPublishTime(String time) {
        List<Map<String,Object>> summaryList = summaryMapper.getSummaryListByPublishTime(time);
        for (Map<String, Object> summaryObject : summaryList) {
            List<Object> images = new JSONParser((String) summaryObject.get("images")).parseArray();
            String img_url = images.isEmpty()? "" : (String) images.get(0);
            if (!img_url.equals("")){
                String[] img_url_list = img_url.split("/");
                img_url="/"+img_url_list[6]+"/"+img_url_list[7]+"/"+img_url_list[8];
            }
            summaryObject.put("images",img_url);
        }
        return summaryList;
    }

    @Override
    public List<Map<String, Object>> getTitleListByPublishTime(String time) {
        return summaryMapper.getTitleListByPublishTime(time);
    }

}
