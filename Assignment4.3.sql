# Assignment 4
# Question3

# Identify the columns require indexing in order, product, category tables and create indexes.

ALTER TABLE orders ADD INDEX user_id_index(user_id);
ALTER TABLE orders ADD INDEX placed_date_index(placed_date);
SHOW INDEX FROM orders;

ALTER TABLE product ADD INDEX title_index(title);
ALTER TABLE product ADD INDEX amount_index(amount);
SHOW INDEX FROM product;

ALTER TABLE category ADD UNIQUE title_index(title);
ALTER TABLE category ADD INDEX parent_category_index(parent_category);
SHOW INDEX FROM category;

ALTER TABLE product_category_relation ADD INDEX category_id_index(category_id);
SHOW INDEX FROM product_category_relation;

ALTER TABLE items_status ADD INDEX product_id_index(product_id);
ALTER TABLE items_status ADD INDEX status_index(status);
SHOW INDEX FROM items_status;