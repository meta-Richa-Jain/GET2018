#Assignment4
#Question1
USE storefront;
 
DROP FUNCTION IF EXISTS calculate_orders;
DROP FUNCTION IF EXISTS max_month;
# Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE FUNCTION calculate_orders(month INT, year INT) RETURNS INT
 DETERMINISTIC
  BEGIN
  
	DECLARE num_of_orders INT ;
    SET num_of_orders =0;
   
	SELECT count(o.id) INTO num_of_orders
	FROM orders o
	WHERE MONTH(o.placed_date) = month AND YEAR(o.placed_date) = year;
    RETURN num_of_orders;
     
END $$
     
SELECT calculate_orders(7,2018) as num_of_orders;    
SELECT calculate_orders(2,2018) as num_of_orders; 

# Create a function to return month in a year having maximum orders. Year will be input parameter.   

DELIMITER $$
CREATE FUNCTION max_month(year INT) RETURNS INT
DETERMINISTIC
BEGIN

DECLARE max_orders_month INT;
SET max_orders_month =0;

SELECT  month(o.placed_date) INTO max_orders_month
FROM orders o
WHERE year = year(o.placed_date)
GROUP BY month(o.placed_date)
ORDER BY count(o.placed_date) DESC LIMIT 1;
RETURN max_orders_month;
END $$


SELECT max_month(2018) as month_with_highest_order;