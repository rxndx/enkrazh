package com.enkrazh.enkrazh.repo;

import com.enkrazh.enkrazh.model.PlayerProfile;
import com.enkrazh.enkrazh.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post,Integer> {

    @Modifying

    @Query(value = "delete from post where id= :idPost ", nativeQuery = true)
    void deletePOstById (@Param("idPost") int idPost);


}
