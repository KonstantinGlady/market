drop table if exists products cascade;
create table products(id bigserial, name varchar(255), description varchar(5000) primary key(id));
insert products (id, name, descrition) values
('bread','',20),
('sugar','',40),
('salem','',100)
('apples','',200)
('orange','',200)
('banana','',100)
('tea','',100);