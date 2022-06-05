package com.enkrazh.enkrazh.service;

import com.enkrazh.enkrazh.model.PlayerProfile;
import com.enkrazh.enkrazh.model.PlayerRole;
import com.enkrazh.enkrazh.repo.PlayerProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerProfileService {

    @Autowired
    private final PlayerProfileRepository playerProfileRepository;


    public  int getQuantityProfiles (){
        return (int) playerProfileRepository.count();
    }
    public List<PlayerProfile> getAllProfiles(){
        return  playerProfileRepository.findAll();
    }

    public List<PlayerProfile> getProfilesByRole(PlayerRole role) throws Exception {
        return   playerProfileRepository.getPlayerProfileByRole(role).orElseThrow( () -> new Exception(
                "Players not found"
        ));
    }

    public Optional<PlayerProfile> getLoginHistoryById(int id){
        return playerProfileRepository.findById(id);
    }

    public PlayerProfile getPlayer (int profileId) throws Exception {

        return  playerProfileRepository.getPlayerProfileById(profileId).orElseThrow( () -> new Exception(
                "User not found: check id"
        ));
      }

}
