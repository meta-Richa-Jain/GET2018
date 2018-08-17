#Assignment3
use storefront;

#Display Recent 50 Orders placed(Id, Order Date, Order Total)
select order_id,placed_date,bill_amount 
from orders 
order by placed_date desc limit 50;

#Display 10 most expensive Orders.
select order_id,bill_amount
from orders
order by bill_amount desc limit 10;

#Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
select o.order_id , o.bill_amount
from orders o
where
o.placed_date < (DATE_SUB(CURDATE(), INTERVAL 10 DAY))
and
o.order_id IN (select distinct ostatusnested.order_id from items_status ostatusnested where ostatusnested.status="placed");

#Display list of shoppers which haven't ordered anything since last month.
select user_id, first_name 
from users
where users.user_id NOT IN
(
select user_id as active_user 
from users U inner join orders O
on U.user_id=O.user_id
where ship_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH))
);

#Display list of shopper along with orders placed by them in last 15 days.
select DISTINCT u.user_id , u.first_name,u.last_name, o.placed_date
from users u, orders o
where placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH)) ;

#Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
select p.product_id , p.product_name
from product p inner join items_status i_status
on p.product_id = i_status.product_id
where i_status.status="shipped" and i_status.order_id=7;

#Display list of order items along with order placed date which fall between Rs 200 to Rs 500 price.
select p.product_name , o.placed_date
from product p inner join items_status i_status
on i_status.product_id=p.product_id
inner join orders o
on o.order_id = i_status.order_id
where p.amount >=200 and p.amount<=500;

#Update first 20 Order items status to “Shipped” which are placed today.
SET SQL_SAFE_UPDATES = 0;
update items_status 
inner join 
orders 
on orders.order_id=items_status .order_id
set items_status .status="shipped"
where orders.placed_date=curdate();
