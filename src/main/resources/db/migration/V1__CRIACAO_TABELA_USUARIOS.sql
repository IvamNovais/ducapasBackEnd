CREATE SCHEMA securety
CREATE TABLE securety.users (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    login VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(255)
);