package com.enkrazh.enkrazh.repo;

import com.enkrazh.enkrazh.model.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerProfileRepository extends JpaRepository<PlayerProfile,Integer> {
}
