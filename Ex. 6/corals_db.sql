-- Create the corals_db database
CREATE DATABASE corals_db;

-- Switch to the corals_db database
USE corals_db;

-- Create the corals table
CREATE TABLE corals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(100) NOT NULL,
    color VARCHAR(100) NOT NULL
);

-- Insert sample data into the corals table
INSERT INTO corals (name, type, color)
VALUES ('Brain Coral', 'LPS', 'Purple'),
       ('Acropora', 'SPS', 'Green'),
       ('Mushroom Coral', 'Soft Coral', 'Various Colors');
