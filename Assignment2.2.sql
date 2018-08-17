USE storefront;

INSERT INTO user_type(type_id , type_name) VALUES(1,"admininstrator");
INSERT INTO user_type(type_id , type_name) VALUES(2,"shopper");

INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("richa","jain","richa","richa@gmail.com",1); 
INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("tanu","mittal","tanu","tanu@gmail.com",2); 
INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("arjita","marelay","arjita","arjita@gmail.com",2); 
INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("prakalpa","rathore","prakalpa","prakalpa@gmail.com",2); 
INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("deekshika","sharma","deekshika","deekshika@gmail.com",2); 
INSERT INTO users(first_name,last_name,user_password,email_id,user_type) VALUES("chirag","jain","chirag","chirag@gmail.com",2); 


INSERT INTO address(user_id,area,city,state,pin_code) VALUES(2,"sitapura","jaipur","raj",102);
INSERT INTO address(user_id,area,city,state,pin_code) VALUES(3,"jayanti nagar","aligarh","up",123);
INSERT INTO address(user_id,area,city,state,pin_code) VALUES(4,"iet","alwar","raj",103);
INSERT INTO address(user_id,area,city,state,pin_code) VALUES(5,"sitapura","jaipur","raj",102);
INSERT INTO address(user_id,area,city,state,pin_code) VALUES(6,"sitapura","jaipur","raj",102);

INSERT INTO category(category_name,parent_category) VALUES ("Electronics", null);
INSERT INTO category(category_name,parent_category) VALUES ("TV Appliances", null);
INSERT INTO category(category_name,parent_category) VALUES ("Clothing", null);
INSERT INTO category(category_name,parent_category) VALUES ("Mobile", 1);
INSERT INTO category(category_name,parent_category) VALUES ("TV", 2);
INSERT INTO category(category_name,parent_category) VALUES ("shirts", 3);

INSERT INTO product(product_name, product_description, amount, stock) VALUES ("P1", "product 1", 500,5);
INSERT INTO product(product_name, product_description, amount, stock) VALUES ("P2", "product 2", 1000,4);
INSERT INTO product(product_name, product_description, amount, stock) VALUES ("P3", "product 3", 500,3);
INSERT INTO product(product_name, product_description, amount, stock) VALUES ("P4", "product 4", 600,5);
INSERT INTO product(product_name, product_description, amount, stock) VALUES ("P5", "product 5", 700,10);
INSERT INTO product(product_name, product_description, amount, stock) VALUES ("P6", "product 6", 100,5);
INSERT INTO product(product_name, product_description, amount, stock) VALUES ("P7", "product 7", 200,4); 

INSERT INTO image (url, image_name, product_id) VALUES ("product1 url1", "image1 product1", 1);
INSERT INTO image (url, image_name, product_id) VALUES ("product1 url2", "image2 product1", 1);
INSERT INTO image (url, image_name, product_id) VALUES ("product1 url3", "image3 product1", 1);
INSERT INTO image (url, image_name, product_id) VALUES ("product2 url1", "image1 product2", 2);
INSERT INTO image (url, image_name, product_id) VALUES ("product2 url2", "image2 product2", 2);
INSERT INTO image (url, image_name, product_id) VALUES ("product2 url3", "image3 product2", 2);
INSERT INTO image (url, image_name, product_id) VALUES ("product2 url4", "image4 product2", 2);
INSERT INTO image (url, image_name, product_id) VALUES ("product5 url1", "image1 product5", 5);
INSERT INTO image (url, image_name, product_id) VALUES ("product5 url2", "image2 product5", 5);
INSERT INTO image (url, image_name, product_id) VALUES ("product6 url1", "image1 product6", 6);
INSERT INTO image (url, image_name, product_id) VALUES ("product6 url2", "image2 product6", 6);

INSERT INTO product_category_relation(product_id, category_id) VALUES(1,1);
INSERT INTO product_category_relation(product_id, category_id) VALUES(2,1);
INSERT INTO product_category_relation(product_id, category_id) VALUES(3,1);
INSERT INTO product_category_relation(product_id, category_id) VALUES(4,2);
INSERT INTO product_category_relation(product_id, category_id) VALUES(5,3);
INSERT INTO product_category_relation(product_id, category_id) VALUES(6,4);
INSERT INTO product_category_relation(product_id, category_id) VALUES(7,5);

INSERT INTO orders(user_id,bill_amount,placed_date, address_id) VALUES (2,1000,'2018-08-15',1);
INSERT INTO orders(user_id,bill_amount,placed_date, address_id) VALUES (2,1000,'2018-08-17',1);
INSERT INTO orders(user_id,bill_amount,placed_date, address_id) VALUES (3,100,'2018-07-01',2);
INSERT INTO orders(user_id,bill_amount,placed_date, address_id) VALUES (4,500,'2018-02-15',3);
INSERT INTO orders(user_id,bill_amount,placed_date, address_id) VALUES (4,700,'2018-03-12',3);
INSERT INTO orders(user_id,bill_amount,placed_date, address_id) VALUES (5,600,'2018-05-05',4);
INSERT INTO orders(user_id,bill_amount,placed_date, address_id) VALUES (5,400,'2018-07-22',4);
INSERT INTO orders(user_id,bill_amount,placed_date, address_id) VALUES (6,1200,'2018-06-27',5);


INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (1,1,"delivered",1,'2018-08-15','2018-08-16');
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (2,6,"placed",4,'2018-08-17','2018-08-20');
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (3,2,"cancelled",3,'2018-07-01','2018-08-16');
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (4,3,"returned",1,'2018-02-15','2018-08-16');
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (5,7,"delivered",1,'2018-03-12','2018-08-16');
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (5,4,"placed",1,'2018-03-12','2018-08-16');
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (6,4,"placed",1,'2018-05-05','2018-08-16');
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (7,5,"shipped",1,'2018-07-22','2018-08-16');
INSERT INTO items_status(order_id, product_id,status,quantity,ship_date,deliver_date) VALUES (8,5,"cancelled",1,'2018-06-27','2018-08-16');



# Display Id, Title, Category Title, Price of the products which are Active and recently
# added products should be at top.
SELECT p.product_id, p.product_name, c.category_id, p.amount
from product p, category c, product_category_relation pcr
where p.stock > 0 AND pcr.product_id = p.product_id AND pcr.category_id = c.category_id
order by p.product_date DESC;

# Display the list of products which don't have any images.
SELECT DISTINCT product.product_name
FROM product
WHERE NOT EXISTS (SELECT * FROM image
WHERE
product.product_id = image.product_id);

# Display the list of Products whose Quantity on hand (Inventory) is under 50
SELECT product_name
FROM product
WHERE stock <50;

# Increase the Inventory of all the products by 100
UPDATE product
set stock = stock + 100;

# Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT p.product_name, p.product_description, p.amount
FROM product p, category c, product_category_relation pcr
WHERE p.product_id = pcr.product_id AND c.category_id = pcr.category_id AND c.category_name = "Mobile";

# Display Id, Title, Parent Category Title of all the leaf Categories 
# (categories which are not parent of any other category)
SELECT child.category_id, child.category_name, IFNULL(parent.category_name, 'Top Category') AS parent_category
FROM category child
INNER JOIN category parent
ON child.parent_category = parent.category_id
WHERE child.category_id NOT IN (SELECT DISTINCT parent_category FROM category WHERE parent_category IS NOT NULL)

