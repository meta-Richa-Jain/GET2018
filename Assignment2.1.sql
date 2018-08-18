CREATE DATABASE StoreFront;
USE StoreFront;
#Question 1
#Create all tables of eCommerce Application: StoreFront 

#table user_type
CREATE TABLE user_type(
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(15) NOT NULL UNIQUE
);

#table users
CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(25) NOT NULL,
	last_name VARCHAR(25) ,
	user_password VARCHAR(10)NOT NULL,
	email_id VARCHAR(50) NOT NULL UNIQUE,
	user_type INT,
	FOREIGN KEY  (user_type) REFERENCES user_type(id)
);

CREATE TABLE zip_code(
	pin_code INT PRIMARY KEY,
    area VARCHAR(25) not null,
	city VARCHAR(25) not null ,
	state VARCHAR(25) not null ,
	country VARCHAR(25) default "india"
);

#table address
CREATE TABLE address(
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT NOT NULL ,
	pin_code INT not null,
	FOREIGN KEY  (user_id) REFERENCES users(id),
    FOREIGN KEY (pin_code) REFERENCES zip_code(pin_code)
);



#table category
CREATE TABLE category(
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(25) NOT NULL UNIQUE,
	parent_category INT DEFAULT NULL,
	FOREIGN KEY  (parent_category) REFERENCES category(id)
);

#table product
CREATE TABLE product(
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(25) not null UNIQUE,
	description VARCHAR(50),
	amount INT NOT NULL,
	stock INT NOT NULL,
    arrival_date DATETIME NOT NULL
);

#table product category relation
CREATE TABLE product_category_relation(
	product_id INT NOT NULL,
	category_id INT NOT NULL,
	PRIMARY KEY(product_id,category_id),
	FOREIGN KEY  (product_id) REFERENCES product (id) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY  (category_id) REFERENCES category(id) ON UPDATE CASCADE ON DELETE CASCADE
);

#table image
CREATE TABLE image(
	id INT PRIMARY KEY AUTO_INCREMENT,
	url VARCHAR(25) NOT NULL,
	title VARCHAR(25) NOT NULL UNIQUE,
	product_id INT NOT NULL,
	FOREIGN KEY  (product_id) REFERENCES product(id)
);

#table orders
CREATE TABLE orders(
	id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT NOT NULL,
	total_amount INT NOT NULL,
	placed_date DATETIME NOT NULL,
	address_id INT NOT NULL,
	FOREIGN KEY  (address_id) REFERENCES address(id),
	FOREIGN KEY  (user_id) REFERENCES users(id)
);

#table items status
CREATE TABLE items_status(
	order_id INT NOT NULL,
	product_id INT NOT NULL,
	status VARCHAR(10) CHECK(status IN ("placed", "shipped", "delivered", "cancelled", "returned")),
	quantity INT NOT NULL,
	ship_date DATETIME DEFAULT NULL,
	deliver_date DATETIME DEFAULT NULL,
	PRIMARY KEY(order_id,product_id),
	FOREIGN KEY  (order_id) REFERENCES orders(id) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY  (product_id) REFERENCES product(id) ON UPDATE CASCADE ON DELETE CASCADE
);

#Write a command to display all the table names present in StoreFront.
show tables;
#Write a command to remove Product table of the StoreFront database.
drop table product_category_relation;
drop table image;
drop table items_status;
drop table product;

#Create the Product table again.
CREATE TABLE product(
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(25) not null UNIQUE,
	description VARCHAR(50),
	amount INT NOT NULL,
	stock INT NOT NULL,
    arrival_date DATETIME NOT NULL
);

#Create the product_category_relation table again.
CREATE TABLE product_category_relation(
	product_id INT NOT NULL,
	category_id INT NOT NULL,
	PRIMARY KEY(product_id,category_id),
	FOREIGN KEY  (product_id) REFERENCES product (id) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY  (category_id) REFERENCES category(id) ON UPDATE CASCADE ON DELETE CASCADE
);

#Create the image table again.
CREATE TABLE image(
	id INT PRIMARY KEY AUTO_INCREMENT,
	url VARCHAR(25) NOT NULL,
	title VARCHAR(25) NOT NULL UNIQUE,
	product_id INT NOT NULL,
	FOREIGN KEY  (product_id) REFERENCES product(id)
); 

#Create the items_status table again.
CREATE TABLE items_status(
	order_id INT NOT NULL,
	product_id INT NOT NULL,
	status VARCHAR(10) CHECK(status IN ("placed", "shipped", "delivered", "cancelled", "returned")),
	quantity INT NOT NULL,
	ship_date DATETIME DEFAULT NULL,
	deliver_date DATETIME DEFAULT NULL,
	PRIMARY KEY(order_id,product_id),
	FOREIGN KEY  (order_id) REFERENCES orders(id) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY  (product_id) REFERENCES product(id) ON UPDATE CASCADE ON DELETE CASCADE
);




