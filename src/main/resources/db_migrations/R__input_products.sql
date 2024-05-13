INSERT INTO Producers (name)
VALUES ('Bosch'),
       ('Michelin'),
       ('Castrol'),
       ('Ford'),
       ('Toyota'),
       ('Honda'),
       ('General Motors'),
       ('Nissan'),
       ('BMW'),
       ('Mercedes-Benz');
INSERT INTO Categories (category_name, category_description)
VALUES ('Engine Parts', 'Parts related to the engine system'),
       ('Tires', 'Different types and sizes of tires'),
       ('Lubricants', 'Oils and lubricants for vehicles'),
       ('Brake Parts', 'Components for braking systems'),
       ('Suspension Parts', 'Parts related to vehicle suspension'),
       ('Electrical Parts', 'Components related to the electrical system of vehicles'),
       ('Transmission Parts', 'Parts for the transmission system'),
       ('Exhaust Parts', 'Components related to the exhaust system'),
       ('Interior Accessories', 'Accessories for the interior of vehicles'),
       ('Exterior Accessories', 'Accessories for the exterior of vehicles');
INSERT INTO Cars (brand, model)
VALUES ('Toyota', 'Corolla'),
       ('Honda', 'Civic'),
       ('Ford', 'Fusion'),
       ('Nissan', 'Altima'),
       ('BMW', '3 Series'),
       ('Mercedes-Benz', 'C-Class'),
       ('Audi', 'A4'),
       ('Chevrolet', 'Malibu'),
       ('Volkswagen', 'Jetta'),
       ('Subaru', 'Impreza');
INSERT INTO Clients (name, surname, address, email, phone, order_quantity)
VALUES ('Michael', 'Johnson', '123 Main St', 'michael@example.com', '063-456-7890', 5),
       ('Emily', 'Smith', '456 Oak St', 'emily@example.com', '067-654-3210', 3),
       ('William', 'Brown', '789 Elm St', 'william@example.com', '093-222-3333', 7);
INSERT INTO StoreHouses (name, location)
VALUES ('Warehouse A', 'Kiev'),
       ('Warehouse B', 'Lviv'),
       ('Warehouse C', 'Cherkassy');

INSERT INTO AutoParts (part_name, part_desc, part_producer_id, part_price, category_id, storage_house_id,
                       purchase_price, part_image, count, sales)
VALUES ('Spark Plugs', 'Iridium spark plugs for improved performance', 1, 10, 1, 1, 8, NULL, 100, 20),
       ('All-Season Tires', 'Michelin all-season tires for various vehicles', 2, 150, 2, 2, 120, NULL, 80, 15),
       ('Engine Oil', 'Castrol synthetic engine oil for better engine protection', 3, 30, 3, 3, 25, NULL, 120, 25),
       ('Brake Pads', 'OEM brake pads for reliable stopping power', 4, 50, 4, 1, 40, NULL, 150, 30),
       ('Shock Absorbers', 'High-quality shock absorbers for a smooth ride', 5, 80, 5, 2, 65, NULL, 90, 10),
       ('Alternators', 'Alternators for efficient electrical power generation', 6, 120, 6, 3, 100, NULL, 70, 5),
       ('Clutch Kits', 'Complete clutch kits for manual transmissions', 7, 200, 7, 1, 180, NULL, 40, 8),
       ('Mufflers', 'Performance mufflers for improved exhaust flow', 8, 150, 8, 2, 130, NULL, 60, 12),
       ('Floor Mats', 'Custom-fit floor mats for vehicle interiors', 9, 50, 9, 3, 40, NULL, 200, 20),
       ('Roof Racks', 'Durable roof racks for carrying extra cargo', 10, 100, 10, 1, 80, NULL, 100, 15);

INSERT INTO Orders (client_id, status, total_amount, order_date)
VALUES (1, 'Pending', 200, '2024-05-09'),
       (2, 'Completed', 225, '2024-05-08'),
       (3, 'Pending', 350, '2024-05-07');
INSERT INTO OrderParts (order_id, auto_part_id)
VALUES (1, 1),
       (1, 2),
       (2, 2),
       (3, 3);
INSERT INTO CarParts (car_id, part_id)
VALUES (1, 1),
       (2, 2),
       (3, 3);








