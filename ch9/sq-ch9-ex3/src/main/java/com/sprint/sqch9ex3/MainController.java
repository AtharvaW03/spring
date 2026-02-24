package com.sprint.sqch9ex3;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;
    private final LoginProcessor loginProcessor;

    public MainController(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService,
                          LoginProcessor loginProcessor) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginPage() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean loggedIn = loginProcessor.login();

        if (loggedIn) {
            return "redirect:/main";
        }

        model.addAttribute("message", "Login failed. Incorrect credentials.");
        return "login.html";
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model model
    ){

        if(logout!=null){
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();
        int count = loginCountService.getCount();

        if(username==null){
            return "redirect:/";
        }

        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);
        return "main.html";
    }


}
