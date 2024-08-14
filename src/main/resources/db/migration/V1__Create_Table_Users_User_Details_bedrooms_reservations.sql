CREATE TABLE users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(50) NOT NULL,
    role ENUM('GUEST','EMPLOYEE'),
    PRIMARY KEY(id)
)ENGINE = InnoDB;

CREATE TABLE user_details(
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    name VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    address VARCHAR(80) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_user_details_user_id_users_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
)ENGINE = InnoDB;

CREATE TABLE bedrooms(
    id BIGINT NOT NULL AUTO_INCREMENT,
    number INT NOT NULL UNIQUE,
    type VARCHAR(20) NOT NULL,
    description VARCHAR(200) NOT NULL,
    capacity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE reservations(
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    bedroom_id BIGINT NOT NULL,
    arrival_date TIMESTAMP NOT NULL,
    departure_date TIMESTAMP,
    PRIMARY KEY(id),
    CONSTRAINT fk_reservations_user_id_users FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_reservations_bedroom_id_user_id_bedrooms FOREIGN KEY(bedroom_id) REFERENCES bedrooms(id) ON DELETE CASCADE

)ENGINE=InnoDB;