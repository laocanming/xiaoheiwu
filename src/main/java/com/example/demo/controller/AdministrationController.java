package com.example.demo.controller;

import com.example.demo.po.Administration;
import com.example.demo.repository.AdministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdministrationController {
    @Autowired
    private AdministrationRepository administrationRepository;

    /**
     * 查询用户
     */
//    @GetMapping({"/","index"})
//    public ModelAndView list(Model model, @RequestParam(value = "current", required =
//            false, defaultValue = "1") Integer Statistic) {
//        model.addAttribute("page", administrationRepository.findAllCustomerByPage(Statistic, 5));
//        model.addAttribute("userList", administrationRepository.listStatistic());
////        model.addAttribute("title", "文章管理");
//        try {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            String name = auth.getName(); //get logged in username
//            model.addAttribute("username", name);
//        }finally {
//            return new ModelAndView("index", "userModel", model);
//        }
//
//    }
    @GetMapping("/")
    public ModelAndView list (Model model
            , @RequestParam(value = "current", required =
            false, defaultValue = "1") Integer Statistic) {
        model.addAttribute("page", administrationRepository.findAllCustomerByPage(Statistic, 10));
        model.addAttribute("userList", administrationRepository.listStatistic());
        model.addAttribute("title", "文章管理");
        try {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            String name = auth.getName(); //get logged in username
//            model.addAttribute("username", name);
        }
        finally {
            return new ModelAndView("admin", "userModel", model);
        }
    }

    /**
     * 根据用户id查看用户
     */


    /**
     * 获取创建表单页面
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("users", new Administration());
        model.addAttribute("title", "创建文章");
        return new ModelAndView("form", "userModel", model);
    }

    /**
     * 保存或者更新用户，并返回用户列表
     */
    @PostMapping
    public ModelAndView saveOrUpdateUser(Administration user) {
        user = administrationRepository.saveOrUpdateAdministration(user);
        return new ModelAndView("redirect:/admin/");//重定向到list页面
    }

    /**
     * 修改用户跳转页面
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modifyUser(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("users", administrationRepository.getAdministrationById(id));
        model.addAttribute("title", "修改文章");
        return new ModelAndView("modify", "userModel", model);
    }


    /**
     * s删除用户，并返回用户列表
     */
    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Integer id) {
        administrationRepository.deleteAdministration(id);
        return new ModelAndView("redirect:/admin/");//重定向到list页面
    }




}

