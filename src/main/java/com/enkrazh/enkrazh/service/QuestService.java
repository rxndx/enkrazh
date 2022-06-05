package com.enkrazh.enkrazh.service;

import com.enkrazh.enkrazh.model.DiscussionType;
import com.enkrazh.enkrazh.model.Post;
import com.enkrazh.enkrazh.model.Quest;
import com.enkrazh.enkrazh.model.QuestMode;
import com.enkrazh.enkrazh.repo.QuestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestService {

    private QuestRepository questRepository;
    public List<Quest> getQuestsByMode( QuestMode mode) throws Exception {
        return questRepository.findQuestsByMode(mode).orElseThrow(()-> new Exception(
                "Quests dont find"
        ));

    }
}
