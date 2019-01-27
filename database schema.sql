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
  discount int
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

/
create or replace function generate_id(p_table varchar2) 
return int as
v_max_id int;
begin
execute immediate 'select max(id) from '||p_table into v_max_id;
if v_max_id is null then
  return 1;
end if;
return v_max_id+1;
end;
/
insert into tables (id,seats,available) values(1,6,0);
insert into tables (id,seats,available) values(2,9,0);
insert into tables (id,seats,available) values(3,8,0);
insert into tables (id,seats,available) values(4,4,0);

insert into item (id,name,description,price) values (1,'fried potatoes','best fried potatoes',3.6);
insert into item (id,name,description,price) values (2,'cheesecake','best cheesecake',5.9);
insert into item (id,name,description,price) values (3,'wine','best wine',9.9);
insert into item (id,name,description,price) values (4,'burger','best burger',4);
insert into item (id,name,description,price) values (5,'stake','best stake',21.2);
insert into item (id,name,description,price) values (6,'stake','best stake',99.9);

insert into table_order (id,table_id,order_date) values (1,1,CURRENT_TIMESTAMP);
insert into table_order (id,table_id,order_date) values (2,2,CURRENT_TIMESTAMP);

insert into order_details (id,order_id,item_id,quantity) values (1,1,1,1);
insert into order_details (id,order_id,item_id,quantity) values (2,1,2,1);
insert into order_details (id,order_id,item_id,quantity) values (3,1,3,1);
insert into order_details (id,order_id,item_id,quantity) values (4,1,4,2);
insert into order_details (id,order_id,item_id,quantity) values (5,2,5,1);
insert into order_details (id,order_id,item_id,quantity) values (6,2,6,2);