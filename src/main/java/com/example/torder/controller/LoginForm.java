package com.example.torder.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
    private String id, password, nickname;
    private boolean user_state;
}
