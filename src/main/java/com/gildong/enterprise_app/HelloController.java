package com.gildong.enterprise_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("message", "엔터프라이즈 자바 JSP 렌더링 성공 🎉");
        model.addAttribute("name", "길동님");

        return "index";  // => /WEB-INF/views/index.jsp 로 연결됨
    }
}

