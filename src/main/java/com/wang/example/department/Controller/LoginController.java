package com.wang.example.department.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @RequestMapping("/user/login")
    public String Login(@RequestParam(name = "username")String username,
                        @RequestParam(name = "password")String password,
                        HttpServletRequest request,
                        Model model)
    {
        if (!username.isEmpty() && password.equals("123456")){
            request.getSession().setAttribute("loginUser",username);
          return "redirect:/dashboard";
        }
        else{
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }

    }




    @GetMapping("/user/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "index";
    }

}
