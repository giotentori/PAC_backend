package com.example.pacbackend.Vestito;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// classe che configura un'entita del database con un esempio di vestito

@Configuration
public class VestitoConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(VestitoRepository repository){
            return args -> {
              Vestito maglietta = new Vestito(1, "M", "giallo", "inverno","maglietta gialla invernale (non so nemmeno se esista una maglietta invernale)" /* , null*/);
            
            repository.saveAll(List.of(maglietta));
            };
        }
}