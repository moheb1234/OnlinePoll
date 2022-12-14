package com.example.onlinepoll.service;

import com.example.onlinepoll.model.Option;
import com.example.onlinepoll.repository.OptionRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.Set;

@Service
@AllArgsConstructor
public class OptionService {
    private final OptionRepository optionRepository;

    @SneakyThrows
    public Option findById(long id) {
        return optionRepository.findById(id).orElseThrow(() -> new InstanceNotFoundException(""));
    }

    public void save(Option option) {
        optionRepository.save(option);
    }

    public void saveAll(Set<Option> options) {
        optionRepository.saveAll(options);
    }
}
