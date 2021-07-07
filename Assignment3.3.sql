#Question3

# Display Shopper’s information along with number of orders he/she placed during
# last 30 days.

SELECT u.id, u.first_name, u.last_name, o.id, o.total_amount, count(*) as no_of_orders
FROM users u, orders o
where u.id = o.user_id AND
o.placed_date  BETWEEN NOW() - INTERVAL 30 DAY AND NOW()
GROUP BY u.id;


# Display the top 10 Shoppers who generated maximum number of revenue in last
# 30 days.

SELECT u.id as user_id, u.first_name, u.last_name, o.id as order_id, o.total_amount
FROM users u, orders o
where u.id = o.user_id AND
o.placed_date  BETWEEN NOW() - INTERVAL 30 DAY AND NOW()
GROUP BY u.id
ORDER BY o.total_amount DESC LIMIT 10;

# Display top 20 Products which are ordered most in last 60 days along with numbers.

SELECT  i.product_id , sum(i.quantity) as quantity_ordered
FROM items_status i, orders o
where o.placed_date BETWEEN NOW() - INTERVAL 60 DAY AND NOW() AND o.id = i.order_id
GROUP BY i.product_id
ORDER BY quantity_ordered DESC;

# Display Monthly sales revenue of the StoreFront for last 6 months. It should
# display each month’s sale.

SELECT MONTH(o.placed_date) as month, sum(o.total_amount) as monthly_revenue
FROM orders o
WHERE o.placed_date < Now() and o.placed_date > DATE_ADD(Now(), INTERVAL- 6 MONTH)
GROUP BY MONTH(o.placed_date);

# Mark the products as Inactive which are not ordered in last 90 days.

SELECT product.id FROM product
WHERE product.id NOT IN ( SELECT DISTINCT p.id as inactive
FROM product p, items_status i, orders o
WHERE p.id = i.product_id AND o.placed_date BETWEEN NOW() - INTERVAL 90 DAY AND NOW() 
AND o.id = i.order_id);

# Given a category search keyword, display all the Products present in this
# category/categories.

select a.product_id,b.title from
(SELECT DISTINCT p.product_id from  product_category_relation p
WHERE category_id IN
(SELECT c .id as category_id
FROM category c
WHERE c.title LIKE 'T%'))a ,product b where a.product_id=b.id;

# Display top 10 Items which were cancelled most.

SELECT  i.product_id , sum(i.quantity) as quantity_ordered, i.status
FROM items_status i
where i.status = "cancelled"
GROUP BY i.product_id
ORDER BY quantity_ordered DESC LIMIT 10;