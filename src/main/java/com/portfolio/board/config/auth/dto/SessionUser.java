package com.portfolio.board.config.auth.dto;

import com.portfolio.board.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable { //User클래스가 Entity이기에 딸려오는 자식 Entity가 있을 수 있음.
    // 직렬화를 지원하는 dto클래스를 만듦.
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {//User 객체를 전달받아, 해당 객체에서 정보를 가져와서 SessionUser 객체를 생성.
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}