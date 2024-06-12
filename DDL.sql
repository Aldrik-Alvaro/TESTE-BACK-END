drop user if exists 'user'@'localhost';

drop schema if exists hmzteste;

create schema hmzteste;

use hmzteste;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on hmzteste.* to user@'localhost';



CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    senha VARCHAR(255),
    nome VARCHAR(255),
    email VARCHAR(255),
    role VARCHAR(255)
);


INSERT INTO usuario (username, senha, nome, email, role) VALUES 
('user1', 'password1', 'Aldrik Alvaro', 'aldrikalvaro@example.com', 'user'),
('user2', 'password2', 'Aldrik Faria', 'aldrikfaria@example.com', 'user'),
('admin', 'admin', 'Admin User', 'admin@example.com', 'admin');


