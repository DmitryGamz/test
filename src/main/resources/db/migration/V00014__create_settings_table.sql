CREATE TABLE settings
(
    id          BIGSERIAL PRIMARY KEY,
    key         VARCHAR(100) UNIQUE,
    value       TEXT NOT NULL,
    description VARCHAR(500),
    type        VARCHAR(20) CHECK (type IN ('STRING', 'NUMBER', 'BOOLEAN', 'JSON'))
);