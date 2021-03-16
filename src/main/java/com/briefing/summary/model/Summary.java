package com.briefing.summary.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Summary {
    String articleId;
    String title;
    String summary;
    String kw;
    String publishTime;
}
