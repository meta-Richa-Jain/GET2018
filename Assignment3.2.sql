#Assignment3
#Question2

# Display the list of products (Id, Title, Count of Categories) which fall in more than
# one Categories.

SELECT a.product_id, p.title, a.count_of_category  
FROM ((SELECT  pcr.product_id ,count(*) as count_of_category 
FROM product_category_relation pcr
GROUP BY pcr.product_id 
HAVING COUNT(*) > 1) a, 
product p) 
WHERE a.product_id = p.id;

# Display Count of products as per price range

SELECT p.range, count(*) as count_of_products
FROM (SELECT 
	CASE
		WHEN amount BETWEEN 0 AND 100 THEN '0-100'
        WHEN amount BETWEEN 101 AND 500 THEN '101-500'
        ELSE 'Above 500'
	END AS 'range'
from product)p
 GROUP BY p.range; 

# Display the Categories along with number of products under each category.
SELECT c.id, c.title, a.count_of_products FROM(
(SELECT pcr.category_id, count(pcr.category_id) as count_of_products
FROM product_category_relation pcr 
GROUP BY pcr.category_id) a, category c)
where c.id = a.category_id
ORDER BY c.id;