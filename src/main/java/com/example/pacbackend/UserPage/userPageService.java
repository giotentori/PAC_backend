package com.example.pacbackend.UserPage;

import org.springframework.stereotype.Service;

@Service
public class UserPageService {
    
    private final UserPageRepository userPageRepository;

    // @Autowired
    public UserPageService(UserPageRepository userPageRepository){
        this.userPageRepository = userPageRepository;
    }

    
}