package com.example.onlinepoll.service;

import com.example.onlinepoll.model.Option;
import com.example.onlinepoll.model.Poll;
import com.example.onlinepoll.repository.PollRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;

@Service
@AllArgsConstructor
public class PollService {
    private final PollRepository pollRepository;
    private final OptionService optionService;

    @SneakyThrows
    public Poll findByLink(String link) {
        return pollRepository.findByLink(link).orElseThrow(() -> new InstanceNotFoundException(""));
    }

    public String create(Poll poll) {
        String link = RandomString.make(10);
        poll.setLink(link);
        optionService.saveAll(poll.getOptions());
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
}
