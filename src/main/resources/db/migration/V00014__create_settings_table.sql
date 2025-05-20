CREATE TABLE settings
(
    id          BIGSERIAL PRIMARY KEY,
    value       TEXT NOT NULL,
    description VARCHAR(500),
    type        VARCHAR(20) CHECK (type IN ('STRING', 'NUMBER', 'BOOLEAN', 'JSON'))
);