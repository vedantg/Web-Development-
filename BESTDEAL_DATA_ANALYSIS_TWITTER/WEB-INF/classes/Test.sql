create database bestdealdatabase;

use bestdealdatabase;

create table SignUp(userid varchar(40),password varchar(40),email varchar(40),
phone varchar(40));

create table CartProducts(key_name varchar(40),p_id varchar(40),p_name varchar(40),p_retailer varchar(40), p_condition varchar(40), p_price int, p_image varchar(60));

create table orderhistory(orderId varchar(40),firstName varchar(40),lastName varchar(40) ,price varchar(40),address varchar(40),phone varchar(40),creditCard varchar(40));
ALTER TABLE XMLProducts DROP COLUMN P_accessories;

drop table CartProducts;

delete from cartproducts where p_id='L001';

update orderhistory set
orderId = '12324',
firstName = 'vedantg',
lastName = 'godg',
price = '321',
address = 'Chicago B',
phone = '1233',
creditCard = '1221312'
Where orderId = '12324';
-- other column values etc
;

insert into orderhistory ( orderId, firstName,lastName,price,address,phone,creditCard )
                       VALUES
                       ( '12324', 'vedant','god','123','chicago','1233','3143424' );
select * from CartProducts;
select * from orderhistory;


INSERT INTO `bestdealdatabase`.`reviewtable`
(`key_name`,
`p_id`,
`p_name`,
`p_retailer`,
`p_condition`,
`p_price`,
`p_image`)
VALUES
('Laptop',
'L005',
'HCL90',
'HCL',
'Refurbished',
'299',
'images/lp_05.jpg');

select * from reviewtable;

truncate CartProducts;
truncate orderhistory;
desc CartProducts;

select * from CartProducts WHERE p_id='S001';

