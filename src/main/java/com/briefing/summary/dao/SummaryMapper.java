package com.briefing.summary.dao;

import com.briefing.summary.model.Summary;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface SummaryMapper {
    @Select("select * from news_summary where article_id = #{id}")
    Summary getSummaryById(@Param("id") String id);

    @Select("select " +
                "t1.article_id as article_id," +
                "t1.title as title," +
                "t1.summary as summary," +
                "t1.kw as kw," +
                "t1.publish_time as publish_time," +
                "t2.url as url," +
                "t2.images as images " +
            "from news_summary as t1 " +
                "left join (select article_id,url,images " +
                            "from news " +
                            "where article_id in (select article_id " +
                                                "from news_summary " +
                                                "where DATE_FORMAT(publish_time,'%Y-%m-%d') = #{time})" +
                            ") as t2 " +
            "on t1.article_id=t2.article_id " +
            "where DATE_FORMAT(t1.publish_time,'%Y-%m-%d') = #{time} " +
            "order by t1.publish_time desc")
    List<Map<String,Object>> getSummaryListByPublishTime(@Param("time") String time);

    @Select("select title " +
            "from news_summary " +
            "where DATE_FORMAT(publish_time,'%Y-%m-%d') = #{time} " +
            "order by publish_time desc")
    List<Map<String,Object>> getTitleListByPublishTime(@Param("time") String time);

}
