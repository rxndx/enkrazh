package com.enkrazh.enkrazh.repo;

import com.enkrazh.enkrazh.model.PlayerProfile;
import com.enkrazh.enkrazh.model.PlayerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile,Integer> {

    Optional<PlayerProfile> getPlayerProfileByUsername(String username);

    Optional<PlayerProfile> getPlayerProfileById(int accountId);

    Optional<List<PlayerProfile>> getPlayerProfileByRole (PlayerRole role);
}
