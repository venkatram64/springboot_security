http://localhost:8080/

http://localhost:8080/admin

http://localhost:8080/logout

http://localhost:8080/user


create table users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username varchar(50) not null unique,
    password varchar(120) not null,
    enabled boolean not null
);

create table roles (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role varchar(50) not null
);

CREATE TABLE user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY `user_fk` (`user_id`) REFERENCES `users` (`id`),
    FOREIGN KEY `role_fk` (`role_id`) REFERENCES `roles` (`id`)
);


INSERT INTO `mysecurity`.`users` (`username`, `password`, `enabled`) VALUES ('venkat', 'venkat', '1');
INSERT INTO `mysecurity`.`users` (`username`, `password`, `enabled`) VALUES ('srijan', 'srijan', '1');

INSERT INTO `mysecurity`.`roles` (`role`) VALUES ('admin');
INSERT INTO `mysecurity`.`roles` (`role`) VALUES ('user');


INSERT INTO `mysecurity`.`user_roles` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `mysecurity`.`user_roles` (`user_id`, `role_id`) VALUES (2, 2);



Spring boot jwt authentication
step 1: Post request in postman
http://localhost:8080/auth/authenticate
{ "username":"venkat", "password":"venkat" }
gets jwt token
step 2: get request
http://localhost:8080/home/admin
ContentType = application/json
Authorization = Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNTc4NTM4MDY1LCJpYXQiOjE1Nzg1MDIwNjV9.PhzjA1yQv5pxW-m6SC5yT5kSPG7L1z1BWsMRYR7r04E
