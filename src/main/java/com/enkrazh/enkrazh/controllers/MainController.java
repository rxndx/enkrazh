package com.enkrazh.enkrazh.controllers;

import com.enkrazh.enkrazh.model.DiscussionType;
import com.enkrazh.enkrazh.model.Discussions;
import com.enkrazh.enkrazh.model.Post;
import com.enkrazh.enkrazh.service.DiscussionService;
import com.enkrazh.enkrazh.service.PlayerProfileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MainController {
    private final PlayerProfileService playerProfileService;
    private final DiscussionService discussionService;


 /*   @Autowired
    public MainController(PlayerProfileService playerProfileService){
        this.playerProfileService = playerProfileService;
    }*/

    @GetMapping("/")
    public String hello(
           Model model
    ){
        List<Post> posts = discussionService.getPostsFromDiscussion(DiscussionType.NEWS)
                .stream()
                .sorted(Comparator.comparing(Post::getTime).reversed())
                .collect(Collectors.toList()).subList(0,6);



        //TODO: rewrite to stream->sort->type==IMPORTANT -> to string

        model.addAttribute("important_news",posts.get(0).getText());
        model.addAttribute("posts",posts);

        model.addAttribute("quantity", playerProfileService.getQuantityProfiles());

        return "index";
    }




   /* @GetMapping("/profiles")
    public List<PlayerProfile> getAllProfiles(){
        return playerProfileService.getAllProfiles();
    }

    @GetMapping("/history")
    public ResponseEntity<PlayerProfile> getLoginHistoryById (@RequestParam(value = "id") int id){
        Optional<PlayerProfile> history = playerProfileService.getLoginHistoryById(id);

        return history.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }*/
}
