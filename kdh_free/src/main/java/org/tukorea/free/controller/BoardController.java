package org.tukorea.free.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.service.PostService;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    @Qualifier("algoService")
    PostService algoPostService;

    @Autowired
    @Qualifier("dataService")
    PostService dataPostService;

    // 게시글 리스트 페이지
    @GetMapping("/{mode}")
    public String getBoardList(@PathVariable String mode, Model model) throws Exception {
        List<PostVO> voList = null;

        if (mode.equals("algo")) {
            // Algorithm 게시글 불러오기
            voList = algoPostService.readPostList();

            // Algorithm 게시판임을 확인
            model.addAttribute("mode", "algo");

        } else if (mode.equals("data")) {
            // DataStructure 게시글 불러오기
            voList = dataPostService.readPostList();

            // DataStructure 게시판임을 확인
            model.addAttribute("mode", "data");

        } else {
            throw new Exception("");
        }

        model.addAttribute("posts", voList);

        return "board_list";
    }

    // 게시글 등록 페이지
    @GetMapping("/write/{mode}")
    public String getBoardWrite(@PathVariable String mode, Model model) throws Exception {
        model.addAttribute("mode", mode);

        return "board_write";
    }

    // 게시글 등록
    @PostMapping("/write/{mode}")
    public String postBoardWrite(@PathVariable String mode, @ModelAttribute PostVO post, Principal principal) throws Exception {
        // 게시글 등록 날짜 설정
        post.setPostDate(new Date());

        // 로그인 상태여야 함
        if (principal == null) {
            throw new Exception("");
        }

        post.setUserId(principal.getName());

        if (mode.equals("algo")) {

            algoPostService.addPost(post);
        } else if (mode.equals("data")) {
            dataPostService.addPost(post);
        } else {
            throw new Exception("");
        }


        return "redirect:/board/" + mode;
    }

    // 게시글 조회
    @GetMapping("/{mode}/{id}")
    public String getBoardInfo(@PathVariable String mode, @PathVariable int id, Principal principal, Model model) throws Exception {
        // 로그인 해야 게시글 볼 수 있음
        if (principal == null) {
            throw new Exception();
        }

        PostVO vo = null;

        if (mode.equals("algo")) {
            vo = algoPostService.readPost(id);
            model.addAttribute("mode", "algo");
        } else if (mode.equals("data")) {
            vo = dataPostService.readPost(id);
            model.addAttribute("mode", "data");
        } else {
            throw new Exception("");
        }

        model.addAttribute("viewer", principal.getName());

        model.addAttribute("post", vo);

        return "board_view";
    }

    // 게시글 수정
    @GetMapping("/{mode}/modify")
    public String getBoardModifyCheck1(@PathVariable String mode, @RequestParam("id") int id, Model model, Principal principal) throws Exception {
        if (principal == null) {
            throw new Exception("");
        }

        PostVO vo = null;
        if (mode.equals("algo")) {
            vo = algoPostService.readPost(id);
        } else if (mode.equals("data")) {
            vo = dataPostService.readPost(id);
        } else {
            throw new Exception("");
        }

        model.addAttribute("post", vo);

        return "board_modify";
    }

    // 게시글 수정 POST
    @PostMapping("/{mode}/modify")
    public String postBoardModifyCheck2(@PathVariable String mode, @ModelAttribute PostVO vo, Principal principal) throws Exception {

        if (mode.equals("algo")) {
            algoPostService.updatePost(vo);
        } else if (mode.equals("data")) {
            dataPostService.updatePost(vo);
        } else {
            throw new Exception("");
        }

        return "redirect:/board/" + mode;
    }

    // 게시글 삭제
    // /free/board/${mode}/delete?id=${post.id}
    @GetMapping("/{mode}/delete")
    public String deleteBoardCheck1(@PathVariable String mode, @RequestParam("id") int id, Principal principal) throws Exception {
        if (mode.equals("algo")) {
            algoPostService.deletePost(id);
        } else if (mode.equals("data")) {
            dataPostService.deletePost(id);
        } else {
            throw new Exception("");
        }

        return "redirect:/board/" + mode;
    }

}
