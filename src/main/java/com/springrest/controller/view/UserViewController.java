package com.springrest.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserViewController {

    @GetMapping("/user")
    public ModelAndView viewUserPage() {
        return new ModelAndView("user");
    }
}
