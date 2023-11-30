CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE _user_ (
    id UUID DEFAULT uuid_generate_v4(),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(254) UNIQUE NOT NULL,
    password VARCHAR(254) NOT NULL,
    PRIMARY KEY (id)
);
