package com.example.pacbackend.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pacbackend.Users.User.UserService;


/**
 * Classe controller della login page
 * @author Tentori Giorgio
 */

@Controller
public class LoginController {
    
    private final LoginService loginService;
    
    // @Autowired
    public LoginController(LoginService loginService,UserService userService){
        this.loginService = loginService;
    }


    @GetMapping("/")
    public String home1(){
        return "home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }    

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

        String passwordDb = loginService.getPasswordByUsername(username);

        if(username.equals("") || password.equals("") || !passwordDb.equals(password)){
            return "error";

        }
        
        return "bacheca";
        
    }

}
