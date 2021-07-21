package com.gik.market.market.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/about")
    public String about(Model uiModel) {
        uiModel.addAttribute("name", "Guest");
        return "/about";
    }
}
