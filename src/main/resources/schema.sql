create schema if not exists netology;

CREATE TABLE ORDERS(
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    customer_id INT,
    product_name VARCHAR (30),
    amount INT
);

CREATE TABLE CUSTOMERS(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    surname VARCHAR(30),
    age INT,
    phone_number VARCHAR(12)
);