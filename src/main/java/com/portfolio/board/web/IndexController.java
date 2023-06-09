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
    //Spring MVC 템플릿 엔진 머스테치 활용하여 사용. veiw파일 mustache 있어야합니다.
    //model에 내가 원하는 user.getName을 추가합니다.

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
    }//posts-save.mustahce
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {// id값을 받아, dto에 넣고 다시 view영역에
     // Model에서 뷰로 넘길때 데이터를 담아서 전달
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        //post이름으로 dto객체에 접근해서 데이터를 출력
        return "posts-update"; //posts-update.mustache찾게됨.
    }
}