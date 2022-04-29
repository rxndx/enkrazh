package com.enkrazh.enkrazh.service;

import com.enkrazh.enkrazh.model.PlayerProfile;
import com.enkrazh.enkrazh.repo.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerProfileService {

    private final PlayerProfileRepository repository;

    @Autowired
    public PlayerProfileService (PlayerProfileRepository repository){
        this.repository = repository;
    }

    public List<PlayerProfile> getAllProfiles(){
        return  repository.findAll();
    }

    public Optional<PlayerProfile> getLoginHistoryById(int id){
        return repository.findById(id);
    }

}
