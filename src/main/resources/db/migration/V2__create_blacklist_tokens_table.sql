CREATE TABLE blacklist_tokens (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    user_token VARCHAR(255) UNIQUE,
    revocation_date TIMESTAMP
);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
