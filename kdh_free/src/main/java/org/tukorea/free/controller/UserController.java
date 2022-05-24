package org.tukorea.free.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/detail")
    public String getUserDetail(Model model, Principal principal) throws Exception {
        if (principal == null) {
            throw new Exception("");
        }

        String userId = principal.getName();
        UserVO vo = userService.readUser(userId);

        model.addAttribute("user", vo);
        return "user_detail";
    }
}
