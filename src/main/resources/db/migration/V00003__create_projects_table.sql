-- Создание таблицы проектов
CREATE TABLE projects
(
    id                            BIGSERIAL PRIMARY KEY,
    user_id                       BIGINT       NOT NULL,
    project_name                  VARCHAR(255) NOT NULL,
    short_description             TEXT,
    technological_readiness_level INTEGER,
    application_scope             VARCHAR(50),
    status_id                     BIGINT,
    ipr_status_id                 BIGINT,
    ipr_valuation_exists          BOOLEAN   DEFAULT FALSE,
    commercial_status_id          BIGINT,
    commercial_effect             TEXT,
    market_perspective_id         BIGINT,
    novelty                       TEXT,
    key_differences               TEXT,
    export_potential              BOOLEAN   DEFAULT FALSE,
    production_requirement_id     BIGINT,
    completion_time_id            BIGINT,
    has_students_involved         BOOLEAN   DEFAULT FALSE,
    created_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at                    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_edit_by                  BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (last_edit_by) REFERENCES users (id)
);

-- Создание индексов
CREATE INDEX idx_projects_user_id ON projects (user_id);
CREATE INDEX idx_projects_status_id ON projects (status_id);
CREATE INDEX idx_projects_ipr_status_id ON projects (ipr_status_id);
CREATE INDEX idx_projects_commercial_status_id ON projects (commercial_status_id);
CREATE INDEX idx_projects_market_perspective_id ON projects (market_perspective_id);
CREATE INDEX idx_projects_production_requirement_id ON projects (production_requirement_id);
CREATE INDEX idx_projects_completion_time_id ON projects (completion_time_id);