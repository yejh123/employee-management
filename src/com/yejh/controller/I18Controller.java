package com.yejh.controller;/**
 * @author yejh
 * @create 2019-12_09 18:29
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: TODO
 **/

@Controller
public class I18Controller {
    @RequestMapping(value = "/toLoginPage")
    public String toLoginPage(){
        return "login";

    }
}
