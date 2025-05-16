-- Вставка уровней готовности технологий
INSERT INTO medication_technology_readiness_levels (level, description) VALUES (1, 'Сформулирована фундаментальная идея разработки продукта, обоснована его полезность');
INSERT INTO medication_technology_readiness_levels (level, description) VALUES (2, 'Определены целевые области применения продукта, подтверждена обоснованность и эффективность использования идеи');
INSERT INTO medication_technology_readiness_levels (level, description) VALUES (3, 'Получен перспективный кандидат, его активность продемонстрирована экспериментальным путем');
INSERT INTO medication_technology_readiness_levels (level, description) VALUES (4, 'Получение активной фармацевтической субстанции (далее - АФС) в лабораторных масштабах. Проведение доклинических исследований (далее – ДКИ) АФС');
INSERT INTO medication_technology_readiness_levels (level, description) VALUES (5, 'Трансфер производства АФС в условия GMP. Разработка ГЛФ. ДКИ ЛП');
INSERT INTO medication_technology_readiness_levels (level, description) VALUES (6, 'Трансфер производства ГЛФ в условия GMP. Производство опытно-промышленных серий ГЛФ препарата по стандартам GMP. Клинические исследования (фаза I). Построение системы фармаконадзора.');
INSERT INTO medication_technology_readiness_levels (level, description) VALUES (7, 'Клинические исследования (фаза II) Производство опытно-промышленных серий ЛП в соответствии с актуализированным регламентом');
INSERT INTO medication_technology_readiness_levels (level, description) VALUES (8, 'Клинические исследования (фаза III). Подтверждена эффективность и безопасность ЛП. Произведены промышленные серии препарата по стандартам GMP. Регистрация ЛП.');
INSERT INTO medication_technology_readiness_levels (level, description) VALUES (9, 'Серийное производство ЛП по стандартам GMP. Выпуск в обращение. Пострегистрационные исследования/обязательства (при наличии)');

-- Вставка лекарственных форм (основные категории)
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('1', 'Аэрозоль', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('2', 'Газ медицинский', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3', 'Гель', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4', 'Гранулы', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('5', 'Дисперсия', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('6', 'Жидкость', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('7', 'Имплантат', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8', 'Капли', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9', 'Капсулы', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('10', 'Концентрат', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('11', 'Крем', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('12', 'Линимент', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('13', 'Лиофилизат', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('14', 'Мазь', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('15', 'Масло', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('16', 'Настойка', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('17', 'Палочки', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('18', 'Паста', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('19', 'Пена лекарственная', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('20', 'Пластырь лекарственный', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('21', 'Пленки', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('22', 'Порошок', NULL, 1);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('23', 'Раствор', NULL, 1);

-- Вставка подкатегорий лекарственных форм (аэрозоли)
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('1.1', 'Аэрозоль для ингаляций дозированный', (SELECT id FROM medication_forms WHERE code = '1'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('1.2', 'Аэрозоль для местного применения', (SELECT id FROM medication_forms WHERE code = '1'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('1.3', 'Аэрозоль для нанесения на слизистую оболочку полости рта', (SELECT id FROM medication_forms WHERE code = '1'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('1.4', 'Аэрозоль для наружного применения', (SELECT id FROM medication_forms WHERE code = '1'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('1.5', 'Аэрозоль назальный', (SELECT id FROM medication_forms WHERE code = '1'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('1.6', 'Аэрозоль подъязычный', (SELECT id FROM medication_forms WHERE code = '1'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('1.7', 'Аэрозоль трансдермальный', (SELECT id FROM medication_forms WHERE code = '1'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('1.8', 'Аэрозоль ушной', (SELECT id FROM medication_forms WHERE code = '1'), 2);

-- Вставка подкатегорий лекарственных форм (газы медицинские)
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('2.1', 'Газ медицинский криогенный', (SELECT id FROM medication_forms WHERE code = '2'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('2.2', 'Газ медицинский сжатый', (SELECT id FROM medication_forms WHERE code = '2'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('2.3', 'Газ медицинский сжиженный', (SELECT id FROM medication_forms WHERE code = '2'), 2);

-- Вставка подкатегорий лекарственных форм (гели)
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.1', 'Гель вагинальный', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.2', 'Гель глазной', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.3', 'Гель для инъекций', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.4', 'Гель для местного применения', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.5', 'Гель для нанесения на десны', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.6', 'Гель для нанесения на слизистую оболочку полости рта', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.7', 'Гель для наружного применения', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.8', 'Гель для подкожного введения', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.9', 'Гель для приготовления суспензии для приема внутрь', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.10', 'Гель для приема внутрь', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.11', 'Гель зубной', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.12', 'Гель интестинальный', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.13', 'Гель назальный', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.14', 'Гель периодонтальный', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.15', 'Гель ректальный', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.16', 'Гель стоматологический', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.17', 'Гель трансдермальный', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.18', 'Гель уретральный', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.19', 'Гель ушной', (SELECT id FROM medication_forms WHERE code = '3'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('3.20', 'Гель эндоцервикальный', (SELECT id FROM medication_forms WHERE code = '3'), 2);

-- Вставка подкатегорий лекарственных форм (гранулы)
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4.1', 'Гранулы', (SELECT id FROM medication_forms WHERE code = '4'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4.2', 'Гранулы для приготовления...', (SELECT id FROM medication_forms WHERE code = '4'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4.3', 'Гранулы для рассасывания', (SELECT id FROM medication_forms WHERE code = '4'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4.4', 'Гранулы кишечнорастворимые', (SELECT id FROM medication_forms WHERE code = '4'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4.5', 'Гранулы кишечнорастворимые с пролонгированным высвобождением', (SELECT id FROM medication_forms WHERE code = '4'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4.6', 'Гранулы, покрытые оболочкой', (SELECT id FROM medication_forms WHERE code = '4'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4.7', 'Гранулы резано-прессованные', (SELECT id FROM medication_forms WHERE code = '4'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4.8', 'Гранулы с модифицированным высвобождением', (SELECT id FROM medication_forms WHERE code = '4'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4.9', 'Гранулы с пролонгированным высвобождением', (SELECT id FROM medication_forms WHERE code = '4'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('4.10', 'Гранулы шипучие', (SELECT id FROM medication_forms WHERE code = '4'), 2);

-- Вставка подкатегорий лекарственных форм (дисперсии)
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('5.1', 'Дисперсия для внутривенного введения', (SELECT id FROM medication_forms WHERE code = '5'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('5.2', 'Дисперсия для внутрикожного введения', (SELECT id FROM medication_forms WHERE code = '5'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('5.3', 'Дисперсия для инфузий', (SELECT id FROM medication_forms WHERE code = '5'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('5.4', 'Дисперсия для инъекций', (SELECT id FROM medication_forms WHERE code = '5'), 2);

-- Вставка подкатегорий лекарственных форм (жидкости)
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('6.1', 'Жидкость для ингаляций', (SELECT id FROM medication_forms WHERE code = '6'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('6.2', 'Жидкость для наружного применения', (SELECT id FROM medication_forms WHERE code = '6'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('6.3', 'Жидкость для приема внутрь', (SELECT id FROM medication_forms WHERE code = '6'), 2);

-- Вставка подкатегорий лекарственных форм (имплантаты)
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('7.1', 'Имплантат', (SELECT id FROM medication_forms WHERE code = '7'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('7.2', 'Имплантат интравитреальный', (SELECT id FROM medication_forms WHERE code = '7'), 2);

-- Вставка подкатегорий лекарственных форм (капли)
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8.1', 'Капли глазные', (SELECT id FROM medication_forms WHERE code = '8'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8.2', 'Капли глазные с пролонгированным высвобождением', (SELECT id FROM medication_forms WHERE code = '8'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8.3', 'Капли для ингаляций', (SELECT id FROM medication_forms WHERE code = '8'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8.4', 'Капли для местного применения', (SELECT id FROM medication_forms WHERE code = '8'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8.5', 'Капли для нанесения на слизистую оболочку полости рта', (SELECT id FROM medication_forms WHERE code = '8'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8.6', 'Капли для приема внутрь', (SELECT id FROM medication_forms WHERE code = '8'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8.7', 'Капли зубные', (SELECT id FROM medication_forms WHERE code = '8'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8.8', 'Капли назальные', (SELECT id FROM medication_forms WHERE code = '8'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8.9', 'Капли подъязычные', (SELECT id FROM medication_forms WHERE code = '8'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('8.10', 'Капли ушные', (SELECT id FROM medication_forms WHERE code = '8'), 2);

-- Вставка подкатегорий лекарственных форм (капсулы)
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.1', 'Капсулы', (SELECT id FROM medication_forms WHERE code = '9'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.2', 'Капсулы вагинальные', (SELECT id FROM medication_forms WHERE code = '9'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.3', 'Капсулы внутриматочные', (SELECT id FROM medication_forms WHERE code = '9'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.4', 'Капсулы жевательные', (SELECT id FROM medication_forms WHERE code = '9'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.5', 'Капсулы кишечнорастворимые', (SELECT id FROM medication_forms WHERE code = '9'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.6', 'Капсулы кишечнорастворимые с пролонгированным высвобождением', (SELECT id FROM medication_forms WHERE code = '9'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.7', 'Капсулы подъязычные', (SELECT id FROM medication_forms WHERE code = '9'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.8', 'Капсулы ректальные', (SELECT id FROM medication_forms WHERE code = '9'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.9', 'Капсулы с модифицированным высвобождением', (SELECT id FROM medication_forms WHERE code = '9'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.10', 'Капсулы с порошком для ингаляций', (SELECT id FROM medication_forms WHERE code = '9'), 2);
INSERT INTO medication_forms (code, name, parent_id, level) VALUES ('9.11', 'Капсулы с пролонгированным высвобождением', (SELECT id FROM medication_forms WHERE code = '9'), 2);

-- Вставка типов приоритетов
INSERT INTO priority_types (code, name, description) VALUES ('MORT', 'Снижение смертности', 'Лекарства и медизделия, направленные на снижение смертности.');
INSERT INTO priority_types (code, name, description) VALUES ('DISAB', 'Снижение инвалидизации', 'Лекарства и медизделия, направленные на снижение уровня инвалидизации.');
INSERT INTO priority_types (code, name, description) VALUES ('TEMP_DIS', 'Снижение сроков временной нетрудоспособности', 'Лекарства и медизделия, направленные на сокращение времени, необходимого для восстановления трудоспособности.');
INSERT INTO priority_types (code, name, description) VALUES ('QL', 'Увеличение качества жизни, связанное с состоянием здоровья', 'Лекарства и медизделия, направленные на улучшение качества жизни пациентов.');
INSERT INTO priority_types (code, name, description) VALUES ('ORPHAN', 'Орфанные заболевания', 'Лекарства и медизделия для лечения редких (орфанных) заболеваний.');
INSERT INTO priority_types (code, name, description) VALUES ('TECH', 'Технологические тренды', 'Инновационные лекарства и медизделия, соответствующие современным технологическим трендам в медицине.');
INSERT INTO priority_types (code, name, description) VALUES ('IMPORT', 'Импортозамещение', 'Лекарства и медизделия, предназначенные для замещения импортных аналогов.');
INSERT INTO priority_types (code, name, description) VALUES ('MARKET', 'Рыночное превосходство (коммерческая перспективность)', 'Лекарства и медизделия с высоким потенциалом коммерческого успеха.');