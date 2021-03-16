package com.briefing.summary.service;

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
    public List<Summary> getSummaryListByPublishTime(String time) {
        return summaryMapper.getSummaryListByPublishTime(time);
    }

    @Override
    public List<Map<String, Object>> getTitleListByPublishTime(String time) {
        return summaryMapper.getTitleListByPublishTime(time);
    }

}
