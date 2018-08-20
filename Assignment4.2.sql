# Assignment4
# Question2

# Create a Stored procedure to retrieve average sales of each product in a month. 
# Month and year will be input parameter to function.

USE storefront;

DROP PROCEDURE IF EXISTS average_sales;
DROP PROCEDURE IF EXISTS orders_status;
DROP FUNCTION IF EXISTS set_date;

DELIMITER $$

CREATE PROCEDURE average_sales(IN month INT, IN year INT)
BEGIN
SELECT p.title, (COUNT(i.product_id)/SUM(i.product_id)*100) as avg_sales
FROM product p
INNER JOIN items_status i ON p.id = i.product_id
INNER JOIN orders o ON o.id = i.order_id
WHERE YEAR(o.placed_date) = year AND MONTH(o.placed_date) = month
GROUP BY i.product_id;
END $$
 
 CALL average_sales(7,2018);
 
 
/*
Function to put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date.
*/
 
DELIMITER $$

CREATE FUNCTION set_date(start_date DATE, end_date DATE)
RETURNS DATE
BEGIN
DECLARE new_start_date DATE;
IF start_date < end_date THEN
RETURN start_date;
ELSE
SET new_start_date = start_date - INTERVAL DAY(start_date) DAY + INTERVAL 1 DAY ;
RETURN new_start_date;
END IF;
END $$


/* Create a stored procedure to retrieve table having order detail with status
for a given period. Start date and end date will be input parameter. 
Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date.
*/

DELIMITER $$
CREATE PROCEDURE orders_status(IN start_date DATE, IN end_date DATE)
BEGIN
DECLARE new_start_date DATE;
SET new_start_date := (SELECT set_date(start_date,end_date));
SELECT i.order_id, i.product_id, i.status, p.title, o.placed_date
FROM items_status i
INNER JOIN orders o
ON o.id = i.order_id
INNER JOIN product p
ON p.id = i.product_id
WHERE o.placed_date BETWEEN new_start_date AND end_date;
END $$

# SELECT set_date('2018-07-26', '2018-07-25');
CALL orders_status('2018-07-26', '2018-07-25');

