package com.cinesphere.cinesphere.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cinesphere.cinesphere.entity.Streaming;
import com.cinesphere.cinesphere.repository.StreamingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StreamingService {
    
    private final StreamingRepository streamingRepository;

    public List<Streaming> getStreamings(){
        return streamingRepository.findAll();
    }

    public Streaming save(Streaming streaming){
        return streamingRepository.save(streaming);
    }


    public Optional<Streaming> getStreamingById(Long id){
        return streamingRepository.findById(id);
    }

    public void deleteStreaming(Long id){
        streamingRepository.deleteById(id);
    }

}
