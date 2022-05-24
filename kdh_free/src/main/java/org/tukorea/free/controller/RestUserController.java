package org.tukorea.free.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.exception.UserNotFoundException;
import org.tukorea.free.service.UserService;

import java.net.URI;

@RequestMapping(value = "/rest/user")
@RestController
public class RestUserController {
    @Autowired
    UserService userService;

    // 사용자 조회
    @GetMapping(value = "/{id}")
    public UserVO retrieveUser(@PathVariable String id) throws Exception {
        UserVO userVO = userService.readUser(id);

        if (userVO == null) {
            new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return userVO;
    }

    // 사용자 등록
    @PostMapping()
    public ResponseEntity<UserVO> enrollUser(@RequestBody UserVO vo) throws Exception {

//        System.out.println(vo.getJoinDate());
        // 추가하는 메소드
        userService.addUser(vo);

        // ResponseEntity 반환
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(vo.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // 사용자 삭제
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserVO> enrollUser(@PathVariable String id) throws Exception {
        userService.deleteUser(id);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
