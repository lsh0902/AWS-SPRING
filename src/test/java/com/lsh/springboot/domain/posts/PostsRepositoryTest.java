package com.lsh.springboot.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void clean() {
        postsRepository.deleteAll();
    }

    @Test
    public void 저장_불러오기() {
        String title = "게시글글글";
        String content = "본문";

        postsRepository.save(
                Posts.builder()
                        .title(title)
                        .content(content)
                        .build());
        //when
        List<Posts> postList = postsRepository.findAll();
        Posts posts = postList.get(0);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getTitle()).isEqualTo(title);
    }

    @Test
    public void BaseTimeEntity등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2021, 12, 15,0,0,0);
        postsRepository.save(Posts.builder()
                        .title("ti")
                        .content("내용")
                        .author("author")
                .build());
        //when
        List<Posts> list = postsRepository.findAll();
        Posts posts = list.get(0);

        System.out.println();

        //then
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }


}