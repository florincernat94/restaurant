
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
price number
);

create table bill(
id number,
table_id number,
amount number
);

create table tables(
id number,
seats number,
taken number(1)
);