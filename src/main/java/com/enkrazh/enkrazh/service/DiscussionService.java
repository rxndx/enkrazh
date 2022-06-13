package com.enkrazh.enkrazh.service;

import com.enkrazh.enkrazh.model.DiscussionType;
import com.enkrazh.enkrazh.model.Discussions;
import com.enkrazh.enkrazh.model.Post;
import com.enkrazh.enkrazh.repo.DiscussionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DiscussionService {

    @Autowired
    private DiscussionsRepository repository;

    public List<Post> getPostsFromDiscussion(DiscussionType type) throws Exception{
       return repository.findDiscussionsByType(type).orElseThrow( () -> new Exception(
               "Discussion not found"
       )).get(0).getPosts();
    }

    public List<Discussions> getDiscussions(){
        return repository.findAll();
    }
    public List<Post> getNews() throws Exception {
        List<Post> posts = new ArrayList<>();
        try {
            posts= getPostsFromDiscussion(DiscussionType.NEWS)
                    .stream()
                    .sorted(Comparator.comparing(Post::getTime).reversed())
                    .collect(Collectors.toList());

            if(posts.size()>5) posts = posts.subList(0,5);

        } catch ( Exception e){
        }

        return  posts;
    }

    public Discussions getDiscussionById(int id){
        return repository.findDiscussionsById(id);
    }

    public void changeDiscussionName (int idDiscussion, String newName){
        repository.changeDiscussionName(idDiscussion,newName);
    }
}
