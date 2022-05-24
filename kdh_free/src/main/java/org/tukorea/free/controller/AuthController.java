package org.tukorea.free.controller;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.tukorea.free.domain.UserVO;

import java.util.Date;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @GetMapping("/sign_in")
    public String getLoginUser() throws Exception {
        return "sign_in";
    }

    @GetMapping("/sign_up")
    public String getEnrollUser() throws Exception {
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String postEnrollUser(@ModelAttribute UserVO userVO) throws Exception {
        userVO.setJoinDate(new Date());

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/free/rest/user";

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> requestMessage = new HttpEntity<>(userVO, httpHeaders);

        HttpEntity<String> response = restTemplate.postForEntity(url, requestMessage, String.class);

        System.out.println("RESPONSE from postEnrolUser : " + response);

        return "redirect:/auth/sign_up";
    }
}
