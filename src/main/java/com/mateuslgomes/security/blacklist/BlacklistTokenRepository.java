package com.mateuslgomes.security.blacklist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface BlacklistTokenRepository extends JpaRepository<BlacklistToken, UUID> {

    Optional<BlacklistToken> findByUserToken(String userToken);

    void deleteByRevocationDateBefore(LocalDateTime now);

}
