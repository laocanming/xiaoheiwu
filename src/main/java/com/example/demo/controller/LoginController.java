package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Classname LoginController
 * @Description 用户登录模块
 */
@Controller
public class LoginController {
    // 向登录页面跳转，同时封装原始页面地址
//    @GetMapping(value = "/login")
//    public String login(HttpServletRequest request, Map map,Model model) {
//
//
//        // 分别获取请求头和参数url中的原始访问路径
//        String referer = request.getHeader("Referer");
//        String url = request.getParameter("url");
//        System.out.println("referer= "+referer);
//        System.out.println("url= "+url);
//
//        // 如果参数url中已经封装了原始页面路径，直接返回该路径
//        if (url!=null && !url.equals("")){
//            map.put("url",url);
//            // 如果请求头本身包含登录，将重定向url设为空，让后台通过用户角色进行选择跳转
//        }else if (referer!=null && referer.contains("/login")){
//            map.put("url", "");
//        }else {
//            // 否则的话，就记住请求头中的原始访问路径
//            map.put("url", referer);
//        }
//        return "login";
//    }



      @GetMapping(value = "/login")
          public ModelAndView login(HttpSession session, Model model) {


          Authentication auth = SecurityContextHolder.getContext().getAuthentication();
          String name = auth.getName(); //get logged in username
          model.addAttribute("username", name);

          return new ModelAndView("/login");

//          return new ModelAndView("redirect:/");
          }
      }








