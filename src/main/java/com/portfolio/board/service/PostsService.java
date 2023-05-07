package com.portfolio.board.service;

import com.portfolio.board.domain.posts.Posts;
import com.portfolio.board.domain.posts.PostsRepository;
import com.portfolio.board.web.dto.PostsListResponseDto;
import com.portfolio.board.web.dto.PostsResponseDto;
import com.portfolio.board.web.dto.PostsSaveRequestDto;
import com.portfolio.board.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {//게시글과 관련된 비즈니스 로직
    private final PostsRepository postsRepository;
//PostsRepository 클래스 주입받음.

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    //requestDto를 Entity로 변환 후 DB에 저장하고, 저장된 Entity의 ID를 반환
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        // 해당 Entity의 데이터를 업데이트한다.
        return id;
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts); // 해당 Entity의 데이터를 삭제한다.
    }
    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts postsEntity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(postsEntity);// Entity를 DTO로 변환하여 반환한다.
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}