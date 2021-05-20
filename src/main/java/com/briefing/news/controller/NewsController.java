package com.briefing.news.controller;

import com.briefing.news.service.NewsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    NewsService newsService;

    @RequestMapping(value = "/countList",method = RequestMethod.POST)
    public List<Map<String, Object>> countNewsList(){
        return newsService.countNewsList();
    }

}
