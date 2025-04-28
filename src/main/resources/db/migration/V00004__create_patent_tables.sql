-- Создание таблицы типов патентов
CREATE TABLE patent_types (
    id BIGSERIAL PRIMARY KEY,
    type_code VARCHAR(20) NOT NULL UNIQUE,
    type_name VARCHAR(50) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Создание таблицы патентов
CREATE TABLE patents (
    id BIGSERIAL PRIMARY KEY,
    project_id BIGINT NOT NULL,
    patent_type_id BIGINT NOT NULL,
    patent_number VARCHAR(100),
    expiry_date DATE,
    patent_owner_id BIGINT,
    application_number VARCHAR(100),
    filing_date DATE,
    applicant_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE,
    FOREIGN KEY (patent_type_id) REFERENCES patent_types(id),
    FOREIGN KEY (patent_owner_id) REFERENCES organizations(id),
    FOREIGN KEY (applicant_id) REFERENCES organizations(id)
);

-- Создание индексов
CREATE INDEX idx_patents_project_id ON patents(project_id);
CREATE INDEX idx_patents_patent_type_id ON patents(patent_type_id);
CREATE INDEX idx_patent_types_type_code ON patent_types(type_code);
CREATE INDEX idx_patent_types_type_name ON patent_types(type_name); 