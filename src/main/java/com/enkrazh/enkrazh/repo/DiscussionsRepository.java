package com.enkrazh.enkrazh.repo;

import com.enkrazh.enkrazh.model.Character;
import com.enkrazh.enkrazh.model.DiscussionType;
import com.enkrazh.enkrazh.model.Discussions;
import com.enkrazh.enkrazh.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DiscussionsRepository extends JpaRepository<Discussions,Integer> {

    Optional<List<Discussions>> findDiscussionsByType(DiscussionType type);
    Discussions findDiscussionsById(int id);

    @Modifying
    @Query(value = "update discussion set name = :newName where id= :idDiscussion", nativeQuery = true)
    void changeDiscussionName (@Param("idDiscussion") int idDiscussion, @Param("newName") String newName);
}