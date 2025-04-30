CREATE TABLE IF NOT EXISTS feedback
(
    id              BIGSERIAL PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    email           VARCHAR(255) NOT NULL,
    message         TEXT NOT NULL,
    is_processed    BOOLEAN DEFAULT FALSE,
    created_at      TIMESTAMP(0) DEFAULT CURRENT_TIMESTAMP,
    processed_by    BIGINT,
    processed_at    TIMESTAMP(0),
    FOREIGN KEY (processed_by) REFERENCES users (id)
);