package org.tukorea.free.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.tukorea.free.domain.PostVO;
import org.tukorea.free.service.PostService;

import java.security.Principal;

@Aspect
@Component
public class BoardAspect {
    @Autowired
    @Qualifier("algoService")
    PostService algoPostService;

    @Autowired
    @Qualifier("dataService")
    PostService dataPostService;

    @Pointcut(value = "execution(* *Check1(..))")
    private void pointcut1() {
    }

    @Pointcut(value = "execution(* *Check2(..))")
    private void pointcut2() {
    }

    @Before("pointcut1()")
    public void beforeMethod(JoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();

        Integer postId = null;
        Principal principal = null;

        for (Object arg : args) {
            if (arg instanceof Principal) {
                principal = (Principal) arg;
            }
            if (arg instanceof Integer) {
                postId = (Integer) arg;
            }
        }

        String mode = (String) args[0];
        // 아이디가 같아야만 진행가능
        if (mode.equals("algo")) {
            String postUserId = algoPostService.readPost(postId).getUserId();
            if (!principal.getName().equals(postUserId)) {
                throw new Exception("Not Allowed Request");
            }
        } else if (mode.equals("data")) {
            String postUserId = dataPostService.readPost(postId).getUserId();
            if (!principal.getName().equals(postUserId)) {
                throw new Exception("Not Allowed Request");
            }
        } else {
            throw new Exception("Not Allowed Request");
        }
    }

    @Before("pointcut2()")
    public void beforeMethod2(JoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();

        PostVO postVO = null;
        Principal principal = null;

        for (Object arg : args) {
            if (arg instanceof Principal) {
                principal = (Principal) arg;
            }
            if (arg instanceof PostVO) {
                postVO = (PostVO) arg;
            }
        }

        String mode = (String) args[0];
        // 아이디가 같아야만 진행가능
        if (mode.equals("algo")) {
            String postUserId = postVO.getUserId();
            if (!principal.getName().equals(postUserId)) {
                throw new Exception("Not Allowed Request");
            }
        } else if (mode.equals("data")) {
            String postUserId = postVO.getUserId();
            if (!principal.getName().equals(postUserId)) {
                throw new Exception("Not Allowed Request");
            }
        } else {
            throw new Exception("Not Allowed Request");
        }
    }
}
