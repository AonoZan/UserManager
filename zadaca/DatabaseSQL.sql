CREATE DATABASE IF NOT EXISTS userManager;
USE userManager;
CREATE TABLE IF NOT EXISTS users (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(80),
    password INT(4),
    age INT(3)
);
INSERT INTO users (name, password, age) VALUES ( 'test', 0000, 25);
SELECT * FROM users;
DROP DATABASE userManager;