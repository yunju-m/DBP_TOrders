package com.example.torder.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewLoginForm {
    private String id, pswd1, pswd2, nickname;
    private boolean user_state;
}