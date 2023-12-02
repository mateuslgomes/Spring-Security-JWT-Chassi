package com.mateuslgomes.security.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RegisterRequest(

    @Size(min = 2, max = 100)
    String firstName,

    @Size(min = 2, max = 100)
    String lastName,

    @Email
    @Size(max = 254)
    String email,

    @Size(min= 8, max = 254)
    String password

) {}
