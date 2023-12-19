    package com.mateuslgomes.security.blacklist;

    import lombok.AllArgsConstructor;
    import org.springframework.stereotype.Service;
    import java.time.LocalDateTime;
    import java.util.Optional;

    @Service
    @AllArgsConstructor
    public class BlacklistTokenService {

        private final BlacklistTokenRepository blacklistTokenRepository;

        public void addToBlacklist(String userToken) {
            BlacklistToken blacklistToken = BlacklistToken.builder()
                    .userToken(userToken)
                    .revocationDate(LocalDateTime.now())
                    .build();
            blacklistTokenRepository.save(blacklistToken);
        }

        public boolean isTokenBlacklisted(String userToken) {
            Optional<BlacklistToken> blacklistedToken = blacklistTokenRepository.findByUserToken(userToken);
            return blacklistedToken.isPresent();
        }

        public void clearExpiredTokens() {
            blacklistTokenRepository.deleteByRevocationDateBefore(LocalDateTime.now().minusDays(1));
        }

    }
