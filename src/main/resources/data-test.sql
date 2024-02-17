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

INSERT INTO car (colorId, mileage, modelId, registrationNumber) VALUES (1, 150000, 5, 'ABC1234');