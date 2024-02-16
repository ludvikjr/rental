
INSERT INTO color (name) VALUES
                             ('Red'),
                             ('Blue'),
                             ('Green'),
                             ('Yellow'),
                             ('Black'),
                             ('White'),
                             ('Silver'),
                             ('Gray'),
                             ('Orange'),
                             ('Purple'),
                             ('Brown'),
                             ('Gold'),
                             ('Navy'),
                             ('Tan'),
                             ('Maroon'),
                             ('Beige'),
                             ('Cyan'),
                             ('Magenta'),
                             ('Olive'),
                             ('Teal');

INSERT INTO brand (name) VALUES ('BMW'), ('Audi'), ('Porsche');

INSERT INTO car_model (name, brandId) VALUES
                                          ('e39', 1),
                                          ('e46', 1),
                                          ('e30', 1),
                                          ('a4', 2),
                                          ('a5', 2),
                                          ('a6', 2),
                                          ('Cayenne', 3),
                                          ('911', 3),
                                          ('Carrera', 3);

INSERT INTO car (colorId, mileage, modelId, registrationNumber)
VALUES
    (1, 150000, 5, 'ABC1234'),
    (2, 100000, 7, 'DEF5678'),
    (3, 200000, 3, 'GHI9012'),
    (4, 80000, 2, 'JKL3456'),
    (5, 180000, 9, 'MNO7890'),
    (6, 120000, 1, 'PQR1234'),
    (7, 70000, 4, 'STU5678'),
    (8, 220000, 6, 'VWX9012'),
    (9, 90000, 8, 'YZA3456'),
    (10, 160000, 5, 'BCD7890'),
    (11, 130000, 3, 'EFG1234'),
    (12, 240000, 2, 'HIJ5678'),
    (13, 60000, 9, 'KLM9012'),
    (14, 170000, 1, 'NOP1234'),
    (15, 110000, 7, 'QRS5678'),
    (16, 190000, 4, 'TUV9012'),
    (17, 100000, 6, 'WXY1234'),
    (18, 210000, 8, 'ZAB5678'),
    (19, 140000, 5, 'CDE9012'),
    (20, 230000, 3, 'FGH1234');
