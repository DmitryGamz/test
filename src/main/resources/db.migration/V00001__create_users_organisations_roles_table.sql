-- Таблица организаций
CREATE TABLE organizations
(
    organization_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name            VARCHAR(255) NOT NULL,
    description     TEXT,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Таблица ролей пользователей
-- Хранит определения ролей из Приложения №2 ТЗ (Администратор, Эксперт, Оператор и др.)
CREATE TABLE roles
(
    role_id     BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_name   VARCHAR(50) NOT NULL,
    description TEXT
);

-- Таблица пользователей
-- Хранит данные всех пользователей системы
CREATE TABLE users
(
    user_id                 BIGINT PRIMARY KEY AUTO_INCREMENT,
    email                   VARCHAR(100) NOT NULL UNIQUE,      -- Логин пользователя (согласно ТЗ - это email)
    password                VARCHAR(255) NOT NULL,             -- Изменено с password_hash на password
    first_name              VARCHAR(100) NOT NULL,
    last_name               VARCHAR(100) NOT NULL,
    middle_name             VARCHAR(100),                      -- Отчество может отсутствовать
    organization_id         BIGINT,                            -- Ссылка на таблицу Organizations
    job_title               VARCHAR(255),                      -- Переименовано с position на job_title
    phone                   VARCHAR(20),                       -- Контактный телефон
    contact_sharing_consent BOOLEAN     DEFAULT FALSE,         -- Согласие на разглашение контактных данных
    participation_status    VARCHAR(20) DEFAULT 'pending',     -- Статус заявки на участие: pending/approved/rejected
    verification_status     VARCHAR(20) DEFAULT 'verificated', -- Статус верификации: verificated/unverificated
    last_login              TIMESTAMP,                         -- Время последнего входа
    is_active               BOOLEAN     DEFAULT TRUE,          -- Флаг активности учетной записи
    avatar_path             VARCHAR(255),                      -- Путь к файлу аватара
    created_at              TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    updated_at              TIMESTAMP   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_activity           TIMESTAMP   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (organization_id) REFERENCES Organizations (organization_id)
);