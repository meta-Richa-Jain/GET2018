USE storefront;

INSERT INTO user_type(title) VALUES("admininstrator");
INSERT INTO user_type(title) VALUES("shopper");

INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("richa","jain","richa","richa@gmail.com",1); 
INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("tanu","mittal","tanu","tanu@gmail.com",2); 
INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("arjita","marelay","arjita","arjita@gmail.com",2); 
INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("prakalpa","rathore","prakalpa","prakalpa@gmail.com",2); 
INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("deekshika","sharma","deekshika","deekshika@gmail.com",2); 
INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("aastha","bharadwaj","aastha","aastha@gmail.com",2); 

INSERT INTO zip_code(pin_code, area, city, state) VALUES(102,"sitapura","jaipur","raj");
INSERT INTO zip_code(pin_code, area,city,state) VALUES(123,"jayanti nagar","aligarh","up");
INSERT INTO zip_code(pin_code, area,city,state) VALUES(103,"iet","alwar","raj");

INSERT INTO address(user_id,pin_code) VALUES(2,102);
INSERT INTO address(user_id,pin_code) VALUES(3,123);
INSERT INTO address(user_id,pin_code) VALUES(4,103);
INSERT INTO address(user_id,pin_code) VALUES(5,102);
INSERT INTO address(user_id,pin_code) VALUES(6,102);


INSERT INTO category(title) VALUES ("Electronics");
INSERT INTO category(title) VALUES ("TV Appliances");
INSERT INTO category(title) VALUES ("Clothing");
INSERT INTO category(title,parent_category) VALUES ("Mobile", 1);
INSERT INTO category(title,parent_category) VALUES ("TV", 2);
INSERT INTO category(title,parent_category) VALUES ("shirts", 3);

INSERT INTO product(title, description, amount, stock,arrival_date) VALUES ("P1", "product 1", 500,5,'2017-08-01 10:15:00');
INSERT INTO product(title, description, amount, stock,arrival_date) VALUES ("P2", "product 2", 1000,4,'2017-11-01 10:15:00');
INSERT INTO product(title, description, amount, stock,arrival_date) VALUES ("P3", "product 3", 500,3,'2017-06-01 10:15:00');
INSERT INTO product(title, description, amount, stock,arrival_date) VALUES ("P4", "product 4", 600,5,'2017-06-01 10:15:00');
INSERT INTO product(title, description, amount, stock,arrival_date) VALUES ("P5", "product 5", 700,10,'2017-07-01 10:15:00');
INSERT INTO product(title, description, amount, stock,arrival_date) VALUES ("P6", "product 6", 100,5,'2017-12-01 10:15:00');
INSERT INTO product(title, description, amount, stock,arrival_date) VALUES ("P7", "product 7", 200,4,'2017-02-01 10:15:00'); 

INSERT INTO image (url, title, product_id) VALUES ("product1 url1", "image1 product1", 1);
INSERT INTO image (url, title, product_id) VALUES ("product1 url2", "image2 product1", 1);
INSERT INTO image (url, title, product_id) VALUES ("product1 url3", "image3 product1", 1);
INSERT INTO image (url, title, product_id) VALUES ("product2 url1", "image1 product2", 2);
INSERT INTO image (url, title, product_id) VALUES ("product2 url2", "image2 product2", 2);
INSERT INTO image (url, title, product_id) VALUES ("product2 url3", "image3 product2", 2);
INSERT INTO image (url, title, product_id) VALUES ("product2 url4", "image4 product2", 2);
INSERT INTO image (url, title, product_id) VALUES ("product5 url1", "image1 product5", 5);
INSERT INTO image (url, title, product_id) VALUES ("product5 url2", "image2 product5", 5);
INSERT INTO image (url, title, product_id) VALUES ("product6 url1", "image1 product6", 6);
INSERT INTO image (url, title, product_id) VALUES ("product6 url2", "image2 product6", 6);

INSERT INTO product_category_relation(product_id, category_id) VALUES(1,1);
INSERT INTO product_category_relation(product_id, category_id) VALUES(2,1);
INSERT INTO product_category_relation(product_id, category_id) VALUES(3,1);
INSERT INTO product_category_relation(product_id, category_id) VALUES(4,2);
INSERT INTO product_category_relation(product_id, category_id) VALUES(5,3);
INSERT INTO product_category_relation(product_id, category_id) VALUES(5,1);
INSERT INTO product_category_relation(product_id, category_id) VALUES(6,4);
INSERT INTO product_category_relation(product_id, category_id) VALUES(6,2);
INSERT INTO product_category_relation(product_id, category_id) VALUES(7,5);

# INSERT INTO orders(user_id,total_amount,placed_date, address_id) VALUES (2,1000,'2018-08-15 17:45:03',1);
# INSERT INTO orders(user_id,total_amount,placed_date, address_id) VALUES (2,1000,'2018-08-17 11:15:03',1);
INSERT INTO orders(user_id,total_amount,placed_date, address_id) VALUES (3,100,'2018-07-01 15:22:00',2);
INSERT INTO orders(user_id,total_amount,placed_date, address_id) VALUES (4,500,'2018-02-15 08:00:03',3);
INSERT INTO orders(user_id,total_amount,placed_date, address_id) VALUES (4,700,'2018-03-12 12:45:03',3);
INSERT INTO orders(user_id,total_amount,placed_date, address_id) VALUES (5,600,'2018-05-05 17:08:15',4);
INSERT INTO orders(user_id,total_amount,placed_date, address_id) VALUES (5,400,'2018-07-22 16:37:26',4);
INSERT INTO orders(user_id,total_amount,placed_date, address_id) VALUES (6,1200,'2018-06-27 21:54:12',5);


# INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (1,1,"delivered",1,'2018-08-15 21:54:12','2018-08-16 12:45:03');
# INSERT INTO items_status(order_id, product_id,status,quantity) VALUES (2,6,"placed",4);
INSERT INTO items_status(order_id, product_id,status,quantity) VALUES (3,2,"cancelled",3);
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (4,3,"returned",1,'2018-02-15 08:00:03','2018-08-16 11:15:03');
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (5,7,"delivered",1,'2018-03-12','2018-08-16 11:31:57');
INSERT INTO items_status(order_id, product_id,status,quantity) VALUES (5,4,"placed",1);
INSERT INTO items_status(order_id, product_id,status,quantity) VALUES (6,4,"placed",1);
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date) VALUES (7,5,"shipped",1,'2018-07-22 08:00:03');
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date) VALUES (8,5,"cancelled",1,'2018-06-27 21:54:12');



# Display Id, Title, Category Title, Price of the products which are Active and recently
# added products should be at top.
SELECT p.id, p.title, c.id, p.amount
from product p, category c, product_category_relation pcr
where p.stock > 0 AND pcr.product_id = p.id AND pcr.category_id = c.id
order by p.arrival_date DESC;

# Display the list of products which don't have any images.
SELECT DISTINCT product.title
FROM product
WHERE NOT EXISTS (SELECT * FROM image
WHERE
product.id = image.product_id);

# Display the list of Products whose Quantity on hand (Inventory) is under 50
SELECT title
FROM product
WHERE stock <50;

# Increase the Inventory of all the products by 100
UPDATE product
set stock = stock + 100;

# Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT p.title, p.description, p.amount
FROM product p, category c, product_category_relation pcr
WHERE p.id = pcr.product_id AND c.id = pcr.category_id AND c.title = "Mobile";

# Display Id, Title, Parent Category Title of all the leaf Categories 
# (categories which are not parent of any other category)
SELECT child.id, child.title, IFNULL(parent.title, 'Top Category') AS parent_category
FROM category child
INNER JOIN category parent
ON child.parent_category = parent.id
WHERE child.id NOT IN (SELECT DISTINCT parent_category FROM category WHERE parent_category IS NOT NULL)

