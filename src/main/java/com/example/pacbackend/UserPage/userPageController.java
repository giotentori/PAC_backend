package com.example.pacbackend.UserPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserPageController {

    private final UserPageService userPageService;

    // @Autowired
    public UserPageController(UserPageService userPageService){
        this.userPageService = userPageService;
    }

    @GetMapping("/userPage")
    public String home(){
        return "userPage";
    }
}
