package com.example.Tenta.Player;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {
    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository) {
        return args -> {
            Player bonan = new Player ("Bönan", 15);
            Player zoom = new Player("Zoom", 3);
            Player zlatan = new Player("Zlatan", 8);

            repository.saveAll(List.of(bonan, zoom, zlatan));
        };

    }
}
