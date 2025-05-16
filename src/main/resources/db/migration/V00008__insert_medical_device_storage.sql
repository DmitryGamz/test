-- Корневая запись для "I Некоторые инфекционные и паразитарные болезни"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('A00-B99', 'I Некоторые инфекционные и паразитарные болезни', NULL,
        1); -- Дочерние записи для "A00-B99" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('A00-A09', 'Кишечные инфекции', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('A15-A19', 'Туберкулез', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('A20-A28', 'Некоторые бактериальные зоонозы', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('A30-A49', 'Другие бактериальные болезни', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('A50-A64', 'Инфекции, передающиеся преимущественно половым путем', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('A65-A69', 'Другие болезни, вызываемые спирохетами', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('A70-A74', 'Другие болезни, вызываемые хламидиями', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('A75-A79', 'Риккетсиозы', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('A80-A89', 'Вирусные инфекции центральной нервной системы', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('A92-A99', 'Вирусные лихорадки, передаваемые членистоногими, и вирусные геморрагические лихорадки', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); -- Дополнительные дочерние записи для "A00-B99" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B00-B09', 'Вирусные инфекции, характеризующиеся поражениями кожи и слизистых оболочек', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B15-B19', 'Вирусный гепатит', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B20-B24', 'Болезнь, вызванная вирусом иммунодефицита человека [ВИЧ]', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B25-B34', 'Другие вирусные болезни', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B35-B49', 'Микозы', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B50-B64', 'Протозойные болезни', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B65-B83', 'Гельминтозы', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B85-B89', 'Педикулез, акариаз и другие инфестации', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B90-B94', 'Последствия инфестационных и паразитарных болезней', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B95-B98', 'Бактериальные, вирусные и другие инфекционные агенты', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('B99-B99', 'Другие инфекционные болезни', (SELECT id FROM application_areas_medication WHERE code = 'A00-B99'), 2); -- Корневая запись для "II Новообразования" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C00-D48', 'II Новообразования', NULL, 1); -- Дочерние записи для "C00-D48" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C00-C97', 'Злокачественные новообразования', (SELECT id FROM application_areas_medication WHERE code = 'C00-D48'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C00-C75', 'Злокачественные новообразования уточненных локализаций, которые обозначены как первичные или предположительно первичные, кроме новообразований лимфоидной, кроветворной и родственных им тканей', (SELECT id FROM application_areas_medication WHERE code = 'C00-C97'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C00-C14', 'Губы, полости рта и глотки', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C15-C26', 'Органов пищеварения', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C30-C39', 'Органов дыхания и грудной клетки', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C40-C41', 'Костей и суставных хрящей', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C43-C44', 'Кожи', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C45-C49', 'Мезотелиальной и мягких тканей', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C50-C50', 'Молочной железы', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C51-C58', 'Женских половых органов', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C60-C63', 'Мужских половых органов', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C64-C68', 'Мочевых путей', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C69-C72', 'Глаза, головного мозга и других отделов центральной нервной системы', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C73-C75', 'Щитовидной и других эндокринных желез', (SELECT id FROM application_areas_medication WHERE code = 'C00-C75'), 4); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C76-C80', 'Злокачественные новообразоваия неточно обозначенные, вторичные и неуточненных локализаций', (SELECT id FROM application_areas_medication WHERE code = 'C00-C97'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C81-C96', 'Злокачественные новообразования лимфоидной, кроветворной и родственных им тканей, которые обозначены как первичные или предположительно первичные', (SELECT id FROM application_areas_medication WHERE code = 'C00-C97'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('C97-C97', 'Злокачественные новообразования самостоятельных (первичных) множественных локализаций', (SELECT id FROM application_areas_medication WHERE code = 'C00-C97'), 3); -- Дополнительные дочерние записи для "C00-D48" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D00-D09', 'In situ новообразования', (SELECT id FROM application_areas_medication WHERE code = 'C00-D48'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D10-D36', 'Доброкачественные новообразования', (SELECT id FROM application_areas_medication WHERE code = 'C00-D48'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D37-D48', 'Новообразования неопределенного или неизвестного характера', (SELECT id FROM application_areas_medication WHERE code = 'C00-D48'), 2); -- Корневая запись для "III Болезни крови, кроветворных органов и отдельные нарушения, вовлекающие иммунный механизм" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D50-D89', 'III Болезни крови, кроветворных органов и отдельные нарушения, вовлекающие иммунный механизм', NULL, 1); -- Дочерние записи для "D50-D89" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D50-D53', 'Анемии, связанные с питанием', (SELECT id FROM application_areas_medication WHERE code = 'D50-D89'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D55-D59', 'Гемолитические анемии', (SELECT id FROM application_areas_medication WHERE code = 'D50-D89'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D60-D64', 'Апластические и другие анемии', (SELECT id FROM application_areas_medication WHERE code = 'D50-D89'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D63*', 'Анемия при хронических болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'D50-D89'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D65-D69', 'Нарушения свертываемости крови, пурпура и другие геморрагические состояния', (SELECT id FROM application_areas_medication WHERE code = 'D50-D89'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D70-D77', 'Другие болезни крови и кроветворных органов', (SELECT id FROM application_areas_medication WHERE code = 'D50-D89'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D77*', 'Другие нарушения крови и кроветворных органов при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'D50-D89'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('D80-D89', 'Отдельные нарушения, вовлекающие иммунный механизм', (SELECT id FROM application_areas_medication WHERE code = 'D50-D89'), 2); -- Корневая запись для "IV Болезни эндокринной системы, расстройства питания и нарушения обмена веществ" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E00-E90', 'IV Болезни эндокринной системы, расстройства питания и нарушения обмена веществ', NULL, 1); -- Дочерние записи для "E00-E90" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E00-E07', 'Болезни щитовидной железы', (SELECT id FROM application_areas_medication WHERE code = 'E00-E90'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E10-E14', 'Сахарный диабет', (SELECT id FROM application_areas_medication WHERE code = 'E00-E90'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E15-E16', 'Другие нарушения регуляции глюкозы и внутренней секреции поджелудочной железы', (SELECT id FROM application_areas_medication WHERE code = 'E00-E90'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E20-E35', 'Нарушения других эндокринных желез', (SELECT id FROM application_areas_medication WHERE code = 'E00-E90'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E35*', 'Нарушения эндокринных желез при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'E00-E90'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E40-E46', 'Недостаточность питания', (SELECT id FROM application_areas_medication WHERE code = 'E00-E90'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E50-E64', 'Другие виды недостаточности питания', (SELECT id FROM application_areas_medication WHERE code = 'E00-E90'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E65-E68', 'Ожирение и другие виды избыточности питания', (SELECT id FROM application_areas_medication WHERE code = 'E00-E90'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E70-E90', 'Нарушения обмена веществ', (SELECT id FROM application_areas_medication WHERE code = 'E00-E90'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('E90*', 'Расстройства питания и нарушения обмена веществ при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'E00-E90'), 2); -- Корневая запись для "V Психические расстройства и расстройства поведения" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F00-F99', 'V Психические расстройства и расстройства поведения', NULL, 1); -- Дочерние записи для "F00-F99" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F00-F09', 'Органические, включая симптоматические, психические расстройства', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F00*', 'Деменция при болезни Альцгеймера', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F02*', 'Деменция при других болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F10-F19', 'Психические расстройства и расстройства поведения, связанные с употреблением психоактивных веществ', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F20-F29', 'Шизофрения, шизотипические и бредовые расстройства', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F30-F39', 'Расстройства настроения [аффективные расстройства]', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F40-F48', 'Невротические, связанные со стрессом, и соматоформные расстройства', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F50-F59', 'Поведенческие синдромы, связанные с физиологическими нарушениями и физическими факторами', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F60-F69', 'Расстройства личности и поведения в зрелом возрасте', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F70-F79', 'Умственная отсталость', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F80-F89', 'Расстройства психологического развития', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F90-F98', 'Эмоциональные расстройства, расстройства поведения, обычно начинающиеся в детском и подростковом возрасте', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('F99-F99', 'Неуточненные психические расстройства', (SELECT id FROM application_areas_medication WHERE code = 'F00-F99'), 2); -- Корневая запись для "VI Болезни нервной системы" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G00-G99', 'VI Болезни нервной системы', NULL, 1); -- Дочерние записи для "G00-G99" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G00-G09', 'Воспалительные болезни центральной нервной ситемы', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G01*', 'Менингит при бактериальных болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G02*', 'Менингит при других инфекционных и паразитарных болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G05*', 'Энцефалит, миелит и энцефаломиелит при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G07*', 'Внутричерепной и внутрипозвоночный абсцесс и гранулема при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G10-G14', 'Системные атрофии, поражающие преимущественно центральную нервную систему', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G13*', 'Системные атрофии, преимущественно поражающие центральную нервную систему при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G20-G26', 'Экстрапирамидные и другие двигательные нарушения', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G22*', 'Паркинсонизм при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G26*', 'Экстрапирамидные и другие двигательные нарушения при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G30-G32', 'Другие дегенеративные болезни центральной нервной системы', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G32*', 'Другие дегенеративные нарушения нервной системы при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G35-G37', 'Демиелинизирующие болезни центральной нервной системы', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G40-G47', 'Эпизодические и пароксизмальные расстройства', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G46*', 'Сосудистые мозговые синдромы при цереброваскулярных болезнях', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G50-G59', 'Поражения отдельных нервов, нервных корешков и сплетений', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G53*', 'Поражения черепных нервов при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G55*', 'Сдавления нервных корешков и сплетений при болезнях, классифицированных других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G59*', 'Мононевропатия при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G60-G64', 'Полиневропатии и другие поражения периферической нервной системы', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G63*', 'Полиневропатия при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G70-G73', 'Болезни нервно-мышечного синапса и мышц', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G73*', 'Поражения нервно-машечного синапса и мышц при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G80-G83', 'Церебральный паралич и другие паралитические синдромы', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G90-G99', 'Другие нарушения нервной системы', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G94*', 'Другие поражения головного мозга при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('G99*', 'Другие поражения нервной системы при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'G00-G99'), 2); -- Корневая запись для "VII Болезни глаза и его придаточного аппарата" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H00-H59', 'VII Болезни глаза и его придаточного аппарата', NULL, 1); -- Дочерние записи для "H00-H59" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H00-H06', 'Болезни век, слезных путей и глазницы', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H03*', 'Поражения века при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H06*', 'Поражения слезного аппарата и глазницы при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H10-H13', 'Болезни конъюнктивы', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H13*', 'Поражения конъюнктивы при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H15-H22', 'Болезни склеры, роговицы, радужной оболочки и цилиарного тела', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H19*', 'Поражения склеры и роговицы при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H22*', 'Поражения радужной оболочки и цилиарного тела при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H25-H28', 'Болезни хрусталика', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H28*', 'Катаракта и другие поражения хрусталика при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H30-H36', 'Болезни сосудистой оболочки и сетчатки', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H32*', 'Хориоретинальные нарушения при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H36*', 'Нарушения сетчатки при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H40-H42', 'Глаукома', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H42*', 'Глаукома при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H43-H45', 'Болезни стекловидного тела и глазного яблока', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H45*', 'Поражения стекловидного тела и глазного яблока при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H46-H48', 'Болезни зрительного нерва и зрительных путей', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H48*', 'Поражения зрительного [2-го] нерва и зрительных путей при болезнях, классифицированных других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H49-H52', 'Болезни мышц глаза, нарушения содружественного движения глаз, аккомодации и рефракции', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H53-H54', 'Зрительные расстройства и слепота', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H55-H59', 'Другие болезни глаза и его придаточного аппарата', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H58*', 'Другие поражения глаза и его придаточного аппарата при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H00-H59'), 2); -- Корневая запись для "Болезни уха и сосцевидного отростка" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H60-H95', 'Болезни уха и сосцевидного отростка', NULL, 1); -- Дочерние записи для "H60-H95" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H60-H62', 'Болезни наружного уха', (SELECT id FROM application_areas_medication WHERE code = 'H60-H95'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H62*', 'Поражения наружного уха при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H60-H95'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H65-H75', 'Болезни среднего уха и сосцевидного отростка', (SELECT id FROM application_areas_medication WHERE code = 'H60-H95'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H67*', 'Средний отит при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H60-H95'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H75*', 'Другие поражения среднего уха и сосцевидного отростка при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H60-H95'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H80-H83', 'Болезни внутреннего уха', (SELECT id FROM application_areas_medication WHERE code = 'H60-H95'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H82*', 'Вестибулярные синдромы при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H60-H95'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H90-H95', 'Другие болезни уха', (SELECT id FROM application_areas_medication WHERE code = 'H60-H95'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('H94*', 'Другие поражения уха при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'H60-H95'), 2); -- Корневая запись для "Болезни системы кровообращения" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I00-I99', 'Болезни системы кровообращения', NULL, 1); -- Дочерние записи для "I00-I99" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I00-I02', 'Острая ревматическая лихорадка', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I05-I09', 'Хронические ревматические болезни сердца', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I10-I15', 'Болезни, характеризующиеся повышенным кровяным давлением', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I20-I25', 'Ишемическая болезнь сердца', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I26-I28', 'Легочное сердце и нарушения легочного кровообращения', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I30-I52', 'Другие болезни сердца', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I32*', 'Перикардит при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I39*', 'Эндокардит и поражения клапанов сердца при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I41*', 'Миокардит при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I43*', 'Кардиомиопатии при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I52*', 'Другие поражения сердца при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I60-I69', 'Цереброваскулярные болезни', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I68*', 'Поражения сосудов мозга при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I70-I79', 'Болезни артерий, артериол и капилляров', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I79*', 'Поражения артерий, артериол и капилляров при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I80-I89', 'Болезни вен, лимфатических сосудов и лимфатических узлов, не классифицированные в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I95-I99', 'Другие и неуточненные болезни системы кровообращения', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('I98*', 'Другие нарушения системы кровообращения при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'I00-I99'), 2); -- Корневая запись для "Болезни органов дыхания" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J00-J99', 'Болезни органов дыхания', NULL, 1); -- Дочерние записи для "J00-J99" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J00-J06', 'Острые респираторные инфекции верхних дыхательных путей', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J09-J18', 'Грипп и пневмония', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J17*', 'Пневмония при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J20-J22', 'Другие острые респираторные инфекции нижних дыхательных путей', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J30-J39', 'Другие болезни верхних дыхательных путей', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J40-J47', 'Хронические болезни нижних дыхательных путей', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J60-J70', 'Болезни легкого, вызванные внешними агентами', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J80-J84', 'Другие респираторные болезни, поражающие главным образом интерстициальную ткань', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J85-J86', 'Гнойные и некротические состояния нижних дыхательных путей', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J90-J94', 'Другие болезни плевры', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J91*', 'Плевральный выпот при состояниях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J95-J99', 'Другие болезни органов дыхания', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('J99*', 'Респираторные нарушения при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'J00-J99'), 2); -- Корневая запись для "Болезни органов пищеварения" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K00-K93', 'Болезни органов пищеварения', NULL, 1); -- Дочерние записи для "K00-K93" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K00-K14', 'Болезни полости рта, слюнных желез и челюстей', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K20-K31', 'Болезни пищевода, желудка и двенадцатиперстной кишки', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K23*', 'Поражения пищевода при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K35-K38', 'Болезни аппендикса [червеобразного отростка]', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K40-K46', 'Грыжи', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K50-K52', 'Неинфекционные энтериты и колиты', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K55-K64', 'Другие болезни кишечника', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K65-K67', 'Болезни брюшины', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K67*', 'Поражения брюшины при инфекционных болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K70-K77', 'Болезни печени', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K77*', 'Поражения печени при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K80-K87', 'Болезни желчного пузыря, желчевыводящих путей и поджелудочной железы', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K87*', 'Поражения желчного пузыря, желчевыводящих путей и поджелудочной железы при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K90-K93', 'Другие болезни органов пищеварения', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('K93*', 'Поражения других органов пищеварения при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'K00-K93'), 2); -- Корневая запись для "Болезни кожи и подкожной клетчатки" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L00-L99', 'Болезни кожи и подкожной клетчатки', NULL, 1); -- Дочерние записи для "L00-L99" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L00-L08', 'Инфекции кожи и подкожной клетчатки', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L10-L14', 'Буллезные нарушения', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L14*', 'Буллезные нарушения кожи при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L20-L30', 'Дерматит и экзема', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L40-L45', 'Папулосквамозные нарушения', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L45*', 'Папулосквамозные нарушения при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L50-L54', 'Крапивница и эритема', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L54*', 'Эритема при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L55-L59', 'Болезни кожи и подкожной клетчатки, связанные с излучением', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L60-L75', 'Болезни придатков кожи', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L62*', 'Изменения ногтей при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L80-L99', 'Другие болезни кожи и подкожной клетчатки', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L86*', 'Кератодермии при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('L99*', 'Другие нарушения кожи и подкожной клетчатки при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'L00-L99'), 2); -- Корневая запись для "Болезни костно-мышечной системы и соединительной ткани" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M00-M99', 'Болезни костно-мышечной системы и соединительной ткани', NULL, 1); -- Дочерние записи для "M00-M99" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M00-M25', 'Артропатии', (SELECT id FROM application_areas_medication WHERE code = 'M00-M99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M00-M03', 'Инфекционные артропатии', (SELECT id FROM application_areas_medication WHERE code = 'M00-M25'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M01*', 'Прямое инфицирование сустава при инфекционных и паразитарных болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M00-M25'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M03*', 'Постинфекционные и реактивные артропатии при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M00-M25'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M05-M14', 'Воспалительные полиартропатии', (SELECT id FROM application_areas_medication WHERE code = 'M00-M25'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M07*', 'Псориатические и энтеропатические артропатии', (SELECT id FROM application_areas_medication WHERE code = 'M00-M25'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M09*', 'Ювенильный артрит при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M00-M25'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M14*', 'Артропатии при других болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M00-M25'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M15-M19', 'Артрозы', (SELECT id FROM application_areas_medication WHERE code = 'M00-M25'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M20-M25', 'Другие поражения суставов', (SELECT id FROM application_areas_medication WHERE code = 'M00-M25'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M30-M36', 'Системные поражения соединительной ткани', (SELECT id FROM application_areas_medication WHERE code = 'M00-M99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M36*', 'Системные поражения соединительной ткани при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M00-M99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M40-M54', 'Дорсопатии', (SELECT id FROM application_areas_medication WHERE code = 'M00-M99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M49*', 'Спондилопатии ткани при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M00-M99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M40-M43', 'Деформирующие дорсопатии', (SELECT id FROM application_areas_medication WHERE code = 'M40-M54'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M50-M54', 'Другие дорсопатии', (SELECT id FROM application_areas_medication WHERE code = 'M40-M54'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M60-M79', 'Болезни мягких тканей', (SELECT id FROM application_areas_medication WHERE code = 'M00-M99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M60-M63', 'Поражения мышц', (SELECT id FROM application_areas_medication WHERE code = 'M60-M79'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M63*', 'Поражения мышц при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M60-M79'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M65-M68', 'Поражения синовиальных оболочек и сухожилий', (SELECT id FROM application_areas_medication WHERE code = 'M60-M79'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M68*', 'Поражения синовиальных оболочек и сухожилий при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M60-M79'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M70-M79', 'Другие поражения мягких тканей', (SELECT id FROM application_areas_medication WHERE code = 'M60-M79'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M73*', 'Поражения мягких тканей при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M60-M79'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M80-M94', 'Остеопатии и хондропатии', (SELECT id FROM application_areas_medication WHERE code = 'M00-M99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M80-M85', 'Нарушения плотности и структуры кости', (SELECT id FROM application_areas_medication WHERE code = 'M80-M94'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M82*', 'Остеопороз при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M80-M94'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M86-M90', 'Другие остеопатии', (SELECT id FROM application_areas_medication WHERE code = 'M80-M94'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M90*', 'Остеопатии при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'M80-M94'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M91-M94', 'Хондропатии', (SELECT id FROM application_areas_medication WHERE code = 'M80-M94'), 3); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('M95-M99', 'Другие нарушения костно-мышечной системы и соединительной ткани', (SELECT id FROM application_areas_medication WHERE code = 'M00-M99'), 2); -- Корневая запись для "Болезни мочеполовой системы" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('N00-N99', 'Болезни мочеполовой системы', NULL, 1); -- Дочерние записи для "N00-N99" INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('N00-N08', 'Гломерулярные болезни', (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('N08', 'Гломерулярные поражения при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('N10-N16', 'Тубулоинтерстициальные болезни почек', (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('N16', 'Тубулоинтерстициальные поражения почек при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('N17-N19', 'Почечная недостаточность', (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('N20-N23', 'Мочекаменная болезнь', (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('N22', 'Камни мочевыводящих путей при болезнях, классифицированных в других рубриках', (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2); INSERT INTO application_areas_medication (code, name, parent_id, level) VALUES ('N25-N29', 'Другие болезни почки и мочеточника', (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N29', 'Другие поражения почки и мочеточника при болезнях, классифицированных в других рубриках',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N30-N39', 'Другие болезни мочевыделительной системы',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N33', 'Поражения мочевого пузыря при болезнях, классифицированных в других рубриках',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N37', 'Поражения мочеточника при болезнях, классифицированных в других рубриках',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N40-N51', 'Болезни мужских половых органов',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N51', 'Поражения мужских половых органов при болезнях, классифицированных в других рубриках',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N60-N64', 'Болезни молочной железы',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N70-N77', 'Воспалительные болезни женских тазовых органов',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N74',
        'Воспалительные поражения органов малого таза у женщин при болезнях, классифицированных в других рубриках',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N77*', 'Изъязвление и воспаление вульвы и влагалища при болезнях, классифицированных в других рубриках',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N80-N98', 'Невоспалительные болезни женских половых органов',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('N99-N99', 'Другие нарушения мочеполовой системы',
        (SELECT id FROM application_areas_medication WHERE code = 'N00-N99'), 2);

-- Корневая запись для "XVI Отдельные состояния, возникающие в перинатальном периоде"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P00-P96', 'XVI Отдельные состояния, возникающие в перинатальном периоде', NULL, 1);

-- Дочерние записи для "P00-P96"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P00-P04',
        'Поражение плода и новорожденного, обусловленные состояниями матери, осложнениями беременности, родов и родоразрешения',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P05-P08', 'Расстройства, связанные с продолжительностью беременности и ростом плода',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P10-P15', 'Родовая травма',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P20-P29', 'Дыхательные и сердечно-сосудистые нарушения, характерные для перинатального периода',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P35-P39', 'Инфекционные болезни, специфичные для перинатального периода',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P50-P61', 'Геморрагические и гематологические нарушения у плода и новорожденного',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P70-P74',
        'Преходящие эндокринные нарушения и нарушения обмена веществ, специфические для плода и новорожденного',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P75-P78', 'Расстройства системы пищеварения у плода и новорожденного',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P75*', 'Мекониевый илеус при кистозном фиброзе',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P80-P83', 'Состояния, затрагивающие кожные покровы и терморегуляцию у плода и новорожденного',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('P90-P96', 'Другие нарушения, возникающие в перинатальном периоде',
        (SELECT id FROM application_areas_medication WHERE code = 'P00-P96'), 2);

-- Корневая запись для "XVII Врожденные аномалии [пороки развития], деформации и хромосомные нарушения"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q00-Q99', 'XVII Врожденные аномалии [пороки развития], деформации и хромосомные нарушения', NULL, 1);

-- Дочерние записи для "Q00-Q99"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q00-Q07', 'Врожденные аномалии развития нервной системы',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q10-Q18', 'Врожденные аномалии глаза, уха, лица и шеи',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q20-Q28', 'Врожденные аномалии системы кровообращения',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q30-Q34', 'Врожденные аномалии органов дыхания',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q35-Q37', 'Расщелина губы и неба [заячья губа и волчья пасть]',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q38-Q45', 'Другие врожденные аномалии органов пищеварения',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q50-Q56', 'Врожденные аномалии половых органов',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q60-Q64', 'Врожденные аномалии мочевыделительной системы',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q65-Q79', 'Врожденные аномалии и деформации костно-мышечной системы',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q80-Q89', 'Другие врожденные аномалии',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Q90-Q99', 'Хромосомные нарушения, не классифицированные в других рубриках',
        (SELECT id FROM application_areas_medication WHERE code = 'Q00-Q99'), 2);

-- Корневая запись для "XVIII Симптомы, признаки и отклонения от нормы, выявленные при клинических и лабораторных исследованиях, не классифицированные в других рубриках"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R00-R99',
        'XVIII Симптомы, признаки и отклонения от нормы, выявленные при клинических и лабораторных исследованиях, не классифицированные в других рубриках',
        NULL, 1);

-- Дочерние записи для "R00-R99"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R00-R09', 'Симптомы и признаки, относящиеся к системам кровообращения и дыхания',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R10-R19', 'Симптомы и признаки, относящиеся к системам пищеварения и брюшной полости',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R20-R23', 'Симптомы и признаки, относящиеся к коже и подкожной клетчатке',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R25-R29', 'Симптомы и признаки, относящиеся к нервной и костно-мышечной системам',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R30-R39', 'Симптомы и признаки, относящиеся к мочевой системе',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R40-R46',
        'Симптомы и признаки, относящиеся к познавательной способности, восприятию, эмоциональному состоянию и поведению',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R47-R49', 'Симптомы и признаки, относящиеся к речи и голосу',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R50-R69', 'Общие симптомы и признаки',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R70-R79', 'Отклонения от нормы, выявленные при исследовании крови, при отсутствии диагноза',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R80-R82', 'Отклонения от нормы, выявленные при исследовании мочи, при отсутствии диагноза',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R83-R89',
        'Отклонения от нормы, выявленные при исследовании других жидкостей, субстанций и тканей организма, при отсутствии диагноза',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R90-R94',
        'Отклонения от нормы, выявленные при диагностических исследованиях с получением изображений и функциональных исследованиях, при отсутствии диагноза',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('R95-R99', 'Неточно обозначенные и неизвестные причины смерти',
        (SELECT id FROM application_areas_medication WHERE code = 'R00-R99'), 2);
-- Корневая запись для "XIX Травмы, отравления и некоторые другие последствия воздействия внешних причин"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S00-T98', 'XIX Травмы, отравления и некоторые другие последствия воздействия внешних причин', NULL, 1);

-- Дочерние записи для "S00-T98"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S00-S09', 'Травмы головы', (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S10-S19', 'Травмы шеи', (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S20-S29', 'Травмы грудной клетки', (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S30-S39', 'Травмы живота, нижней части спины, поясничного отдела позвоночника и таза',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S40-S49', 'Травмы плечевого пояса и плеча',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S50-S59', 'Травмы локтя и предплечья', (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'),
        2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S60-S69', 'Травмы запястья и кисти', (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S70-S79', 'Травмы области тазобедренного сустава и бедра',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S80-S89', 'Травмы колена и голени', (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('S90-S99', 'Травмы области голеностопного сустава и стопы',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);

-- Другие дочерние записи для "S00-T98"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T00-T07', 'Травмы, захватывающие несколько областей тела',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T08-T14', 'Травмы неуточненной части туловища, конечности или области тела',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T15-T19', 'Последствия проникновения инородного тела через естественные отверстия',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T20-T32', 'Термические и химические ожоги',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T20-T25', 'Термические и химические ожоги наружных поверхностей тела, уточненные по их локализации',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T26-T28', 'Термические и химические ожоги глаза и внутренних органов',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T29-T32', 'Термические и химические ожоги множественной и неуточненной части тела',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T33-T35', 'Отморожение', (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T36-T50', 'Отравления лекарственными средствами, медикаментами и биологическими веществами',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T51-T65', 'Токсическое действие веществ, преимущественно немедицинского назначения',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T66-T78', 'Другие и неуточненные эффекты воздействия внешних причин',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T79-T79', 'Некоторые ранние осложнения травмы',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T80-T88', 'Осложнения хирургических и терапевтических вмешательств, не классифицированные в других рубриках',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('T90-T98', 'Последствия травм, отравлений и других воздействий внешних причин',
        (SELECT id FROM application_areas_medication WHERE code = 'S00-T98'), 2);

-- Корневая запись для "XX Внешние причины заболеваемости и смертности"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V01-Y98', 'XX Внешние причины заболеваемости и смертности', NULL, 1);

-- Дочерние записи для "V01-Y98"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V01-X59', 'Несчастные случаи', (SELECT id FROM application_areas_medication WHERE code = 'V01-Y98'), 2);

-- Дочерние записи для "V01-X59"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V01-V99', 'Транспортные несчастные случаи',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-X59'), 3);

-- Дочерние записи для "V01-V99"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V01-V09', 'Пешеход, пострадавший в результате транспортного несчастного случая',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V10-V19', 'Велосипедист, пострадавший в результате транспортного несчастного случая',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V20-V29', 'Мотоциклист, пострадавший в результате транспортного несчастного случая',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V30-V39',
        'Лицо, находившееся в трехколесном транспортном средстве и пострадавшее в результате транспортного несчастного случая',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V40-V49',
        'Лицо, находившееся в легковом автомобиле и пострадавшее в результате транспортного несчастного случая',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V50-V59',
        'Лицо, находившееся в грузовом автомобиле типа пикап или фургоне и пострадавшее в результате транспортного несчастного случая',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V60-V69',
        'Лицо, находившееся в тяжелом грузовом автомобиле и пострадавшее в результате транспортного несчастного случая',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V70-V79', 'Лицо, находившееся в автобусе и пострадавшее в результате транспортного несчастного случая',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V80-V89', 'Несчастные случаи, связанные с другими наземными транспортными средствами',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V90-V94', 'Несчастные случаи на водном транспорте',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V95-V97', 'Несчастные случаи на воздушном транспорте и при космических полетах',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('V98-V99', 'Другие и неуточненные транспортные несчастные случаи',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-V99'), 4);

-- Дочерние записи для "V01-X59" (не относящиеся к "V01-V99")
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('W00-X59', 'Другие внешние причины травм при несчастных случаях',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-X59'), 3);

-- Дочерние записи для "W00-X59"
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('W00-W19', 'Падения', (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('W20-W49', 'Воздействие неживых механических сил',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('W50-W64', 'Воздействие живых механических сил',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('W65-W74', 'Случайное утопление или погружение в воду',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('W75-W84', 'Другие несчастные случаи с угрозой дыханию',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('W85-W99',
        'Несчастные случаи, вызванные воздействием электрического тока, излучения и крайних значений уровней температуры окружающей среды и атмосферного давления',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);

-- Корневая запись для "XXI Факторы, влияющие на состояние здоровья населения и обращения в учреждения здравоохранения" (Level 1)
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Z00-Z99', 'XXI Факторы, влияющие на состояние здоровья населения и обращения в учреждения здравоохранения',
        NULL, 1);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Z00-Z13', 'Обращения в учреждения здравоохранения для медицинского осмотра и обследования',
        (SELECT id FROM application_areas_medication WHERE code = 'Z00-Z99'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Z20-Z29', 'Потенциальная опасность для здоровья, связанная с инфекционными болезнями',
        (SELECT id FROM application_areas_medication WHERE code = 'Z00-Z99'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Z30-Z39',
        'Обращения в учреждения здравоохранения в связи с обстоятельствами, относящимися к репродуктивной функции',
        (SELECT id FROM application_areas_medication WHERE code = 'Z00-Z99'), 2);
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Z40-Z54',
        'Обращения в учреждения здравоохранения в связи с необходимостью проведения специфических процедур и получения медицинской помощи',
        (SELECT id FROM application_areas_medication WHERE code = 'Z00-Z99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Z55-Z65',
        'Потенциальная опасность для здоровья, связанная с социально-экономическими и психосоциальными обстоятельствами',
        (SELECT id FROM application_areas_medication WHERE code = 'Z00-Z99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Z70-Z76', 'Обращения в учреждения здравоохранения в связи с другими обстоятельствами',
        (SELECT id FROM application_areas_medication WHERE code = 'Z00-Z99'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Z80-Z99',
        'Потенциальная опасность для здоровья, связанная с личным или семейным анамнезом и определенными обстоятельствами, влияющими на здоровье',
        (SELECT id FROM application_areas_medication WHERE code = 'Z00-Z99'), 2);

-- Корневая запись для "XXII Коды для особых целей" (Level 1)
INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('U00-U85', 'XXII Коды для особых целей', NULL, 1);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('U00-U49',
        'Предварительное назначение новых заболеваний неопределенной этиологии или использования в чрезвычайных ситуациях',
        (SELECT id FROM application_areas_medication WHERE code = 'U00-U85'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('U82-U85', 'Устойчивость к противомикробным и противоопухолевым препаратам',
        (SELECT id FROM application_areas_medication WHERE code = 'U00-U85'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('X00-X09', 'Воздействие дыма, огня и пламени',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('X10-X19', 'Соприкосновение с горячими и раскаленными веществами (предметами)',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('X20-X29', 'Контакт с ядовитыми животными и растениями',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('X30-X39', 'Воздействие сил природы', (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('X40-X49', 'Случайное отравление и воздействие ядовитыми веществами',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('X50-X57', 'Перенапряжение, путешествия и лишения',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('X58-X59', 'Случайное воздействие других и неуточненных факторов',
        (SELECT id FROM application_areas_medication WHERE code = 'W00-X59'), 4);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('X60-X84', 'Преднамеренное самоповреждение',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-Y98'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('X85-Y09', 'Нападение', (SELECT id FROM application_areas_medication WHERE code = 'V01-Y98'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Y10-Y34', 'Повреждение с неопределенными намерениями',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-Y98'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Y35-Y36', 'Действия, предусмотренные законом, и военные операции',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-Y98'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Y40-Y84', 'Осложнения терапевтических и хирургических вмешательств',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-Y98'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Y40-Y59',
        'Лекарственные средства, медикаменты и биологические вещества, являющиеся причиной неблагоприятных реакций при их терапевтическом применении',
        (SELECT id FROM application_areas_medication WHERE code = 'Y40-Y84'), 3);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Y60-Y69', 'Случайное нанесение вреда больному при выполнении терапевтических (и хирургических) вмешательств',
        (SELECT id FROM application_areas_medication WHERE code = 'Y40-Y84'), 3);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Y70-Y82',
        'Медицинские приборы и устройства, с которыми связаны несчастные случаи, возникшие при их использовании для диагностических и терапевтических целей',
        (SELECT id FROM application_areas_medication WHERE code = 'Y40-Y84'), 3);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Y83-Y84',
        'Хирургические и другие медицинские процедуры как причина анормальной реакции или позднего осложнения у пациента без упоминания о случайном нанесении ему вреда во время их выполнения',
        (SELECT id FROM application_areas_medication WHERE code = 'Y40-Y84'), 3);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Y85-Y89', 'Последствия воздействия внешних причин заболеваемости и смертности',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-Y98'), 2);

INSERT INTO application_areas_medication (code, name, parent_id, level)
VALUES ('Y90-Y98',
        'Дополнительные факторы, имеющие отношение к заболеваемости и смертности, классифицированным в других рубриках',
        (SELECT id FROM application_areas_medication WHERE code = 'V01-Y98'), 2);

INSERT INTO assessment_demand_device (name, description)
VALUES ('Онкология',
        'Оценка востребованности медицинских изделий в области диагностики, лечения и профилактики онкологических заболеваний.'),
       ('Кардиология и ССХ',
        'Оценка востребованности медицинских изделий для диагностики, лечения и профилактики заболеваний сердечно-сосудистой системы.'),
       ('Телемедицина и IT-технологи',
        'Оценка востребованности медицинских изделий и IT-решений в сфере телемедицины для дистанционного оказания медицинской помощи.'),
       ('Инфекционные заболевания',
        'Оценка востребованности медицинских изделий для диагностики, лечения и профилактики инфекционных заболеваний.'),
       ('Реконструктивная и регенеративная медицина',
        'Оценка востребованности медицинских изделий и технологий в области восстановления тканей и органов, стимуляции процессов регенерации.'),
       ('Эндокринология',
        'Оценка востребованности медицинских изделий для диагностики, лечения и мониторинга эндокринных заболеваний.'),
       ('Неврология и нейрореабилитиация, психиатрия',
        'Оценка востребованности медицинских изделий для диагностики, лечения и реабилитации пациентов с неврологическими и психическими расстройствами.'),
       ('Офтальмология',
        'Оценка востребованности медицинских изделий для диагностики, лечения и коррекции заболеваний глаз.'),
       ('Травматология и ортопедия',
        'Оценка востребованности медицинских изделий для лечения травм и заболеваний опорно-двигательного аппарата.'),
       ('Анестезиология и реаниматология',
        'Оценка востребованности медицинских изделий для обеспечения анестезии, поддержания жизненно важных функций организма и проведения реанимационных мероприятий.');

INSERT INTO application_areas_device (name, description)
VALUES ('Анатомия и морфология',
        'Изучение структуры и формы организма, а также его составных частей на макро- и микроскопическом уровнях.'),
       ('Медицинская генетика',
        'Раздел медицины, изучающий роль наследственности в патологии человека, наследственные болезни и методы их диагностики, лечения и профилактики.'),
       ('Иммунология',
        'Наука, изучающая иммунную систему и её функции, включая защиту организма от инфекций и других чужеродных агентов.'),
       ('Нейронауки (включая клиническую психологию)',
        'Комплекс дисциплин, изучающих нервную систему, её структуру, функции, развитие, генетику, биохимию, физиологию и патологию. Клиническая психология занимается изучением психических расстройств.'),
       ('Фармакология и фармацевтика',
        'Науки, изучающие лекарственные вещества, их действие на организм, а также разработку, производство и применение лекарственных препаратов.'),
       ('Клиническая биохимия',
        'Раздел биохимии, изучающий химические процессы, происходящие в организме человека в норме и при патологии, а также их использование для диагностики и мониторинга заболеваний.'),
       ('Токсикология', 'Наука, изучающая яды, их действие на организм и методы лечения отравлений.'),
       ('Физиология',
        'Наука, изучающая функции организма и его систем, механизмы регуляции этих функций, а также приспособление организма к условиям окружающей среды.'),
       ('Патология',
        'Наука, изучающая структурные и функциональные изменения в организме при болезни, а также причины и механизмы развития заболеваний.'),
       ('Андрология', 'Раздел медицины, занимающийся изучением и лечением заболеваний мужской половой сферы.'),
       ('Акушерство и гинекология',
        'Раздел медицины, занимающийся изучением и лечением заболеваний женской репродуктивной системы, а также ведением беременности и родов.'),
       ('Педиатрия', 'Раздел медицины, занимающийся изучением и лечением заболеваний детского возраста.'),
       ('Сердечно-сосудистая система',
        'Область медицины, фокусирующаяся на сердце и кровеносных сосудах, их функциях и заболеваниях.'),
       ('Болезни периферических сосудов',
        'Раздел медицины, изучающий заболевания артерий и вен, расположенных вне сердца и головного мозга.'),
       ('Гематология', 'Раздел медицины, изучающий кровь, органы кроветворения и заболевания крови.'),
       ('Дыхательная система',
        'Область медицины, занимающаяся легкими и дыхательными путями, их функциями и заболеваниями.'),
       ('Реаниматология',
        'Раздел медицины, занимающийся восстановлением и поддержанием жизненно важных функций организма при критических состояниях.'),
       ('Анестезиология',
        'Раздел медицины, занимающийся обезболиванием при хирургических операциях и других медицинских процедурах, а также поддержанием жизненно важных функций организма во время анестезии.'),
       ('Ортопедия',
        'Раздел медицины, занимающийся диагностикой, лечением и профилактикой заболеваний и травм опорно-двигательного аппарата.'),
       ('Хирургия', 'Раздел медицины, занимающийся лечением заболеваний и травм путем оперативного вмешательства.'),
       ('Рентгенология, радиационная медицина, медицинская визуализация',
        'Раздел медицины, занимающийся использованием рентгеновских лучей, радиоактивных веществ и других методов для диагностики и лечения заболеваний.'),
       ('Трансплантология и искусственные органы',
        'Раздел медицины, занимающийся пересадкой органов и тканей, а также разработкой и применением искусственных органов.'),
       ('Стоматология и хирургическая стоматология',
        'Раздел медицины, занимающийся заболеваниями полости рта, зубов и челюстно-лицевой области, а также хирургическими вмешательствами в этой области.'),
       ('Дерматология и венерические заболевания',
        'Раздел медицины, занимающийся заболеваниями кожи, волос и ногтей, а также заболеваниями, передающимися половым путем.'),
       ('Аллергология',
        'Раздел медицины, занимающийся диагностикой, лечением и профилактикой аллергических заболеваний.'),
       ('Ревматология',
        'Раздел медицины, занимающийся диагностикой, лечением и профилактикой заболеваний суставов, соединительной ткани и системных васкулитов.'),
       ('Эндокринология и обмен веществ',
        'Раздел медицины, занимающийся диагностикой, лечением и профилактикой заболеваний эндокринной системы и нарушений обмена веществ.'),
       ('Гастроэнтерология и гепатология',
        'Раздел медицины, занимающийся заболеваниями органов пищеварения, печени и желчевыводящих путей.'),
       ('Урология и нефрология',
        'Раздел медицины, занимающийся заболеваниями мочевыделительной системы и мужской половой сферы, а также заболеваниями почек.'),
       ('Онкология', 'Раздел медицины, занимающийся изучением, диагностикой и лечением злокачественных опухолей.'),
       ('Офтальмология', 'Раздел медицины, занимающийся заболеваниями глаз и зрительного аппарата.'),
       ('Оториноларингология', 'Раздел медицины, занимающийся заболеваниями уха, горла и носа.'),
       ('Психиатрия', 'Раздел медицины, занимающийся диагностикой, лечением и профилактикой психических расстройств.'),
       ('Клиническая неврология', 'Раздел медицины, занимающийся диагностикой и лечением заболеваний нервной системы.'),
       ('Гериатрия и геронтология',
        'Раздел медицины, занимающийся изучением старения и заболеваний пожилого возраста.'),
       ('Терапия и лечебное дело',
        'Раздел медицины, занимающийся диагностикой и лечением внутренних болезней нехирургическими методами.'),
       ('Прочие предметы клинической медицины',
        'Различные области клинической медицины, не вошедшие в основные категории.'),
       ('Интегративная и комплементарная медицина',
        'Подход к медицине, сочетающий традиционные и нетрадиционные методы лечения.'),
       ('Медицина катастроф',
        'Раздел медицины, занимающийся организацией медицинской помощи при катастрофах и чрезвычайных ситуациях.'),
       ('Первичная медицинская помощь',
        'Первый уровень контакта населения с системой здравоохранения, включающий профилактику, диагностику и лечение наиболее распространенных заболеваний.'),
       ('Колопроктология',
        'Раздел хирургии, занимающийся диагностикой и лечением заболеваний толстой кишки, прямой кишки и заднего прохода.'),
       ('Медицинские услуги', 'Общий термин, охватывающий все виды медицинских услуг, предоставляемых населению.'),
       ('Организация здравоохранения',
        'Раздел медицины, занимающийся вопросами организации и управления системой здравоохранения.'),
       ('Сестринское дело', 'Раздел медицины, занимающийся уходом за больными и оказанием им медицинской помощи.'),
       ('Питание и диетология',
        'Раздел медицины, занимающийся изучением влияния питания на здоровье человека и разработкой диетических рекомендаций.'),
       ('Общественное здравоохранение, гигиена окружающей среды',
        'Раздел медицины, занимающийся профилактикой заболеваний и улучшением здоровья населения путем воздействия на факторы окружающей среды и образ жизни.'),
       ('Тропическая медицина',
        'Раздел медицины, занимающийся заболеваниями, распространенными в тропических регионах.'),
       ('Паразитология', 'Наука, изучающая паразитов и вызываемые ими заболевания.'),
       ('Инфекционные болезни',
        'Раздел медицины, занимающийся диагностикой, лечением и профилактикой инфекционных заболеваний.'),
       ('Эпидемиология',
        'Наука, изучающая закономерности распространения заболеваний в популяции и факторы, влияющие на эти закономерности.'),
       ('Гигиена труда',
        'Раздел медицины, занимающийся изучением влияния условий труда на здоровье человека и разработкой мероприятий по улучшению условий труда.'),
       ('Науки о спорте',
        'Междисциплинарная область, изучающая влияние физической активности на здоровье человека, а также оптимизацию тренировочного процесса.'),
       ('Общественные науки - биомедицина',
        'Область исследований, изучающая социальные и поведенческие факторы, влияющие на здоровье человека.'),
       ('Медицинская этика',
        'Раздел этики, изучающий моральные и этические проблемы, возникающие в медицинской практике.'),
       ('Исследования наркотической зависимости, токсикомании, алкоголизма',
        'Область исследований, изучающая причины, механизмы и последствия наркотической зависимости, токсикомании и алкоголизма.'),
       ('Медицинская реабилитация',
        'Комплекс мероприятий, направленных на восстановление здоровья и трудоспособности больных и инвалидов.'),
       ('Информационные технологии в здравоохранении',
        'Раздел медицины, занимающийся применением информационных технологий для улучшения качества и эффективности медицинской помощи.'),
       ('Клеточная и тканевая инженерия',
        'Область исследований, занимающаяся созданием искусственных тканей и органов из клеток и биоматериалов.'),
       ('Биомедицинская инженерия',
        'Раздел инженерии, занимающийся разработкой медицинских приборов, оборудования и технологий.'),
       ('Биоматериалы для медицинского применения',
        'Область исследований, занимающаяся разработкой и применением материалов, используемых в медицинских устройствах и имплантатах.'),
       ('Медицинские лабораторные технологии',
        'Область, включающая в себя методы и оборудование для проведения лабораторных исследований в медицине.'),
       ('Судебная медицина',
        'Раздел медицины, занимающийся применением медицинских знаний для решения правовых вопросов.'),
       ('Прочие медицинские науки', 'Различные области медицинских наук, не вошедшие в основные категории.');

INSERT INTO medical_device_technology_readiness_levels (level, description)
VALUES (1, 'Сформулирована фундаментальная концепция'),
       (2, 'Определены целевые области применения'),
       (3, 'Подготовлен макетный образец'),
       (4, 'Подготовлен экспериментальный образец'),
       (5, 'Изготовлен и испытан опытный образец'),
       (6, 'Изготовлен серийный образец'),
       (7, 'Проведены испытания серийного образца или серии образцов'),
       (8,
        'Окончательно подтверждены качество, эффективность и безопасность медицинского изделия, запущено опытно-промышленное производство'),
       (9, 'Серийно производимое зарегистрированное медицинское изделие');

INSERT INTO risk_classes (code, name, description)
VALUES ('CLASS_1', 'Класс 1',
        'Медицинские изделия с низким уровнем риска.  Обычно не требуют уведомления перед продажей.'),
       ('CLASS_2A', 'Класс 2а',
        'Медицинские изделия со средним уровнем риска.  Требуют специальных средств контроля для обеспечения безопасности и эффективности.'),
       ('CLASS_2B', 'Класс 2б',
        'Медицинские изделия со средним/высоким уровнем риска. Требуют более строгого контроля по сравнению с классом 2а.'),
       ('CLASS_3', 'Класс 3',
        'Медицинские изделия с высоким уровнем риска.  Обычно имплантируемые или поддерживающие жизнь изделия.');

