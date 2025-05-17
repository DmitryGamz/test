-- Справочник типов лицензий
CREATE TABLE IF NOT EXISTS license_types
(
    id        BIGSERIAL PRIMARY KEY,
    type_name VARCHAR(255) NOT NULL
);

-- TODO: add reference to a partner_detail_id when add table pharmaceutical_partner_details
-- Таблица лицензий на производство лекарственных средств
CREATE TABLE pharmaceutical_licenses (
    id BIGSERIAL PRIMARY KEY,
    partner_detail_id BIGINT,
    license_type_id BIGINT,
    license_category_id BIGINT,
    -- FOREIGN KEY (partner_detail_id) REFERENCES pharmaceutical_partner_details(id) ON DELETE CASCADE,
    FOREIGN KEY (license_type_id) REFERENCES license_types(id),
    FOREIGN KEY (license_category_id) REFERENCES license_categories(id)
);