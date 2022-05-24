package com.enkrazh.enkrazh.repo;

import com.enkrazh.enkrazh.model.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile,Integer> {

     //Optional<Integer> getPlayerProfileQuantity();
}
