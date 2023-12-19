CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE tokens (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    token VARCHAR(255) UNIQUE,
    token_type VARCHAR(255),
    revoked BOOLEAN,
    expired BOOLEAN,
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES _user_(id)
);
