#Assignment2
use storefront;

#Display Recent 50 Orders placed(Id, Order Date, Order Total)
select id,placed_date,total_amount 
from orders 
order by placed_date desc limit 50;

#Display 10 most expensive Orders.
select id,total_amount
from orders
order by total_amount desc limit 10;

#Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
select o.id , o.total_amount
from orders o
where
o.placed_date < (DATE_SUB(CURDATE(), INTERVAL 10 DAY))
and
o.id IN (select distinct istatusnested.id from items_status istatusnested where istatusnested.status="placed");

#Display list of shoppers which haven't ordered anything since last month.
select id, first_name 
from users
where users.id NOT IN
(
select id as active_user 
from users U inner join orders O
on U.id=O.user_id
where placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH))
);

#Display list of shopper along with orders placed by them in last 15 days.
select DISTINCT u.id , u.first_name,u.last_name, o.placed_date
from users u, orders o
where placed_date > (DATE_SUB(CURDATE(), INTERVAL 1 MONTH)) ;

#Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
select p.id , p.title
from product p inner join items_status i_status
on p.id = i_status.product_id
where i_status.status="shipped" and i_status.order_id=7;

#Display list of order items along with order placed date which fall between Rs 200 to Rs 500 price.
select p.title , o.placed_date
from product p inner join items_status i_status
on i_status.product_id=p.id
inner join orders o
on o.id = i_status.order_id
where p.amount >=200 and p.amount<=500;

#Update first 20 Order items status to “Shipped” which are placed today.
SET SQL_SAFE_UPDATES = 0;
update items_status 
inner join 
orders 
on orders.id=items_status .order_id
set items_status .status="shipped"
where orders.placed_date=curdate();
