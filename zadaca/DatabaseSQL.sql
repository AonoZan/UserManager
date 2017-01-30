CREATE DATABASE IF NOT EXISTS userManager;
USE userManager;
CREATE TABLE IF NOT EXISTS users (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(80),
    password INT(4),
    age INT(3)
);
INSERT INTO users (name, password, age) VALUES ( 'dejan', 12, 25);
INSERT INTO users (name, password) VALUES ('jaja', 54);
UPDATE users SET name = 'hija' WHERE name = 'jaja';
#SELECT * FROM users WHERE name = 'dejan' AND password = 12;
SELECT * FROM users;
#DROP DATABASE userManager;