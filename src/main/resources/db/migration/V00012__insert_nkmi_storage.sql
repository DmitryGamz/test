-- Корневая запись для "Анестезиологические и респираторные медицинские изделия" (Level 1)
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1', 'Анестезиологические и респираторные медицинские изделия', NULL, 1);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.1', 'Алгезиметры', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.2', 'Анализаторы анестезиологических и респираторных газов',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.3', 'Анализаторы газов крови и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.4', 'Анализаторы дыхательной функции и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.5', 'Анестезиологические системы и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.6', 'Бронхоскопы', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.7', 'Вентиляторы респираторные и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.8', 'Детекторы пищеводной интурбации', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.9', 'Иглы анестезиологические', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.10', 'Ингаляторы', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.11', 'Испарители анестезиологические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.12', 'Канюли респираторные', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.13', 'Катетеры анестезиологические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.14', 'Магистрали дыхательные и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.15', 'Маски респираторные/анестезиологические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.16', 'Мониторы/системы мониторирования анестезиологические/респираторные',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.17', 'Наборы анестезиологические', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.18', 'Оборудование для подведения анестезиологических и респираторных газов',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.19', 'Оксиметры и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.20', 'Очистители воздуха', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.21', 'Пульмонологические катетеры', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.22', 'Системы вентиляции легких и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.23', 'Стенты бронхиальные', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.24', 'Стетоскопы пищеводные', (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.25', 'Устройства систем искусственной вентиляции',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('1.26', 'Прочие анестезиологические и респираторные медицинские изделия',
        (SELECT id FROM NKMI_categories WHERE code = '1'), 2);

-- Корневая запись для "Вспомогательные и общебольничные медицинские изделия" (Level 1)
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2', 'Вспомогательные и общебольничные медицинские изделия', NULL, 1);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.1', 'Бахилы медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.2', 'Ванны медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.3', 'Держатели предметных стекол', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.4', 'Инкубаторы лабораторные', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.5', 'Инфузионные насосы и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.6', 'Инъекторы лекарственных средств/вакцин',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.7', 'Камеры лабораторные', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.8', 'Комплексы передвижные медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.9', 'Консоли/системы подвода коммуникаций', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.10', 'Контейнеры опасных медицинских отходов',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.11', 'Кровати медицинские и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.12', 'Ламинарные системы', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.13', 'Ланцеты', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.14', 'Матрасы медицинские и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.15', 'Мебель медицинская', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.16', 'Мешки медицинские для прачечной', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.17', 'Моющие машины', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.18', 'Наборы для подкожных инъекций', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.19', 'Носилки', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.20', 'Носки/стельки медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.21', 'Ограничители/фиксаторы медицинские',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.22', 'Одеяла медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.23', 'Операционные столы универсальные',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.24', 'Осветители операционные', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.25', 'Перчатки медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.26', 'Печи медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.27', 'Пипетки и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.28', 'Подушки медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.29', 'Покрывала медицинских столов', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.30', 'Полотенца медицинские и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.31', 'Прокладки для молочной железы', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.32', 'Размельчители медицинских отходов', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.33', 'Раковины/мойки медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.34', 'Растворы/газы для санитарной обработки/обслуживания медицинских изделий и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.35', 'Роторы центрифужные', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.36', 'Системы ионофореза и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.37', 'Системы мониторинга уровня глюкозы и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.38', 'Системы операционных столов', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.39', 'Системы подъема/перемещения пациентов',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.40', 'Системы тепловой/криотерапии и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.41', 'Сосуды/контейнеры медицинские широкогорлые',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.42', 'Стерилизаторы и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.43', 'Стойки/держатели для инфузионных растворов и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.44', 'Стойки/штативы медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.45', 'Столы смотровые/терапевтические', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.46', 'Тележки медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.47', 'Термометры медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.48', 'Транспортеры', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.49', 'Устройства позиционирования пациентов',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.50', 'Халаты медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.51', 'Холодильные/морозильные камеры и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.52', 'Центрифуги медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.53', 'Чехлы медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.54', 'Шкафы/боксы медицинские', (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.55', 'Щетки/губки для предоперационной обработки рук и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('2.56', 'Прочие вспомогательные и общебольничные медицинские изделия',
        (SELECT id FROM NKMI_categories WHERE code = '2'), 2);

-- Корневая запись для "Гастроэнтерологические медицинские изделия" (Level 1)
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('3', 'Гастроэнтерологические медицинские изделия', NULL, 1);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('3.1', 'Анализаторы физиологических параметров гастроэнтерологические',
        (SELECT id FROM NKMI_categories WHERE code = '3'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('3.2', 'Детоксиканты гастроэнтерологические',
        (SELECT id FROM NKMI_categories WHERE code = '3'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('3.3', 'Иглы для пневмоперитонеума', (SELECT id FROM NKMI_categories WHERE code = '3'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('3.4', 'Ингибиторы всасывания питательных веществ',
        (SELECT id FROM NKMI_categories WHERE code = '3'), 2);

-- Корневая категория: Гастроэнтерологические медицинские изделия
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('3.5', 'Катетеры гастроэнтерологические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '3'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('3.6', 'Катетеры перитонеальные и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '3'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('3.7', 'Мониторы/мониторные системы гастроэнтерологические',
        (SELECT id FROM NKMI_categories WHERE code = '3'), 2);

-- Корневая категория: Медицинские изделия для акушерства и гинекологии
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('4', 'Медицинские изделия для акушерства и гинекологии', NULL, 1);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('4.1', 'Анализаторы физиологических параметров акушерские/гинекологические',
        (SELECT id FROM NKMI_categories WHERE code = '4'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('4.2', 'Зеркала вагинальные',
        (SELECT id FROM NKMI_categories WHERE code = '4'), 2);

-- Корневая категория: Медицинские изделия для диагностики in vitro
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('5', 'Медицинские изделия для диагностики in vitro', NULL, 1);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('5.1', 'Анализаторы для диагностики in vitro',
        (SELECT id FROM NKMI_categories WHERE code = '5'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('5.2', 'Емкости/контейнеры для проб для диагностики in vitro',
        (SELECT id FROM NKMI_categories WHERE code = '5'), 2);

-- Корневая категория: Медицинские изделия для манипуляций/восстановления тканей/органов человека
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('6', 'Медицинские изделия для манипуляций/восстановления тканей/органов человека', NULL, 1);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('6.1', 'Адгезивы/клеи тканевые',
        (SELECT id FROM NKMI_categories WHERE code = '6'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('6.2', 'Изделия для сбора/обработки/транспортирования биологических жидкостей/тканей',
        (SELECT id FROM NKMI_categories WHERE code = '6'), 2);

-- Корневая категория: Медицинские изделия для оториноларингологии
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('7', 'Медицинские изделия для оториноларингологии', NULL, 1);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('7.1', 'Аппараты слуховые и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '7'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('7.2', 'Аудиометры и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '7'), 2);

-- Корневая категория: Медицинские изделия для пластической хирургии и косметологии
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('8', 'Медицинские изделия для пластической хирургии и косметологии', NULL, 1);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('8.1', 'Имплантаты грудные и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '8'), 2);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('8.2', 'Нити для косметической хирургии',
        (SELECT id FROM NKMI_categories WHERE code = '8'), 2);
-- Корневая категория "Неврологические медицинские изделия"
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9', 'Неврологические медицинские изделия', NULL, 1);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.1', 'Анализаторы сенсорных функций', (SELECT id FROM NKMI_categories WHERE code = '9'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.2', 'Анализаторы физиологических параметров неврологические',
        (SELECT id FROM NKMI_categories WHERE code = '9'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.3', 'Изделия хирургические неврологические', (SELECT id FROM NKMI_categories WHERE code = '9'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.4', 'Катетеры неврологические и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '9'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.5', 'Локаторы нервов и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '9'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.6', 'Мониторы/системы мониторирования неврологические', (SELECT id FROM NKMI_categories WHERE code = '9'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.7', 'Системы обезболивающей электростимуляции', (SELECT id FROM NKMI_categories WHERE code = '9'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.8', 'Системы электростимуляции диафрагмального нерва', (SELECT id FROM NKMI_categories WHERE code = '9'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.9', 'Системы электростимуляции периферических нервов', (SELECT id FROM NKMI_categories WHERE code = '9'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.10', 'Системы электростимуляции центральной нервной системы',
        (SELECT id FROM NKMI_categories WHERE code = '9'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.11', 'Эндоскопы неврологические', (SELECT id FROM NKMI_categories WHERE code = '9'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.12', 'Эстезиометры', (SELECT id FROM NKMI_categories WHERE code = '9'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('9.13', 'Прочие неврологические медицинские изделия', (SELECT id FROM NKMI_categories WHERE code = '9'), 2);

-- Корневая категория "Ортопедические медицинские изделия"
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10', 'Ортопедические медицинские изделия', NULL, 1);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.1', 'Артроскопы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.2', 'Гвозди костные и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.3', 'Дистракторы костные и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.4', 'Иммобилизаторы суставов', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.5', 'Инструменты для имплантирования ортопедических протезов',
        (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.6', 'Инструменты для формирования резьбы в костном канале',
        (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.7', 'Имплантаты для эктопротезирования и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.8', 'Кейджи костные', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.9', 'Материалы иммобилизирующие и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.10', 'Наборы для имплантации ортопедические', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.11', 'Наборы хирургические ортопедические', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.12', 'Направители ортопедические', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.13', 'Операционные столы ортопедические', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.14', 'Ортезы ортопедические', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.15', 'Подвесы для рук', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.16', 'Протезы суставов имплантируемые и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.17', 'Расширители ортопедические', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.18', 'Системы спинальной фиксации и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.19', 'Системы экстракорпоральной ортопедической ударно-волновой терапии и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.20', 'Сложный комбинированный лицевой эктопротез', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.21', 'Тракционные системы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.22', 'Фиксирующие системы ортопедические', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.23', 'Цементы ортопедические сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.24', 'Эктопротез уха', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.25', 'Эктопротез носа', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.26', 'Эктопротез глаза (орбиты)', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('10.27', 'Прочие ортопедические медицинские изделия', (SELECT id FROM NKMI_categories WHERE code = '10'), 2);

-- Корневая категория "Офтальмологические медицинские изделия"
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11', 'Офтальмологические медицинские изделия', NULL, 1);

INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.1', 'Анализаторы офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.2', 'Диоптриметры', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.3', 'Канюли офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.4', 'Кератомы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.5', 'Кольца офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.6', 'Крючки офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.7', 'Линзы диагностические офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.8', 'Линзы интраокулярные и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.9', 'Линзы контактные и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.10', 'Линзы очковые и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.11', 'Линзы экстраокулярные увеличительные', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.12', 'Наборы офтальмологические хирургические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.13', 'Ножи офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.14', 'Ножницы офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.15', 'Операционные столы офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.16', 'Офтальмологические лазерные системы', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.17', 'Офтальмоскопы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.18', 'Пинцеты офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.19', 'Протезы интраокулярные и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '11'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.20', 'Системы для трепанации роговицы и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.21', 'Системы криохирургические офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.22', 'Системы факоэмульсификации/витректомии и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.23', 'Средства защиты глазной поверхности', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.24', 'Тонометры офтальмологические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.25', 'Эндоскопы для слезных каналов', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.26', 'Эндоскопы офтальмологические', (SELECT id FROM NKMI_categories WHERE code = '11'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('11.27', 'Прочие офтальмологические медицинские изделия', (SELECT id FROM NKMI_categories WHERE code = '11'),
        2);
-- Корневая категория "Радиологические медицинские изделия"
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12', 'Радиологические медицинские изделия', NULL, 1);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.1', 'Гентри и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.2', 'Измерители излучения', (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.3', 'Коллиматоры и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.4', 'Кресла пациентов для радиологической диагностики/терапии',
        (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.5', 'Модули передвижные радиологические', (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.6', 'Пленки рентгеновские и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.7', 'Системы позиционирования пациентов и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.8', 'Системы радиологические диагностические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.9', 'Системы радиологические терапевтические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.10', 'Среды контрастирующие и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '12'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.11', 'Столы радиологические', (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.12', 'Фантомы', (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.13', 'Экраны/защиты/ограничители излучения', (SELECT id FROM NKMI_categories WHERE code = '12'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('12.14', 'Прочие радиологические медицинские изделия', (SELECT id FROM NKMI_categories WHERE code = '12'), 2);


-- Корневая категория "Реабилитационные и адаптированные для инвалидов медицинские изделия"
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13', 'Реабилитационные и адаптированные для инвалидов медицинские изделия', NULL, 1);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.1', 'Изделия бытовые адаптированные', (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.2', 'Изделия для отдыха адаптированные', (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.3', 'Изделия/оборудование домашнее адаптированные', (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.4', 'Протезы/ортезы внешние', (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.5', 'Средства медицинские персональные адаптированные', (SELECT id FROM NKMI_categories WHERE code = '13'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.6', 'Средства передвижения адаптированные', (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.7', 'Средства ухода персональные адаптированные', (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.8', 'Устройства коммуникации и информации адаптированные',
        (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.9', 'Устройства манипуляции/фиксации предметов адаптированные',
        (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.10', 'Устройства обучения бытовым навыкам адаптированные',
        (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.11', 'Устройства обучения навыкам работы адаптированные',
        (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.12', 'Устройства управления внешней средой адаптированные',
        (SELECT id FROM NKMI_categories WHERE code = '13'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('13.13', 'Прочие реабилитационные и адаптационные медицинские изделия',
        (SELECT id FROM NKMI_categories WHERE code = '13'), 2);


-- Корневая категория "Сердечно-сосудистые медицинские изделия"
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14', 'Сердечно-сосудистые медицинские изделия', NULL, 1);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.1', 'Ангиоскопы', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.2', 'Артериоскопы', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.3', 'Внутрисосудистые фильтры и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '14'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.4', 'Гемостатические средства', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.5', 'Дефибрилляторы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.6', 'Жгуты/манжеты кровоостанавливающие и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.7', 'Имплантаты эмболизирующие и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '14'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.8', 'Инфузионные/аспирационные катетеры', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.9', 'Кардиостимуляторы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.10', 'Катетеры кардиологические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.11', 'Медицинские изделия для анализа гемодинамики', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.12', 'Медицинские изделия для кардиореанимации', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.13', 'Медицинские изделия для определения физиологических параметров/картирования сердца',
        (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.14', 'Медицинские изделия для сердечно-сосудистой хирургии',
        (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.15', 'Мониторы/системы кардиологические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.16', 'Наборы инфузионные и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.17', 'Отведения кардиостимуляторов/дефибрилляторов и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.18', 'Протезы сердечно-сосудистые и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.19', 'Системы ангиопластики и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '14'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.20', 'Системы для компрессии бедренной артерии и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.21', 'Системы для эмболоэктомии/тромбэктомии и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.22', 'Системы искусственного кровообращения и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.23', 'Системы компрессии вен и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '14'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.24', 'Устройства для локализации вен', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('14.25', 'Прочие сердечно-сосудистые изделия', (SELECT id FROM NKMI_categories WHERE code = '14'), 2);


-- Корневая категория "Стоматологические медицинские изделия"
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15', 'Стоматологические медицинские изделия', NULL, 1);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.1', 'Аппликаторы стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.2', 'Бормашины и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.3', 'Детекторы зубного кариеса и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '15'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.4', 'Зонды стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.5', 'Изделия для моделирования поверхности пломбы', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.6', 'Изделия для удаления зубного камня', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.7', 'Изделия ортодонтические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.8', 'Имплантаты стоматологические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.9', 'Инструменты для введения пломбировочного материала',
        (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.10', 'Канюли стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.11', 'Кресла стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.12', 'Материалы стоматологические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
-- Стоматологические медицинские изделия (корневая категория)
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.13', 'Наборы хирургические стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.14', 'Осветители стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.15', 'Повязки стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.16', 'Протезы зубные и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.17', 'Протезы стоматологические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.18', 'Рашпили стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.19', 'Ретракторы стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.20', 'Системы лазерные стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.21', 'Системы/консоли подвода коммуникаций', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.22', 'Стоматоскопы', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.23', 'Шины стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.24', 'Шприцы стоматологические и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '15'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.25', 'Щипцы стоматологические', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('15.26', 'Прочие стоматологические медицинские изделия', (SELECT id FROM NKMI_categories WHERE code = '15'), 2);


-- Урологические медицинские изделия (корневая категория)
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16', 'Урологические медицинские изделия', NULL, 1);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.1', 'Барьеры уретральные для лечения недержания мочи у женщин',
        (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.2', 'Бужи уретральные', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.3', 'Инструменты для извлечения камней', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.4', 'Катетеры урологические и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '16'),
        2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.5', 'Наборы хирургические нефроскопические', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.6', 'Наборы хирургические урологические', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.7', 'Операционные столы урологические', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.8', 'Презервативы мужские', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.9', 'Протезы пениса', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.10', 'Системы гемодиализа и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.11', 'Системы литотрипсии и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.12', 'Стенты урологические', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.13', 'Эндоскопы урологические', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('16.14', 'Прочие урологические медицинские изделия', (SELECT id FROM NKMI_categories WHERE code = '16'), 2);


-- Физиотерапевтические медицинские изделия (корневая категория)
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('17', 'Физиотерапевтические медицинские изделия', NULL, 1);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('17.1', 'Ванны терапевтические', (SELECT id FROM NKMI_categories WHERE code = '17'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('17.2', 'Массажеры и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '17'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('17.3', 'Пакеты холодовой/термической терапии и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '17'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('17.4', 'Системы диатермической терапии и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '17'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('17.5', 'Столы для физиотерапии', (SELECT id FROM NKMI_categories WHERE code = '17'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('17.6', 'Тренажеры реабилитационные', (SELECT id FROM NKMI_categories WHERE code = '17'), 2);
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('17.7', 'Прочие физиотерапевтические медицинские изделия', (SELECT id FROM NKMI_categories WHERE code = '17'),
        2);
-- Корневая категория
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18', 'Хирургические инструменты/системы и сопутствующие медицинские изделия', NULL, 1);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.1', 'Аппликаторы адгезивов/клеев хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.2', 'Аппликаторы клипс/зажимов и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'),
        2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.3', 'Аппроксиматоры', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.4', 'Бужи', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.5', 'Буры медицинские и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.6', 'Видеокамеры хирургические и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'),
        2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.7', 'Винты для остеосинтеза', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.8', 'Выкусыватели хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.9', 'Гвозди для остеосинтеза', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.10', 'Губки хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.11', 'Депрессоры', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.12', 'Дерматомы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.13', 'Диссекторы', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.14', 'Долото медицинское и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.15', 'Дрели хирургические и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.16', 'Дренажи хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.17', 'Зажимы хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.18', 'Зонды хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.19', 'Кератомы', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.20', 'Крючки хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.21', 'Кусачки', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.22', 'Кюретки', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.23', 'Лигаторы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.24', 'Манипуляторы хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.25', 'Микроскопы хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.26', 'Напильники медицинские', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.27', 'Направители', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.28', 'Ножи/скальпели хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.29', 'Ножницы хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.30', 'Остеотомы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.31', 'Отвертки хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.32', 'Перфораторы хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.33', 'Петли хирургические и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.34', 'Пилы медицинские и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.35', 'Развертки/римеры и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.36', 'Распаторы', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.37', 'Расширители и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.38', 'Рашпили медицинские', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.39', 'Ретракторы/петли и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.40', 'Системы абляции и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.41', 'Системы криохирургические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.42', 'Системы лазерные хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.43', 'Системы хирургические ультразвуковые и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.44', 'Системы шейверные и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.45', 'Системы электрохирургические диатермические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.46', 'Совки/скребки медицинские', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.47', 'Степлеры медицинские и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.48', 'Уплотнители хирургические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.49', 'Трепаны и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.50', 'Трокары и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.51', 'Шпатели хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.52', 'Щипцы медицинские и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.53', 'Экскаваторы', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.54', 'Экстракторы хирургические', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.55', 'Элеваторы', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.56', 'Электрокаутеры и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('18.57', 'Прочие хирургические инструменты/системы и сопутствующие медицинские изделия',
        (SELECT id FROM NKMI_categories WHERE code = '18'), 2);


-- Следующая корневая категория
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19', 'Эндоскопические медицинские изделия', NULL, 1);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.1', 'Видеокамеры эндоскопические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.2', 'Иглы эндотерапевтические', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.3', 'Канюли эндотерапевтические', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.4', 'Клапаны эндоскопические', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.5', 'Лапароскопы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.6', 'Ларингоскопы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.7', 'Лигаторы эндотерапевтические', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.8', 'Ножницы эндотерапевтические', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.9', 'Расширительные системы/ирригаторы эндоскопические и сопутствующие изделия',
        (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.10', 'Резектоскопы и сопутствующие изделия', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.11', 'Степлеры эндоскопические', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.12', 'Щипцы эндотерапевтические', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.13', 'Электроды диатермических электрохирургических эндотерапевтических систем',
        (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.14', 'Эндоскопы', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('19.15', 'Прочие эндоскопические медицинские изделия', (SELECT id FROM NKMI_categories WHERE code = '19'), 2);


-- Последняя корневая категория
INSERT INTO NKMI_categories (code, name, parent_id, level)
VALUES ('20', 'Программное обеспечение, являющееся медицинским изделием', NULL, 1);