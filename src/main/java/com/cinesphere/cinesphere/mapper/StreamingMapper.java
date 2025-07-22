package com.cinesphere.cinesphere.mapper;

import com.cinesphere.cinesphere.controller.request.StreamingRequest;
import com.cinesphere.cinesphere.controller.response.StreamingResponse;
import com.cinesphere.cinesphere.entity.Streaming;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    
    public static Streaming toStreaming(StreamingRequest streamingRequest){
        return Streaming
        .builder()
        .name(streamingRequest.name())
        .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse
        .builder()
        .id(streaming.getId())
        .name(streaming.getName())
        .build();
    }
}
