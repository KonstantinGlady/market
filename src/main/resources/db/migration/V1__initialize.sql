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
       ('banana', '', 100, 2),
       ('tea', '', 100, 2),
       ('A1', '', 1, 1),
       ('A2', '', 2, 1),
       ('A3', '', 3, 1),
       ('A4', '', 4, 2),
       ('A5', '', 5, 3),
       ('A6', '', 6, 1),
       ('A7', '', 7, 2),
       ('A8', '', 8, 3),
       ('A9', '', 9, 2),
       ('A10', '', 10, 1),
       ('A11', '', 11, 1),
       ('A12', '', 12, 2),
       ('A13', '', 13, 2),
       ('A14', '', 14, 2),
       ('A15', '', 15, 2),
       ('A16', '', 16, 2),
       ('A17', '', 17, 2),
       ('A18', '', 18, 2),
       ('A19', '', 19, 2),
       ('A20', '', 20, 2);


