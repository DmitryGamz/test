-- Таблица типов медицинских продуктов
-- Содержит типы продуктов: лекарственные средства, медицинские изделия, новые материалы
CREATE TABLE product_types
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(20) NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    description TEXT
);

-- Справочник для статусов проектов
CREATE TABLE project_statuses
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(20) NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    description TEXT
);

-- Справочник для статусов IPR
CREATE TABLE IPR_statuses
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(20) NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    description TEXT
);

-- Справочник для коммерческих статусов
CREATE TABLE commercial_statuses
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(20) NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    description TEXT
);

-- Справочник для рыночных перспектив
CREATE TABLE market_perspectives
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(20) NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    description TEXT
);

-- Справочник для требований к производству
CREATE TABLE production_requirements
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(20) NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    description TEXT
);

-- Справочник для сроков завершения
CREATE TABLE completion_times
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(20) NOT NULL UNIQUE,
    name        VARCHAR(50) NOT NULL,
    description TEXT
);

-- Таблица областей применения
-- Общие области применения для проектов
CREATE TABLE scope
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(255) NOT NULL UNIQUE,
    name        VARCHAR(50)  NOT NULL,
    description TEXT
);

-- Таблица использования студентов
CREATE TABLE students_involved
(
    id          BIGSERIAL PRIMARY KEY,
    code        VARCHAR(20) NOT NULL UNIQUE,
    name        VARCHAR(100) NOT NULL,
    description TEXT
);

-- Основная таблица проектов/разработок
-- Содержит общую информацию о проектах всех типов
CREATE TABLE projects
(
    id                        BIGSERIAL PRIMARY KEY,
    user_id                   BIGINT       NOT NULL,   -- Создатель проекта
    product_type_id           BIGINT       NOT NULL,   -- Тип продукта (лекарство, медизделие и т.д.)
    organization_id           BIGINT       NOT NULL,   -- Ссылка на учреждение
    name                      VARCHAR(255) NOT NULL,   -- Наименование разработки
    description               TEXT         NOT NULL,   -- Краткое описание
    application_scope_id         BIGINT       NOT NULL,   -- Ссылка на область применения
    status_id                 BIGINT,                  -- Ссылка на справочник статусов

    -- Данные о РИД и товарных знаках
    ipr_status_id             BIGINT,                  -- Ссылка на справочник статусов IPR
    ipr_valuation_exists      BOOLEAN   DEFAULT FALSE, -- Наличие отчета об оценке РИД

    -- Коммерциализация
    commercial_status_id      BIGINT,                  -- Ссылка на справочник коммерческих статусов
    commercial_effect         TEXT,                    -- Экономический эффект от коммерциализации

    -- Рыночные перспективы
    market_perspective_id     BIGINT,                  -- Ссылка на справочник рыночных перспектив
    novelty                   TEXT,                    -- Новизна
    key_differences           TEXT,                    -- Ключевое отличие от аналогов

    export_potential          BOOLEAN   DEFAULT FALSE, -- Экспортный потенциал

    -- Производство и сроки
    production_requirement_id BIGINT,                  -- Ссылка на справочник требований к производству
    completion_time_id        BIGINT,                  -- Ссылка на справочник сроков завершения

    -- Участие студентов
    students_involved_id     BIGINT,

    -- Системные поля
    created_at                TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at                TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_edit_by              BIGINT,

    -- Внешние ключи
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (product_type_id) REFERENCES product_types (id),
    FOREIGN KEY (status_id) REFERENCES project_statuses (id),
    FOREIGN KEY (ipr_status_id) REFERENCES IPR_statuses (id),
    FOREIGN KEY (commercial_status_id) REFERENCES commercial_statuses (id),
    FOREIGN KEY (market_perspective_id) REFERENCES market_perspectives (id),
    FOREIGN KEY (production_requirement_id) REFERENCES production_requirements (id),
    FOREIGN KEY (completion_time_id) REFERENCES completion_times (id),
    FOREIGN KEY (application_scope_id) REFERENCES scope (id),
    FOREIGN KEY (last_edit_by) REFERENCES users (id)
);