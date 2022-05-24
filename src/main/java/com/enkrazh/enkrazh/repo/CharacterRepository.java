package com.enkrazh.enkrazh.repo;

import com.enkrazh.enkrazh.model.Character;
import com.enkrazh.enkrazh.model.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Integer> {
}
