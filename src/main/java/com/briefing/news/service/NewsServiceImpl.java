package com.briefing.news.service;

import com.briefing.news.dao.NewsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService{
    @Resource
    NewsMapper newsMapper;

    @Override
    public List<Map<String, Object>> countNewsList() {
        return newsMapper.countNewsList();
    }
}
