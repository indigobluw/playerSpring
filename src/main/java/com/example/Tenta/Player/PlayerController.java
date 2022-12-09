package com.example.Tenta.Player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/player")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @GetMapping //#1
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping //#2
    public void registerNewPlayer(@RequestBody Player player) {
        playerService.addNewPlayer(player);
    }

    @DeleteMapping(path="{playerId}") //#3
    public void deletePlayer(@PathVariable("playerId") Long playerId) {
        playerService.deletePlayer(playerId);
    }

    @PutMapping(path="{playerId}") //#4
    public void updatePlayer(@PathVariable("playerId") Long playerId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) Integer score){
        playerService.updatePlayer(playerId, name, score);
    }

}
