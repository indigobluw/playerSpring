package com.example.Tenta.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {

        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository
                .findPlayersByIdOrName(player.getId(), player.getName());
        if(playerOptional.isPresent()) {
            throw new IllegalStateException("Id and/or name taken");
        }
        playerRepository.save(player);
    }

    public void deletePlayer(Long playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new IllegalStateException("player with id: " + playerId + " does not exist");
        }
        playerRepository.deleteById(playerId);
    }
    @Transactional
    public void updatePlayer(Long playerId, String name, Integer score) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException(
                        "player with id: " + playerId + " does not exist"));
        if(name != null && name.length() > 0 && !Objects.equals(player.getName(), name)) {
            player.setName(name);
        }
        if(score != null && !Objects.equals(player.getScore(), score)) {
            player.setScore(score);
            }
        } }
