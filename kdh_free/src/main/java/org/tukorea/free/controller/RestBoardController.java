package org.tukorea.free.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/rest/board")
public class RestBoardController {
    @Autowired
    @Qualifier("dataService")
    PostService dataPostService;

    @Autowired
    @Qualifier("algoService")
    PostService algoService;

    @GetMapping("/algo")
    public List<PostVO> retrieveAllAlgoPosts() throws Exception {
        List<PostVO> voList = algoService.readPostList();
        return voList;
    }


}
