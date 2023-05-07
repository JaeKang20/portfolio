package com.portfolio.board.config.auth.dto;

import com.portfolio.board.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable { //User클래스를 사용하지 않은 이유는 직렬화 안되서
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {//User 객체를 전달받아, 해당 객체에서 정보를 가져와서 SessionUser 객체를 생성합니다.
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}