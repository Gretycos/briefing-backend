package com.briefing.news.controller;

import com.briefing.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {
    private NewsService newsService;

    @Autowired
    public void setNewsService(NewsService newsService){
        this.newsService = newsService;
    }

    @RequestMapping(value = "/countList",method = RequestMethod.POST)
    public List<Map<String, Object>> countNewsList(){
        return newsService.countNewsList();
    }

}
