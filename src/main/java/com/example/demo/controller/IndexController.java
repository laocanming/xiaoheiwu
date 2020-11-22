package com.example.demo.controller;


import com.example.demo.po.Administration;
import com.example.demo.repository.AdministrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname IndexController
 * @Description TODO
 * @Date 2019-3-14 9:49
 * @Created by CrazyStone
 */
@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(com.example.demo.controller.IndexController.class);

    // 博客首页，会自动跳转到文章页
//    @GetMapping(value = "/")
//    private String index(HttpServletRequest request) {
//        return this.(request, 1, 5);
//    }
    @Autowired
    private AdministrationRepository administrationRepository;

//    @GetMapping("/")
//    public ModelAndView list (Model model
//           , @RequestParam(value = "current", required =
//           false, defaultValue = "1") Integer Statistic) {
//       model.addAttribute("page", administrationRepository.findAllCustomerByPage(Statistic, 10));
//        model.addAttribute("userList", administrationRepository.listStatistic());
////        model.addAttribute("title", "文章管理");
//        try {
////            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////            String name = auth.getName(); //get logged in username
////            model.addAttribute("username", name);
//        }
//       finally {
//            return new ModelAndView("index", "userModel", model);
//        }






        @GetMapping({"/","index"})
        public ModelAndView list(Model model, @RequestParam(value = "current", required =
                false, defaultValue = "1") Integer Statistic) {
            model.addAttribute("page", administrationRepository.findAllCustomerByPage(Statistic, 5));
            model.addAttribute("userList", administrationRepository.listStatistic());
//        model.addAttribute("title", "文章管理");
            try {
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                String name = auth.getName(); //get logged in username
                model.addAttribute("username", name);
            }finally {
                return new ModelAndView("index", "userModel", model);
            }

        }



    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Integer id, Model model) {
        List<Administration> user = administrationRepository.getAdministrationByid(id);
        Administration user2 = administrationRepository.getAdministrationById(id);
//        List<Comment> comment = customerMapper.findComment(id);
//        model.addAttribute("comment",comment);
        model.addAttribute("user2", user2);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看文章");
        return new ModelAndView("view", "userModel", model);
    }

//    @GetMapping("/admin")
//    public ModelAndView list(Model model) {
////        model.addAttribute("page", administrationRepository.findAllCustomerByPage(Statistic, 5));
//        model.addAttribute("userList", administrationRepository.listStatistic());
////        model.addAttribute("title", "文章管理");
//        try {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            String name = auth.getName(); //get logged in username
//            model.addAttribute("username", name);
//        }finally {
//            return new ModelAndView("admin1", "userModel", model);
//        }
//
//    }

}

