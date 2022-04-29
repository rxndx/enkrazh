package com.enkrazh.enkrazh.controllers;

import com.enkrazh.enkrazh.model.LoginHistory;
import com.enkrazh.enkrazh.model.PlayerProfile;
import com.enkrazh.enkrazh.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    private final PlayerProfileService playerProfileService;


    @Autowired
    public MainController(PlayerProfileService playerProfileService){
        this.playerProfileService = playerProfileService;
    }

    @GetMapping("/profiles")
    public List<PlayerProfile> getAllProfiles(){
        return playerProfileService.getAllProfiles();
    }

    @GetMapping("/history")
    public ResponseEntity<PlayerProfile> getLoginHistoryById (@RequestParam(value = "id") int id){
        Optional<PlayerProfile> history = playerProfileService.getLoginHistoryById(id);

        return history.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
