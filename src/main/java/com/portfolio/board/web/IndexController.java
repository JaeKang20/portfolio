package com.portfolio.board.web;
import com.portfolio.board.config.auth.LoginUser;
import com.portfolio.board.config.auth.dto.SessionUser;
import com.portfolio.board.service.PostsService;
import com.portfolio.board.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        if (user != null) {
            model.addAttribute("userName", user.getName());
            //로그인 성공하면 세션에 user 저장됩니다. 세션이 없으면 로그인 버튼이 보입니다.
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {//url은 id값을 받음
                    // Model은 컨트롤러에서 뷰로 넘길때 데이터를 담아서 전달
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        //post이름으로 dto객체에 접근해서 데이터를 출력
        return "posts-update"; //posts-update.mustache찾게됨.
    }
}