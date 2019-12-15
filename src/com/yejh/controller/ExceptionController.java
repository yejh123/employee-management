package com.yejh.controller;/**
 * @author yejh
 * @create 2019-12_09 22:17
 */

import com.yejh.exception.UserNameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: TODO
 **/

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value = {ArithmeticException.class})
    public ModelAndView handleException(Exception ex){
        ModelAndView modelAndView = new ModelAndView("exception");
        modelAndView.addObject("exception", ex);
        return modelAndView;
    }
}
