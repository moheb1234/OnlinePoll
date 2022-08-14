package com.example.onlinepoll.service;

import com.example.onlinepoll.model.Option;
import com.example.onlinepoll.model.Participant;
import com.example.onlinepoll.model.Poll;
import com.example.onlinepoll.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    private final PollService pollService;
    private final OptionService optionService;

    public Participant create(Participant participant, List<Long> selectedOptionsId) {
        Poll poll;
        for (Long optionId : selectedOptionsId) {
            Option option = optionService.findById(optionId);
            poll = option.getPoll();
            participant.getChoices().add(option);
            participant.setPoll(poll);
            poll.getParticipants().add(participant);

        }
        return participantRepository.save(participant);
    }
}
