package com.yejh.controller;/**
 * @author yejh
 * @create 2019-11_29 9:54
 */

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @description: TODO
 **/
@Controller
public class HttpMessageController {
    //@RequestBody:是将Http请求正文插入方法中，修饰目标方法的入参
    @RequestMapping("/testHttpMessageConverter")
    public String testHttpMessageConverter(@RequestBody String body) {
        System.out.println("body=" + body);
        return "success";  //不再查找跳转的页面
    }

    @RequestMapping("testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();

        //获取文件真实路径
        System.out.println(servletContext.getRealPath("/scripts/jquery-1.9.1.min.js"));

        //获取流
        InputStream resourceAsStream = servletContext.getResourceAsStream("/scripts/jquery-1.9.1.min.js");
        byte[] body = new byte[resourceAsStream.available()] ;
        resourceAsStream.read(body);

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=jquery-1.9.1.min.js");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return responseEntity ;
    }
}
