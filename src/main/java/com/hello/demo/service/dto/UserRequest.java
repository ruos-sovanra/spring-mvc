package com.hello.demo.service.dto;

import lombok.Builder;

@Builder
public record UserRequest(
        String name,
        String email,
        String password
) {
}
