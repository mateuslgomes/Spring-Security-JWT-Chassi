package com.mateuslgomes.security.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record AuthenticationRequest(

    @Email
    String email,

    @Size(min= 8, max = 254)
    String password

) {}
