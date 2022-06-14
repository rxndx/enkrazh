package com.enkrazh.enkrazh.service;

import com.enkrazh.enkrazh.model.Post;
import com.enkrazh.enkrazh.repo.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {

    public PostRepository postRepository;

    public void deletePostById(int id){
        postRepository.deletePOstById(id);
    }

    public Post getPostById(int postId){
        return postRepository.findById(postId).orElseThrow();
    }


    public void publishPost(Post post){
        postRepository.save(post);
    }

}
