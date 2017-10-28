package com.cibird.demo.token.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>TODO</p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author cuiyh9
 * @version 1.0
 * @Date Created in 2017年10月28日 14:39
 * @since 1.0
 */
@Controller
public class LoginController {

    @RequestMapping("/test")
    @ResponseBody
    public String  test() {
        return "hello World";
    }
}
