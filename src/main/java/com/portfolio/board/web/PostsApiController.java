package com.portfolio.board.web;
import com.portfolio.board.service.PostsService;
import com.portfolio.board.web.dto.PostsResponseDto;
import com.portfolio.board.web.dto.PostsSaveRequestDto;
import com.portfolio.board.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
//REST API제공 @Controller와 다르게 View를 반환하는 것이 아니라,
// HTTP 응답 바디에 직접 데이터를 쓰는 방식으로 작동하며, API를 구현하는데 적합합니다.
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")//Post요청
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        //요청으로 받은 API를 본문에 dto로 매핑하여 받습니다.
        return postsService.save(requestDto);
    }


    @PutMapping("/api/v1/posts/{id}")//Put요청
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {//Delete 요청
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")//Get요청
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }


}