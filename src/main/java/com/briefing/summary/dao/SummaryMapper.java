package com.briefing.summary.dao;

import com.briefing.summary.model.Summary;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface SummaryMapper {
    @Select("select * from news_summary where article_id = #{id}")
    Summary getSummaryById(@Param("id") String id);

    @Select("select * from " +
            "news_summary " +
            "where DATE_FORMAT(publish_time,'%Y-%m-%d') = #{time} " +
            "order by publish_time desc")
    List<Summary> getSummaryListByPublishTime(@Param("time") String time);

    @Select("select title " +
            "from news_summary " +
            "where DATE_FORMAT(publish_time,'%Y-%m-%d') = #{time} " +
            "order by publish_time desc")
    List<Map<String,Object>> getTitleListByPublishTime(@Param("time") String time);

}
