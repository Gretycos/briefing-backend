package com.briefing.news.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface NewsMapper {
    @Select("select * from (select publish_date as date, kw_date, nums " +
            "from news_info " +
            "order by date desc " +
            "limit 60 ) as t1 " +
            "order by date asc ")
    List<Map<String,Object>> countNewsList();
}
