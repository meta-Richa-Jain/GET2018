CREATE DATABASE StoreFront;
USE StoreFront;
#Question 1
#Create all tables of eCommerce Application: StoreFront 

#table user_type
CREATE TABLE user_type(
	type_id INT PRIMARY KEY AUTO_INCREMENT,
    type_name VARCHAR(15)
);

#table users
CREATE TABLE users(
user_id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(25) not null,
last_name VARCHAR(25) ,
user_password VARCHAR(10) not null,
email_id VARCHAR(50) not null,
user_type INT,
FOREIGN KEY  (user_type) REFERENCES user_type(type_id)
);


#table address
CREATE TABLE address(
address_id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT ,
area VARCHAR(25) not null,
city VARCHAR(25) not null ,
state VARCHAR(25) not null ,
country VARCHAR(25) default "india",
pin_code INT not null,
FOREIGN KEY  (user_id) REFERENCES users(user_id)
);

#table category
CREATE TABLE category(
category_id INT PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(25) ,
parent_category INT null,
FOREIGN KEY  (parent_category) REFERENCES category(category_id)
);

#table product
CREATE TABLE product(
	product_id INT PRIMARY KEY AUTO_INCREMENT,
	product_name VARCHAR(25) not null,
	product_description VARCHAR(50),
	amount INT,
	stock INT,
    product_date DATE
);

#table product category relation
CREATE TABLE product_category_relation(
product_id INT,
category_id INT,
PRIMARY KEY(product_id,category_id),
FOREIGN KEY  (product_id) REFERENCES product (product_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY  (category_id) REFERENCES category(category_id) ON UPDATE CASCADE ON DELETE CASCADE
);

#table image
CREATE TABLE image(
image_id INT PRIMARY KEY AUTO_INCREMENT,
url VARCHAR(25),
image_name VARCHAR(25),
product_id INT,
FOREIGN KEY  (product_id) REFERENCES product(product_id)
);

#table orders
CREATE TABLE orders(
order_id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,
bill_amount INT,
placed_date DATE,
address_id INT,
FOREIGN KEY  (address_id) REFERENCES address(address_id),
FOREIGN KEY  (user_id) REFERENCES users(user_id)
);

#table items status
CREATE TABLE items_status(
order_id INT,
product_id INT,
status VARCHAR(10) CHECK(status IN ("placed", "shipped", "delivered", "cancelled", "returned")),
quantity INT,
ship_date DATE,
deliver_date DATE,
PRIMARY KEY(order_id,product_id),
FOREIGN KEY  (order_id) REFERENCES orders(order_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY  (product_id) REFERENCES product(product_id) ON UPDATE CASCADE ON DELETE CASCADE
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
	product_id INT PRIMARY KEY AUTO_INCREMENT,
	product_name VARCHAR(25) not null,
	product_description VARCHAR(50),
	amount INT,
	stock INT,
    product_date DATE
);

CREATE TABLE product_category_relation(
product_id INT,
category_id INT,
PRIMARY KEY(product_id,category_id),
FOREIGN KEY  (product_id) REFERENCES product (product_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY  (category_id) REFERENCES category(category_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE image(
image_id INT PRIMARY KEY AUTO_INCREMENT,
url VARCHAR(25),
image_name VARCHAR(25),
product_id INT,
FOREIGN KEY  (product_id) REFERENCES product(product_id)
);  

CREATE TABLE items_status(
order_id INT,
product_id INT,
status VARCHAR(10) CHECK(status IN ("placed", "shipped", "delivered", "cancelled", "returned")),
quantity INT,
ship_date DATE,
deliver_date DATE,
PRIMARY KEY(order_id,product_id),
FOREIGN KEY  (order_id) REFERENCES orders(order_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY  (product_id) REFERENCES product(product_id) ON UPDATE CASCADE ON DELETE CASCADE
);




