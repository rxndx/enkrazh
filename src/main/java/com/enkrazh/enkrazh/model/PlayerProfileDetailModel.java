package com.enkrazh.enkrazh.model;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@ToString
public class PlayerProfileDetailModel implements UserDetails {
    private final PlayerProfile playerProfile;

    public PlayerProfileDetailModel(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(playerProfile.getRole().name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return playerProfile.getPasswd();
    }

    @Override
    public String getUsername() {
        return playerProfile.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
