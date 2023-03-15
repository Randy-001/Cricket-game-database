package com.example.CricketgameDatabase.service;

import com.example.CricketgameDatabase.model.Sequence;
import com.example.CricketgameDatabase.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SequenceService {

    private SequenceRepository sequenceRepository;
    @Autowired
    public SequenceService(SequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    public int updateCounter(String sequenceName)
    {
        Optional<Sequence> studentsequence = this.sequenceRepository.findById(sequenceName);
        if (!studentsequence.isPresent()) {
            studentsequence = Optional.of(new Sequence());
            studentsequence.get().setId(sequenceName);
            studentsequence.get().setCounter(1);
        } else {
            int a = studentsequence.get().getCounter();
            a++;
            studentsequence.get().setCounter(a);
        }
        this.sequenceRepository.save(studentsequence.get());
        return studentsequence.get().getCounter();
    }
}
