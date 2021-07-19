drop table if exists categories cascade;
create table categories
(
    id    serial,
    title varchar(255),
    primary key (id)
);
insert into categories (title)
values ('food'),
       ('supply'),
       ('other');

drop table if exists products cascade;
create table products
(
    id          bigserial,
    title       varchar(255),
    description varchar(5000),
    price       integer,
    category_id integer references categories (id),
    primary key (id)
);
insert into products (title, description, price, category_id)
values ('bread', '', 20, 1),
       ('sugar', '', 40, 2),
       ('salem', '', 100, 1),
       ('apples', '', 200, 2),
       ('orange', '', 200, 1),
       ('banana', '', 100, 2);
/*('tea','',100),
('A1', '', 1),
('A2', '', 2),
('A3', '', 3),
('A4', '', 4),
('A5', '', 5),
('A6', '', 6),
('A7', '', 7),
('A8', '', 8),
('A9', '', 9),
('A10', '', 10),
('A11', '', 11),
('A12', '', 12),
('A13', '', 13),
('A14', '', 14),
('A15', '', 15),
('A16', '', 16),
('A17', '', 17),
('A18', '', 18),
('A19', '', 19),
('A20', '', 20);*/


