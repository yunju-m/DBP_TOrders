package com.example.torder.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String id, password, nickname;
    private boolean user_state;

    public void drop() {
        id = "";
        password = "";
        nickname = "";
    }
}
