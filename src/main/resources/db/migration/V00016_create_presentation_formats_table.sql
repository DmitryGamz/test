CREATE TABLE presentation_formats
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE project_presentation_formats
(
    project_id BIGINT NOT NULL,
    format_id  BIGINT NOT NULL,
    PRIMARY KEY (project_id, format_id),
    FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE,
    FOREIGN KEY (format_id) REFERENCES presentation_formats (id)
);

ALTER TABLE projects
    ADD COLUMN presentation_file_path VARCHAR(255);

INSERT INTO presentation_formats (name)
VALUES ('Презентация'),
       ('Выставочный образец'),
       ('Видео-ролик'),
       ('Буклет');