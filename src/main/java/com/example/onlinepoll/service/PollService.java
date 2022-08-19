package com.example.onlinepoll.service;

import com.example.onlinepoll.model.Option;
import com.example.onlinepoll.model.Participant;
import com.example.onlinepoll.model.Poll;
import com.example.onlinepoll.repository.PollRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.bytebuddy.utility.RandomString;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PollService {
    private final PollRepository pollRepository;
    private final OptionService optionService;

    @SneakyThrows
    public Poll findByLink(String link) {
        Poll poll = pollRepository.findByLink(link).orElseThrow(() -> new InstanceNotFoundException("Not poll founded with link: " + link));
        Set<Participant> sortedParticipant = poll.getParticipants().stream().sorted(Comparator.comparing(Participant::getCreatedAt)).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Option> sortedOptions = poll.getOptions().stream().sorted(Comparator.comparing(Option::getId)).collect(Collectors.toCollection(LinkedHashSet::new));
        poll.setOptions(sortedOptions);
        poll.setParticipants(sortedParticipant);
        return poll;
    }

    public String create(Poll poll) {
        String link = RandomString.make(10);
        poll.setLink(link);
        save(poll);
        for (Option option : poll.getOptions()) {
            option.setPoll(poll);
            optionService.save(option);
        }
        return link;
    }

    public void save(Poll poll) {
        pollRepository.save(poll);
    }

    public String edit(String link, Poll newPoll) {
        Poll poll = findByLink(link);
        poll.setDescription(newPoll.getDescription());
        poll.setTitle(newPoll.getTitle());
        pollRepository.save(poll);
        return "poll updated successfully";
    }

    public List<Poll> findAll() {
        return pollRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }

    public String delete(String link) {
        Poll poll = findByLink(link);
        pollRepository.delete(poll);
        return "poll successfully deleted";
    }
}
