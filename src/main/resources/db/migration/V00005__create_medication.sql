-- ============================================================================
-- ДЕТАЛИ ЛЕКАРСТВЕННЫХ ПРЕПАРАТОВ
-- ============================================================================

-- Таблица областей применения
-- Общие области применения для лекарственных препаратов
CREATE TABLE application_areas_medication
(
    id        BIGSERIAL PRIMARY KEY,
    code      VARCHAR(20)  NOT NULL UNIQUE, -- Код формы (например, "B20-B24")
    name      VARCHAR(255) NOT NULL,
    parent_id BIGINT,                       -- NULL для корневых категорий
    level     INT          NOT NULL,        -- Уровень иерархии
    FOREIGN KEY (parent_id) REFERENCES application_areas_medication (id) ON DELETE CASCADE
);

-- Таблица УГТ (уровней готовности технологии)
-- Хранит описания уровней готовности технологии для лекарственных препаратов
CREATE TABLE medication_technology_readiness_levels
(
    id          BIGSERIAL PRIMARY KEY,
    level       INT  NOT NULL, -- Числовое значение уровня (от 1 до 9)
    description TEXT NOT NULL  -- Описание уровня
);

-- Таблица деталей для лекарственных препаратов
-- Содержит все специфические поля для лекарственных препаратов из Приложения №5
CREATE TABLE medication_details
(
    id                            BIGINT PRIMARY KEY,
    technological_readiness_level_id BIGINT NOT NULL, -- Уровень готовности технологии (УГТ)

    FOREIGN KEY (id) REFERENCES projects (id) ON DELETE CASCADE,
    FOREIGN KEY (technological_readiness_level_id) REFERENCES medication_technology_readiness_levels (id) ON DELETE NO ACTION
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

-- Таблица связи между деталями лекарств и типами приоритетов
CREATE TABLE medication_application_areas_link
(
    medication_detail_id            BIGINT NOT NULL,
    application_areas_medication_id BIGINT NOT NULL,
    PRIMARY KEY (medication_detail_id, application_areas_medication_id),
    FOREIGN KEY (medication_detail_id) REFERENCES medication_details (id) ON DELETE CASCADE,
    FOREIGN KEY (application_areas_medication_id) REFERENCES application_areas_medication (id) ON DELETE CASCADE
);