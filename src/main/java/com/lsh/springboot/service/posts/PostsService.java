package com.lsh.springboot.service.posts;

import com.lsh.springboot.domain.posts.Posts;
import com.lsh.springboot.domain.posts.PostsRepository;
import com.lsh.springboot.web.dto.PostsResponseDto;
import com.lsh.springboot.web.dto.PostsSaveRequestDto;
import com.lsh.springboot.web.dto.PostsUpdateReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto reqDto) {
        return postsRepository.save(reqDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateReqDto reqDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글은 없다." + id));
        posts.update(reqDto.getTitle(), reqDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글은 없다." + id));
        return new PostsResponseDto(posts);
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글은 없다." + id));
        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsResponseDto::new).collect(Collectors.toList());
    }
}
