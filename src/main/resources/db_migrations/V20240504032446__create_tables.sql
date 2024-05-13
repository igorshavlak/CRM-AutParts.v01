CREATE TABLE Producers
(
    id   INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255)
);
CREATE TABLE Categories
(
    category_id          INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    category_name        VARCHAR(255),
    category_description TEXT

);
CREATE TABLE StoreHouses
(
    id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name     VARCHAR(255),
    location VARCHAR(255)

);
CREATE TABLE Clients
(
    id             INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name           VARCHAR(255),
    surname        VARCHAR(255),
    address        VARCHAR(255),
    email          VARCHAR(255),
    phone          VARCHAR(255),
    order_quantity INT

);
CREATE TABLE AutoParts
(
    part_id          INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    part_name        VARCHAR(255),
    part_desc        TEXT,
    part_producer_id INT,
    part_price       INT,
    category_id      INT,
    storage_house_id INT,
    purchase_price   INT,
    part_image       BYTEA,
    count            INT,
    sales            INT,
    FOREIGN KEY (category_id) REFERENCES Categories (category_id),
    FOREIGN KEY (storage_house_id) REFERENCES StoreHouses (id),
    FOREIGN KEY (part_producer_id) REFERENCES Producers (id)
);
CREATE TABLE Orders
(
    id           INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    client_id    INT,
    status       VARCHAR(255),
    total_amount INT,
    order_date   DATE,
    FOREIGN KEY (client_id) REFERENCES Clients (id)

);
CREATE TABLE OrderParts
(
    order_id     INT,
    auto_part_id INT,
    PRIMARY KEY (order_id, auto_part_id),
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (auto_part_id) REFERENCES autoparts (part_id)
);
CREATE TABLE Cars (
                      car_id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                      brand VARCHAR(255),
                      model VARCHAR(255)
);
CREATE TABLE CarParts (
                          car_id INT,
                          part_id INT,
                          PRIMARY KEY (car_id, part_id),
                          FOREIGN KEY (car_id) REFERENCES cars(car_id),
                          FOREIGN KEY (part_id) REFERENCES autoparts(part_id)
);

