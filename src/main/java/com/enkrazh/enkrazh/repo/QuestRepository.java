package com.enkrazh.enkrazh.repo;

import com.enkrazh.enkrazh.model.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends JpaRepository<Quest,Integer> {

}