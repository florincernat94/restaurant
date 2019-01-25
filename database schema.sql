drop table customer;
drop table employee;
drop table item;
drop table bill;
drop table table_order;
drop table tables;
drop table order_details;

create table customer(
id number,
email varchar2(50char),
password varchar2(50 char),
address varchar2(100 char)
);

create table employee(
id number,
full_name varchar2(50 char),
email varchar2(50 char),
password varchar2(50 char)
);

create table item(
id number,
name varchar2(40 char),
description varchar2(120 char),
price float
);

create table bill(
  id number,
  table_id number,
  amount float,
  bill_date timestamp,
  discount float
);

create table tables(
  id number,
  seats number,
  available number(1)
);

create table table_order(
id number,
table_id number,
order_date timestamp
);

create table order_details(
id number,
order_id number,
item_id number,
quantity integer
);

insert into tables (id,seats,available) values(1,6,0);
insert into tables (id,seats,available) values(2,9,0);
insert into tables (id,seats,available) values(3,8,0);
insert into tables (id,seats,available) values(4,4,0);