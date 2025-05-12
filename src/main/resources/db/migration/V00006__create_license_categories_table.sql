CREATE TABLE IF NOT EXISTS license_categories
(
    id              BIGSERIAL PRIMARY KEY,
    category_name   VARCHAR(512) NOT NULL,
    parent_category_id  BIGINT,
    FOREIGN KEY (parent_category_id) REFERENCES license_categories(id)
);