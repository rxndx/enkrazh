package com.enkrazh.enkrazh.repo;

import com.enkrazh.enkrazh.model.Character;
import com.enkrazh.enkrazh.model.DiscussionType;
import com.enkrazh.enkrazh.model.Discussions;
import com.enkrazh.enkrazh.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiscussionsRepository extends JpaRepository<Discussions,Integer> {

    Discussions findDiscussionsByType(DiscussionType type);
}