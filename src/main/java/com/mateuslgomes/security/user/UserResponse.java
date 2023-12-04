package com.mateuslgomes.security.user;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponse(

     UUID id,
     String firstName,
     String lastName,
     String email,
     Role role,
     Status status

) {}
