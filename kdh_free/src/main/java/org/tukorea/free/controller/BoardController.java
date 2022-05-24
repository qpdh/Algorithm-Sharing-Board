package org.tukorea.free.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.service.PostService;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    @Qualifier("algoService")
    PostService algoPostService;

    @GetMapping("/algo")
    public String getAlgo(Model model) throws Exception {
        List<PostVO> voList = algoPostService.readPostList();

        model.addAttribute("posts", voList);

        return "board";
    }

    @GetMapping("/data")
    public String getData() {
        return "board";
    }
}
