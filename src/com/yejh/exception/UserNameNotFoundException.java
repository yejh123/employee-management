package com.yejh.exception;/**
 * @author yejh
 * @create 2019-12_09 23:09
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @description: TODO
 **/

@ResponseStatus(value= HttpStatus.FORBIDDEN,reason="用户名称和密码不匹配")
public class UserNameNotFoundException extends RuntimeException {

}
