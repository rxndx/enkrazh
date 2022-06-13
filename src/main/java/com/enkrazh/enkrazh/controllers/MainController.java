package com.enkrazh.enkrazh.controllers;

import com.enkrazh.enkrazh.model.*;
import com.enkrazh.enkrazh.service.DiscussionService;
import com.enkrazh.enkrazh.service.PlayerProfileService;
import com.enkrazh.enkrazh.service.PostService;
import com.enkrazh.enkrazh.service.QuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@Transactional
public class MainController {
    private final PlayerProfileService playerProfileService;
    private final DiscussionService discussionService;
    private  final QuestService questService;

private  final PostService postService;


    @GetMapping("/")
    public String loadWelcomePage(
           Model model
    ) throws Exception {

        List<Post> posts = discussionService.getNews();

        model.addAttribute("important_news",posts.get(0).getText());
        model.addAttribute("posts",posts);

        model.addAttribute("quantity", playerProfileService.getQuantityProfiles());

        return "index";
    }


    @GetMapping("/profile")
    public String loadAccountPage(@RequestParam(value = "id") int accountId,
                                 Model model
    ) throws Exception {

        PlayerProfile playerProfile = playerProfileService.getPlayer(accountId);
        List<Post> posts = discussionService.getNews();
        List<PlayerProfile> players = playerProfileService.getProfilesByRole(PlayerRole.PLAYER);
        List<PlayerProfile> admins = playerProfileService.getProfilesByRole(PlayerRole.ADMIN);

        List<Discussions> discussions = discussionService.getDiscussions();
        if(discussions.size()>5) discussions=discussions.subList(0,5);

        List <Quest> quests = questService.getQuestsByMode(QuestMode.ACTIVE);

        model.addAttribute("posts",posts);
        model.addAttribute("user",playerProfile);
        model.addAttribute("quantity", playerProfileService.getQuantityProfiles());
        model.addAttribute("admins",admins);
        model.addAttribute("players",players);
        model.addAttribute("discussions",discussions);
        model.addAttribute("quests",quests);


        return "profile_page";
    }

    @GetMapping("/profile/{userId}/discussion")
    public String loadDiscussion(@PathVariable(value = "userId") int accountId,
                                 @RequestParam(value = "id") int discussionId,
                                  Model model) throws Exception {


        PlayerProfile playerProfile = playerProfileService.getPlayer(accountId);
        Discussions discussion = discussionService.getDiscussionById(discussionId);

        List<Post> posts = discussion.getPosts();

        model.addAttribute("quantity", playerProfileService.getQuantityProfiles());
        model.addAttribute("user",playerProfile);
        model.addAttribute("discussion",discussion);
        model.addAttribute("posts",posts);



        return "discussion";
    }

    @GetMapping(value="/profile/{userId}/discussion/{discId}/post/{id}")
    public String deletePost(@PathVariable(value = "userId") int accountId,
                             @PathVariable(value = "discId") int discId,
                             @PathVariable(value = "id") int postId,
                             Model model) throws Exception {
        if(playerProfileService.getPlayer(accountId).getRole()==PlayerRole.ADMIN || postService.getPostById(postId).getPlayer().getId() ==accountId)
        postService.deletePostById(postId);

        return "redirect:/profile/"+accountId+"/discussion?id=" + discId;
    }

    @PostMapping(value="/profile/{userId}/discussion/{discId}")
    public String makePost(@PathVariable(value = "userId") int accountId,
                           @PathVariable(value = "discId") int discId,
                           @RequestParam String post) throws Exception {


        Date date = new Date(System.currentTimeMillis());
        Post newPost = new Post(post,"POST",date,playerProfileService.getPlayer(accountId),discussionService.getDiscussionById(discId));

        postService.publishPost(newPost);

        return "redirect:/profile/"+accountId+"/discussion?id=" + discId;
    }


}
