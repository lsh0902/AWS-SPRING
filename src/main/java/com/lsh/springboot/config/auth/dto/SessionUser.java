package com.lsh.springboot.config.auth.dto;

import com.lsh.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//인증된 사용자 정보만 있으면 됨.
//세션에 저장하려면 직렬화 해야됨. 엔티티를 직렬화 한다? 이건 문제가 있을 수 있음
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
