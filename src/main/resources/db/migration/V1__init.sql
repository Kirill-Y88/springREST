create table orders (id bigserial primary key, username varchar(255));
insert into orders (username) values
('user1'),
('user2'),
('user3');
create table products (id bigserial primary key, name varchar(255), cost int);
insert into products (name, cost) values
('Potato', 80),
('Potato', 82),
('Potato', 85),
('Orange', 10),
('Onion', 99),
('Pizza', 50),
('Chicken', 75),
('Cucumber', 26),
('Pepper', 74),
('Lemon', 80),
('Banana', 21),
('Sandwich', 92),
('Grapes', 54),
('Salad', 80),
('Melon', 73),
('Avocado', 37),
('Egg', 86),
('Bread', 52),
('Bread', 55),
('Bread', 58),
('Bread', 61),
('Rice', 52),
('cookie', 96),
('Tomato', 42),
('Corn', 35),
('Cake', 87),
('Salt', 12),
('Apple', 52),
('Meat', 56),
('Cheese', 88);
create table product_orders (product_id int REFERENCES products(id), order_id int REFERENCES orders(id));
insert into product_orders (product_id, order_id) values
(1, 1),
(10, 1),
(11, 1),
(9, 2),
(5, 3),
(15, 3);
