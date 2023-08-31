package com.example.pacbackend.Ordine;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.pacbackend.Users.User.User;

@Configuration
public class OrdineConfig {
    @Bean
    CommandLineRunner commandLineRunnerOrdine(OrdineRepository repository){
            return args -> {
              Ordine ordine1 = new Ordine(1,new User(3),new User(2));
              Ordine ordine2 = new Ordine(2,new User(1),new User(2));
              
            repository.saveAll(List.of(ordine1,ordine2));
            };
        }
}
