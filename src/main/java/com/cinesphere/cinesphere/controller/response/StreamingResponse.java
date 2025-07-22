package com.cinesphere.cinesphere.controller.response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
    
}
