package com.stt.controller;

import com.stt.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping(value = {"/", "/index.html", "/index"})
    public ModelAndView home() throws IOException {

        return new ModelAndView("login");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public void login(@RequestBody User user) {

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
//        token.setRememberMe(userValidate.getRememberme());
        try {
            SecurityUtils.getSubject().login(token);
            logger.info("登陆成功");
            System.out.println("登陆成功");
        } catch (UnknownAccountException uae) {
            logger.info("用户名为【" + token.getPrincipal() + "】不存在");
        } catch (IncorrectCredentialsException ice) {
            logger.info("用户名为【 " + token.getPrincipal() + " 】密码错误！");
        } catch (LockedAccountException lae) {
            logger.info("用户名为【" + token.getPrincipal() + " 】的账户锁定，请联系管理员。");
        } catch (DisabledAccountException dax) {
            logger.info("用户名为:【" + token.getHost() + "】用户已经被禁用.");
        } catch (ExcessiveAttemptsException eae) {
            logger.info("用户名为:【" + token.getHost() + "】的用户登录次数过多，有暴力破解的嫌疑.");
        } catch (ExpiredCredentialsException eca) {
            logger.info("用户名为:【" + token.getHost() + "】用户凭证过期.");
        } catch (AuthenticationException ae) {
            logger.info("用户名为:【" + token.getHost() + "】用户验证失败.");
        } catch (Exception e) {
            logger.info("别的异常信息。。。。具体查看继承关系");
        }


    }

}
