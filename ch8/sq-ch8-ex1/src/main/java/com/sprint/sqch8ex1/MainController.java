package com.sprint.sqch8ex1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home") // we assign the controller's action to an http request path
    public String home(Model page){ //the action method defines param Model
        //which stores the data the controller sends to the view

        //now we add the data we want the controller to send to the view
        page.addAttribute("username", "Atharva");
        page.addAttribute("color", "red");
        return "home.html";
    }
}
