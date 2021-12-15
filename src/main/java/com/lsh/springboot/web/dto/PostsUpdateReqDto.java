package com.lsh.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateReqDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateReqDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
