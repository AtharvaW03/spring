package com.sprint.sqch8ex4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home/{color}/{name}")
    //using path variables to specify colors
    public String home(@PathVariable String color, @PathVariable String name, Model page){
        page.addAttribute("username", name);
        page.addAttribute("color", color);

        return "home.html";
    }
}
