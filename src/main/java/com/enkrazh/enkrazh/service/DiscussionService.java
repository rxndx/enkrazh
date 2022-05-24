package com.enkrazh.enkrazh.service;

import com.enkrazh.enkrazh.model.DiscussionType;
import com.enkrazh.enkrazh.model.Discussions;
import com.enkrazh.enkrazh.model.Post;
import com.enkrazh.enkrazh.repo.DiscussionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiscussionService {

    @Autowired
    private DiscussionsRepository repository;

    public List<Post> getPostsFromDiscussion(DiscussionType type){

        //TODO: add warning if quantity of  posts <5
        return repository.findDiscussionsByType(type).getPosts();

    }
}
