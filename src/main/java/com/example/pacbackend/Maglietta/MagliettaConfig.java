package com.example.pacbackend.Maglietta;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// classe che configura un'entita del database con un esempio di Maglietta

@Configuration
public class MagliettaConfig {
    
    @Bean
    CommandLineRunner commandLineRunner1(MagliettaRepository repository){
            return args -> {
              Maglietta maglietta1 = new Maglietta(1, "M", "verde","V","descrizione");
              Maglietta maglietta2 = new Maglietta(1, "S", "giallo","U", "descrizione");
              Maglietta maglietta3 = new Maglietta(1, "M", "giallo","V","descrizione");
              Maglietta maglietta4 = new Maglietta(1, "XS", "rosso","V","descrizione");
              Maglietta maglietta5 = new Maglietta(1, "L", "blu","U","descrizione");
              Maglietta maglietta6 = new Maglietta(1, "XL", "bianco","V", "descrizione");

            repository.saveAll(List.of(maglietta1,maglietta2,maglietta3,maglietta4,maglietta5,maglietta6));
            };
        }
}
