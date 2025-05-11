-- ============================================================================
-- ДЕТАЛИ МЕДИЦИНСКИХ ИЗДЕЛИЙ
-- ============================================================================

-- Таблица областей применения
-- Общие области применения для медицинских устройств
CREATE TABLE application_areas_device
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

-- Таблица оценки востребованности для здравоохранения устройства
CREATE TABLE assessment_demand_device
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT
);

-- Таблица УГТ (уровней готовности технологии)
-- Хранит описания уровней готовности технологии для лекарственных препаратов
CREATE TABLE medical_device_technology_readiness_levels
(
    id          BIGSERIAL PRIMARY KEY,
    level       INT  NOT NULL, -- Числовое значение уровня (от 1 до 9)
    description TEXT NOT NULL  -- Описание уровня
);

-- Справочник для классов риска медицинских изделий
CREATE TABLE risk_classes
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(20) NOT NULL UNIQUE,
    name        VARCHAR(50) NOT NULL,
    description TEXT
);

-- Таблица деталей для медицинских изделий
-- Содержит все специфические поля для медицинских изделий из Приложения №6
CREATE TABLE medical_device_details
(
    id                               BIGINT PRIMARY KEY,
    technological_readiness_level_id BIGINT, -- Уровень готовности технологии (УГТ)

    -- Класс риска по НКМИ
    risk_class_id                    BIGINT,

    assessment_demand_device_id      BIGINT,

    -- Включено ли в клинические рекомендации/стандарты
    included_in_standards            BOOLEAN DEFAULT FALSE,

    FOREIGN KEY (id) REFERENCES projects (id) ON DELETE CASCADE,
    FOREIGN KEY (risk_class_id) REFERENCES risk_classes (id),
    FOREIGN KEY (technological_readiness_level_id) REFERENCES medical_device_technology_readiness_levels (id) ON DELETE NO ACTION
);

-- Таблица связи между деталями медицинских изделий и типами приоритетов
CREATE TABLE medical_device_priority_types
(
    medical_device_detail_id BIGINT NOT NULL,
    priority_id              BIGINT NOT NULL,
    PRIMARY KEY (medical_device_detail_id, priority_id),
    FOREIGN KEY (medical_device_detail_id) REFERENCES medical_device_details (id) ON DELETE CASCADE,
    FOREIGN KEY (priority_id) REFERENCES priority_types (id) ON DELETE CASCADE
);

-- Таблица классификации НКМИ (для медицинских изделий)
-- Хранит структуру номенклатурной классификации медицинских изделий
CREATE TABLE NKMI_categories
(
    id        BIGSERIAL PRIMARY KEY,
    code      VARCHAR(50)  NOT NULL,
    name      VARCHAR(255) NOT NULL,
    parent_id BIGINT,                -- NULL для корневых категорий
    level     INT          NOT NULL, -- Уровень иерархии
    FOREIGN KEY (parent_id) REFERENCES NKMI_categories (id) ON DELETE CASCADE
);

-- Таблица связи медицинских изделий и НКМИ (многие ко многим)
CREATE TABLE medical_device_NKMI_link
(
    medical_device_detail_id BIGINT NOT NULL,
    nkmi_id                  BIGINT NOT NULL,
    PRIMARY KEY (medical_device_detail_id, nkmi_id),
    FOREIGN KEY (medical_device_detail_id) REFERENCES medical_device_details (id) ON DELETE CASCADE,
    FOREIGN KEY (nkmi_id) REFERENCES NKMI_categories (id) ON DELETE CASCADE
);