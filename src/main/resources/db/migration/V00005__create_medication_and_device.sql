-- ============================================================================
-- ДЕТАЛИ ЛЕКАРСТВЕННЫХ ПРЕПАРАТОВ
-- ============================================================================

-- Таблица деталей для лекарственных препаратов
-- Содержит все специфические поля для лекарственных препаратов из Приложения №5
CREATE TABLE medication_details
(
    id         BIGSERIAL PRIMARY KEY,
    project_id BIGINT NOT NULL UNIQUE,
    FOREIGN KEY (project_id) REFERENCES projects (id) ON DELETE CASCADE
);

-- Таблица лекарственных форм (по Номенклатуре лекарственных форм)
-- Хранит иерархическую структуру лекарственных форм
CREATE TABLE medication_forms
(
    id        BIGSERIAL PRIMARY KEY,
    code      VARCHAR(20)  NOT NULL, -- Код формы (например, "1.1.1.1")
    name      VARCHAR(255) NOT NULL, -- Название формы
    parent_id BIGINT,                -- NULL для корневых категорий
    level     INT          NOT NULL, -- Уровень иерархии
    FOREIGN KEY (parent_id) REFERENCES medication_forms (id) ON DELETE CASCADE
);

-- Таблица связи лекарственных препаратов и лекарственных форм (многие ко многим)
CREATE TABLE medication_forms_link
(
    medication_detail_id BIGINT NOT NULL,
    form_id              BIGINT NOT NULL,
    PRIMARY KEY (medication_detail_id, form_id),
    FOREIGN KEY (medication_detail_id) REFERENCES medication_details (id) ON DELETE CASCADE,
    FOREIGN KEY (form_id) REFERENCES medication_forms (id) ON DELETE CASCADE
);

-- Справочник типов приоритетов для лекарств и медизделий
CREATE TABLE priority_types
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(50)  NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    description TEXT
);

-- Таблица связи между деталями лекарств и типами приоритетов
CREATE TABLE medication_priority_types
(
    medication_detail_id BIGINT NOT NULL,
    priority_id          BIGINT NOT NULL,
    PRIMARY KEY (medication_detail_id, priority_id),
    FOREIGN KEY (medication_detail_id) REFERENCES medication_details (id) ON DELETE CASCADE,
    FOREIGN KEY (priority_id) REFERENCES priority_types (id) ON DELETE CASCADE
);