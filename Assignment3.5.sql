# Question5

# Create a view displaying the order information (Id, Title, Price, Shopper’s name,
# Email, Orderdate, Status) with latest ordered items should be displayed first for
# last 60 (converted to 200 to retrieve data) days.


CREATE VIEW order_info 
 AS
  SELECT o.id as order_id, o.user_id, o.total_amount, u.first_name, u.email_id, o.placed_date, i.product_id, i.status as product_status, i.quantity
	FROM orders o, users u, items_status i
    WHERE o.user_id = u.id AND o.placed_date BETWEEN NOW() - INTERVAL 200 DAY AND NOW() AND i.order_id = o.id
    ORDER BY o.placed_date DESC;
        
SELECT *
FROM order_info;
# Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT   oi.product_id
FROM order_info oi
WHERE oi.product_status = 'shipped';

# Use the above view to display the top 5 most selling products.

SELECT oi.product_id, sum(oi.quantity) as quantity
FROM order_info oi
GROUP BY oi.product_id
ORDER BY quantity DESC LIMIT 5;