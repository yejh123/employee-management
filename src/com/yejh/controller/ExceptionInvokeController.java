package com.yejh.controller;/**
 * @author yejh
 * @create 2019-12_09 23:17
 */

import com.yejh.exception.UserNameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: TODO
 **/
@Controller
public class ExceptionInvokeController {
    @RequestMapping(value = "/exceptionTest")
    public String exceptionTest(@RequestParam(value = "i") Integer integer){
        int i = 10/integer;
        return "success";

    }

    @RequestMapping(value="/testResponseStatusExceptionResolver")
    public String testResponseStatusExceptionResolver(@RequestParam("userName") String userName){
        if(userName.equals("admin")){
            throw new UserNameNotFoundException();
        }
        System.out.println("testResponseStatusExceptionResolver...");
        return "success";
    }

    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(@RequestParam("i") int i){
        System.out.println("testSimpleMappingExceptionResolver...");
        String[] s = new String[10];
        System.out.println(s[i]);
        return "success";
    }
}
