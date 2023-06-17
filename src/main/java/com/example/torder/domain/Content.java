package com.example.torder.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Content {
    private int PK_content_id, category_id;
    private String title, body, location, end_time;
    private boolean content_state;
}
