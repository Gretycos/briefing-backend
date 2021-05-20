package com.briefing.summary.service;

import com.briefing.summary.model.Summary;

import java.util.List;
import java.util.Map;

public interface SummaryService {
    String getLatestDate();

    List<Map<String,Object>> getSummaryListByPublishTime(String time);

    List<Map<String,Object>> getTitleListByPublishTime(String time);
}
