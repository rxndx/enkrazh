package com.enkrazh.enkrazh.repo;

import com.enkrazh.enkrazh.model.DiscussionType;
import com.enkrazh.enkrazh.model.Discussions;
import com.enkrazh.enkrazh.model.Quest;
import com.enkrazh.enkrazh.model.QuestMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestRepository extends JpaRepository<Quest,Integer> {

    Optional<List<Quest>> findQuestsByMode(QuestMode mode);

}