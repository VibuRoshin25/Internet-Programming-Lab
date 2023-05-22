-- Create the 'products' table
CREATE TABLE products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  price DECIMAL(10,2) NOT NULL
);

-- Insert sample products
INSERT INTO products (name, price) VALUES
('Product 1', 10.99),
('Product 2', 19.99),
('Product 3', 5.99),
('Product 4', 14.99);
