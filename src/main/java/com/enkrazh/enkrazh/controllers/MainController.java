package com.enkrazh.enkrazh.controllers;

import com.enkrazh.enkrazh.model.*;
import com.enkrazh.enkrazh.service.DiscussionService;
import com.enkrazh.enkrazh.service.PlayerProfileService;
import com.enkrazh.enkrazh.service.QuestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class MainController {
    private final PlayerProfileService playerProfileService;
    private final DiscussionService discussionService;
    private  final QuestService questService;




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
        model.addAttribute("quantity", playerProfileService.getQuantityProfiles());
        model.addAttribute("mavros_quantity",playerProfile.getMarvos());
        model.addAttribute("username",playerProfile.getUsername());
        model.addAttribute("admins",admins);
        model.addAttribute("players",players);
        model.addAttribute("discussions",discussions);
        model.addAttribute("quests",quests);





        return "profile_page";
    }



}
