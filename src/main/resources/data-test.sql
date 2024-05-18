INSERT INTO `color` (name) VALUES
                             ('Red'),
                             ('Blue'),
                             ('Green'),
                             ('Yellow'),
                             ('Black'),
                             ('White');

INSERT INTO `brand` (name) VALUES ('BMW'), ('Audi'), ('Porsche');

INSERT INTO `car_model` (name, brandId) VALUES
                                          ('e39', 1),
                                          ('e46', 1),
                                          ('e30', 1),
                                          ('a4', 2),
                                          ('a5', 2),
                                          ('a6', 2),
                                          ('Cayenne', 3),
                                          ('911', 3),
                                          ('Carrera', 3);

INSERT INTO `car` (colorId, mileage, modelId, registrationNumber) VALUES (1, 150000, 5, 'ABC1234');

INSERT INTO `city` (name, region, country, postalCode)
VALUES
    ('London', 'Greater London', 'United Kingdom', 'SW1A 1AA');

INSERT INTO `address` (street, building, cityId)
VALUES
    ('Street1', 1, 1);

INSERT INTO `_user` (fullName, addressId)
VALUES
    ('User1', 1);

INSERT INTO `car_rental` (rentedFrom, rentedTo, userId, carId) VALUES
    ('2024-02-17 08:00:00', '2024-02-19 17:00:00', 1, 1);