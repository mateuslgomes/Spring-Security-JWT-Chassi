package com.mateuslgomes.security.user;

import com.mateuslgomes.security.exceptions.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse getUserAuthenticated() {
        var email = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userRepository.findByEmail(email).get();

        var response = UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .status(user.getStatus());
        return response.build();
    }

    @Transactional
    public void deactivateUser(UUID id) {
        var user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setStatus(Status.DISABLE);
        } else {
            throw new ValidationException("User not found.");
        }
    }

}
