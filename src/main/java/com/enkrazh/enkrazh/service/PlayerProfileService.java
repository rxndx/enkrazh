package com.enkrazh.enkrazh.service;

import com.enkrazh.enkrazh.model.PlayerProfile;
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
    private final PlayerProfileRepository repository;


    public  int getQuantityProfiles (){
        return (int) repository.count();
    }
    public List<PlayerProfile> getAllProfiles(){
        return  repository.findAll();
    }

    public Optional<PlayerProfile> getLoginHistoryById(int id){
        return repository.findById(id);
    }

}
