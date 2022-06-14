package com.enkrazh.enkrazh.service;

import com.enkrazh.enkrazh.model.PlayerProfile;
import com.enkrazh.enkrazh.model.PlayerProfileDetailModel;
import com.enkrazh.enkrazh.repo.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PlayerProfileDetailsService implements UserDetailsService {

    private final PlayerProfileRepository playerProfileRepository;

    @Autowired
    public PlayerProfileDetailsService(PlayerProfileRepository playerProfileRepository) {
        this.playerProfileRepository = playerProfileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PlayerProfile playerProfile = playerProfileRepository.getPlayerProfileByUsername(username).orElseThrow(()
                -> new UsernameNotFoundException("User not found: check username"));
        return new PlayerProfileDetailModel(playerProfile);
    }
}
