CREATE TABLE IF NOT EXISTS product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    price DECIMAL(10, 2) NOT NULL,
    category VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    stock_quantity INT
);

