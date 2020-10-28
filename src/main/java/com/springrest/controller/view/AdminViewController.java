package com.springrest.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminViewController {

    @GetMapping("/admin")
    public ModelAndView viewAdminCP() {
        return new ModelAndView("usertable");
    }

}
